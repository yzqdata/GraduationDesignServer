package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.zyd.shiro.business.entity.ClubMembershipEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.entity.UserRole;
import com.zyd.shiro.business.service.ClubMembershipService;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.service.SysUserRoleService;
import com.zyd.shiro.business.service.SysUserService;
import com.zyd.shiro.business.vo.ClubMembershipVO;
import com.zyd.shiro.persistence.beans.ClubMembership;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.persistence.mapper.ClubMembershipMapper;
import com.zyd.shiro.persistence.mapper.ClubRegistrationApplicationsMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:40
 * @Description
 */
@Service
public class ClubMembershipServiceImpl implements ClubMembershipService {

    @Autowired
    private ClubMembershipMapper clubMembershipMapper;

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ClubMembershipService clubMembershipService;

    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Override
    public PageInfo<ClubMembership> findPageBreakByCondition(ClubMembershipVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        UserRole userRole = new UserRole();
        userRole.setUserId((long)applicationId);
        Long roleId = sysUserRoleService.getOneByEntity(userRole).getRoleId();
        List<ClubMembership> clubMemberships =null;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (roleId ==1 || roleId ==7){
            clubMemberships = clubMembershipMapper.findPageBreakByCondition(vo);
        }else if (roleId == 3){
            hashMap.put("application_id",applicationId);
            clubMemberships = clubMembershipMapper.findPageBreakByCondition3(hashMap);
        }
        else {
            hashMap.put("application_id",applicationId);
            clubMemberships = clubMembershipMapper.findPageBreakByCondition2(hashMap);
        }
        if (CollectionUtils.isEmpty(clubMemberships)) {
            return null;
        }
        List<ClubMembership> clubMemberships1 = new ArrayList<>();
        for (ClubMembership club : clubMemberships) {
            clubMemberships1.add(club);
        }
        PageInfo bean = new PageInfo<ClubMembership>(clubMemberships);
        bean.setList(clubMemberships);
        return bean;
    }

    @Override
    public int rtsqs(Long id) {
        //获取到社团注册的信息
        ClubRegistration clubRegistration = clubRegistrationApplicationsService.getByPrimaryKey(id);
        //将社团的信息封装到当前的入团申请记录中
        ClubMembership clubMembership = new ClubMembership();
        clubMembership.setClub_id(id.intValue());
        clubMembership.setClub_name(clubRegistration.getClub_name());
        Integer applicetionId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)applicetionId);
        clubMembership.setApplicant_id(applicetionId);
        clubMembership.setApplicant_name(user.getUsername());
        clubMembership.setStatus(0);
        clubMembership.setApplication_date(new Date());
        //根据当前用户的id和当前的社团id进行查询
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("applicant_id",applicetionId);
        hashMap.put("club_id",id);
        List<ClubMembershipEntity> clubMembershipEntities=clubMembershipService.findByApplicantIdAndClubId(hashMap);
        //如果不存在成功申请返回0，如果存在记录并且状态是待审核返回0.如果存在审核通过返回1，如果存在审核不通过返回2
        if (StringUtils.isEmpty(clubMembershipEntities)){
            clubMembershipMapper.insert(clubMembership);
            return 0;
        }
        ClubMembershipEntity clubMembershipEntity = clubMembershipEntities.get(0);
        Integer status = clubMembershipEntity.getStatus();
        status=status + 1;
        if (status == 1){
            return 1;
        }
        else if (status == 2){
            return 2;
        }else {
            return 3;
        }
    }

    @Override
    public List<ClubMembershipEntity> findByApplicantIdAndClubId(Map<String, Object> map) {
        List<ClubMembership> clubMemberships = clubMembershipMapper.findByApplicantIdAndClubId(map);
        if (CollectionUtils.isEmpty(clubMemberships)) {
            return null;
        }
        List<ClubMembershipEntity> clubMemberships1 = new ArrayList<>();
        for (ClubMembership r : clubMemberships) {
            clubMemberships1.add(new ClubMembershipEntity(r));
        }
        return clubMemberships1;
    }

    @Override
    public int updateSelective2(ClubMembershipEntity entity) {
        Assert.notNull(entity, "ClubMembershipEntity不可为空！");
        ClubMembershipEntity clubMembershipEntity = clubMembershipService.getByPrimaryKey(entity.getId());
        if (entity.getStatus() == 0 && clubMembershipEntity.getStatus() == 0 ||clubMembershipEntity.getStatus() == 2 && entity.getStatus() == 0){
            return 2;
        }
        if (clubMembershipEntity.getStatus() == 1){
            return 3;
        }
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setReviewer_id(id);
        entity.setReviewer_name(user.getUsername());
        entity.setUpdateTime(new Date());
        entity.setReview_date(new Date());
        return clubMembershipMapper.updateByPrimaryKeySelective(entity.getClubMembership());
    }

    @Override
    public ClubMembershipEntity insert(ClubMembershipEntity entity) {
        return null;
    }

    @Override
    public void insertList(List<ClubMembershipEntity> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ClubMembershipEntity entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubMembershipEntity entity) {
        Assert.notNull(entity, "ClubMembershipEntity不可为空！");
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setReviewer_id(id);
        entity.setReviewer_name(user.getUsername());
        entity.setUpdateTime(new Date());
        entity.setReview_date(new Date());
        return clubMembershipMapper.updateByPrimaryKeySelective(entity.getClubMembership()) > 0;
    }

    @Override
    public ClubMembershipEntity getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ClubMembership clubMembership = clubMembershipMapper.selectByPrimaryKey(primaryKey);
        return null == clubMembership ? null : new ClubMembershipEntity(clubMembership);
    }

    @Override
    public ClubMembershipEntity getOneByEntity(ClubMembershipEntity entity) {
        return null;
    }

    @Override
    public List<ClubMembershipEntity> listAll() {
        return null;
    }

    @Override
    public List<ClubMembershipEntity> listByEntity(ClubMembershipEntity entity) {
        return null;
    }
}
