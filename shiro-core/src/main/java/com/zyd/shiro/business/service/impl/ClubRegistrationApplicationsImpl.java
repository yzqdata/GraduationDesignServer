package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.Resources;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.entity.UserRole;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.service.SysUserRoleService;
import com.zyd.shiro.business.service.SysUserService;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.business.vo.UserConditionVO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;

import com.zyd.shiro.persistence.beans.SysResources;
import com.zyd.shiro.persistence.beans.SysUser;
import com.zyd.shiro.persistence.beans.SysUserRole;
import com.zyd.shiro.persistence.mapper.ClubRegistrationApplicationsMapper;
import com.zyd.shiro.persistence.mapper.SysUserMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class ClubRegistrationApplicationsImpl implements ClubRegistrationApplicationsService {

    @Autowired
    private ClubRegistrationApplicationsMapper clubRegistrationApplicationsMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Override
    public PageInfo<ClubRegistrationApplications> findPageBreakByCondition(ClubRegistrationConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());

        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        UserRole userRole = new UserRole();
        userRole.setUserId((long)applicationId);
        Long roleId = sysUserRoleService.getOneByEntity(userRole).getRoleId();
        List<ClubRegistrationApplications> clubRegistrationApplications =null;
        if (roleId ==1 || roleId ==7){
            clubRegistrationApplications = clubRegistrationApplicationsMapper.findPageBreakByCondition(vo);
        }else {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("application_id",applicationId);
            clubRegistrationApplications = clubRegistrationApplicationsMapper.findPageBreakByCondition3(hashMap);
        }
        if (CollectionUtils.isEmpty(clubRegistrationApplications)) {
            return null;
        }
        List<ClubRegistrationApplications> clubRegistrations = new ArrayList<>();
        for (ClubRegistrationApplications club : clubRegistrationApplications) {
            clubRegistrations.add(club);
        }
        PageInfo bean = new PageInfo<ClubRegistrationApplications>(clubRegistrationApplications);
        bean.setList(clubRegistrations);
        return bean;
    }

    @Override
    public PageInfo<ClubRegistrationApplications> findPageBreakByCondition2(ClubRegistrationConditionVO vo) {




        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<ClubRegistrationApplications> clubRegistrationApplications = clubRegistrationApplicationsMapper.findPageBreakByCondition2(vo);
        if (CollectionUtils.isEmpty(clubRegistrationApplications)) {
            return null;
        }
        List<ClubRegistrationApplications> clubRegistrations = new ArrayList<>();
        for (ClubRegistrationApplications club : clubRegistrationApplications) {
            clubRegistrations.add(club);
        }
        PageInfo bean = new PageInfo<ClubRegistrationApplications>(clubRegistrationApplications);
        bean.setList(clubRegistrations);
        return bean;
    }

    @Override
    public void writeOffUser(Long id) {
        ClubRegistrationApplications clubRegistrationApplications = new ClubRegistrationApplications();
        clubRegistrationApplications.setId(id);
        clubRegistrationApplications.setStatus(3);
        clubRegistrationApplicationsMapper.updateByPrimaryKeySelective(clubRegistrationApplications);
    }

    @Override
    public List<ClubRegistration> findByApplicantId(Map<String, Object> map) {
        List<ClubRegistrationApplications> clubRegistrationApplications = clubRegistrationApplicationsMapper.findByApplicantId(map);
        if (CollectionUtils.isEmpty(clubRegistrationApplications)) {
            return null;
        }
        List<ClubRegistration> clubRegistrations = new ArrayList<>();
        for (ClubRegistrationApplications r : clubRegistrationApplications) {
            clubRegistrations.add(new ClubRegistration(r));
        }
        return clubRegistrations;
    }

    @Override
    public int updateSelective2(ClubRegistration entity) {
        Assert.notNull(entity, "ClubRegistration不可为空！");
        //获取到当前用户的ID
        String club_name = clubRegistrationApplicationsService.getByPrimaryKey((long) entity.getId()).getClub_name();
        if (!club_name.equals(entity.getClub_name())){
            return 2;
        }
        if (entity.getStatus() != null && entity.getStatus() == 0 && !StringUtils.isEmpty(entity.getReview_comments())){
            return 3;
        }
        if (entity.getStatus() != null && !StringUtils.isEmpty(entity.getReview_comments())){
            Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
            User user = sysUserService.getByPrimaryKey((long)id);
            entity.setReviewer_id(id);
            entity.setReviewer_name(user.getUsername());
            entity.setReview_date(new Date());
        }
        entity.setUpdateTime(new Date());
        //返回1
        return clubRegistrationApplicationsMapper.updateByPrimaryKeySelective(entity.getClubRegistrationApplications());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClubRegistration insert(ClubRegistration clubRegistration) {
        Assert.notNull(clubRegistration, "ClubRegistration不可为空！");
        clubRegistration.setUpdateTime(new Date());
        clubRegistration.setCreateTime(new Date());
        //获取到当前用户的ID
        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        clubRegistration.setApplication_id(applicationId);
        User user = sysUserService.getByPrimaryKey((long) applicationId);
        clubRegistration.setApplication_name(user.getUsername());
        clubRegistration.setApplication_date(new Date());
        clubRegistration.setStatus(0);
        clubRegistrationApplicationsMapper.insert(clubRegistration.getClubRegistrationApplications());
        return clubRegistration;
    }

    @Override
    public void insertList(List<ClubRegistration> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ClubRegistration entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubRegistration entity) {
        Assert.notNull(entity, "ClubRegistration不可为空！");
        //获取到当前用户的ID
        String club_name = clubRegistrationApplicationsService.getByPrimaryKey((long) entity.getId()).getClub_name();
        if (!club_name.equals(entity.getClub_name())){
            return false;
        }
        entity.setUpdateTime(new Date());
        if (!StringUtils.isEmpty(entity.getReview_comments()) && entity.getStatus() != null){
            Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
            User user = sysUserService.getByPrimaryKey((long)id);
            entity.setReviewer_id(id);
            entity.setReviewer_name(user.getUsername());
            entity.setReview_date(new Date());
        }
        return clubRegistrationApplicationsMapper.updateByPrimaryKeySelective(entity.getClubRegistrationApplications()) > 0;
    }

    @Override
    public ClubRegistration getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ClubRegistrationApplications clubRegistrationApplications = clubRegistrationApplicationsMapper.selectByPrimaryKey(primaryKey);
        return null == clubRegistrationApplications ? null : new ClubRegistration(clubRegistrationApplications);
    }

    @Override
    public ClubRegistration getOneByEntity(ClubRegistration entity) {
        return null;
    }

    @Override
    public List<ClubRegistration> listAll() {
        return null;
    }

    @Override
    public List<ClubRegistration> listByEntity(ClubRegistration entity) {
        return null;
    }
}
