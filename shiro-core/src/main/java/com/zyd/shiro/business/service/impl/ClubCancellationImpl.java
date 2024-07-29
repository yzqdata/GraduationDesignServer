package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.entity.UserRole;
import com.zyd.shiro.business.service.ClubCancellationService;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.service.SysUserRoleService;
import com.zyd.shiro.business.service.SysUserService;
import com.zyd.shiro.business.vo.ClubCancellationVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.mapper.ClubCancellationMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author liulei
 * @date 2023.09.28 上午 10:05
 * @Description
 */
@Service
public class ClubCancellationImpl implements ClubCancellationService {

    @Autowired
    private ClubCancellationMapper clubCancellationMapper;

    @Autowired
    private ClubCancellationService clubCancellationService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public PageInfo<ClubCancellation> findPageBreakByCondition(ClubCancellationVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        UserRole userRole = new UserRole();
        userRole.setUserId((long)applicationId);
        Long roleId = sysUserRoleService.getOneByEntity(userRole).getRoleId();
        List<ClubCancellation> clubCancellationEntities =null;
        if (roleId ==1 || roleId ==7){
            clubCancellationEntities = clubCancellationMapper.findPageBreakByCondition(vo);
        }else {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("application_id",applicationId);
            clubCancellationEntities = clubCancellationMapper.findPageBreakByCondition2(hashMap);
        }
        if (CollectionUtils.isEmpty(clubCancellationEntities)) {
            return null;
        }
        List<ClubCancellation> clubCancellationEntities1 = new ArrayList<>();
        for (ClubCancellation club : clubCancellationEntities) {
            clubCancellationEntities1.add(club);
        }
        PageInfo bean = new PageInfo<ClubCancellation>(clubCancellationEntities1);
        bean.setList(clubCancellationEntities1);
        return bean;
    }


    @Override
    public int submitwriteoff(ClubCancellationEntity entity) {
        Assert.notNull(entity, "clubCancellationEntity不可为空！");
        Integer clubid = Integer.valueOf(String.valueOf(entity.getId()));
        ClubRegistration clubRegistration = clubRegistrationApplicationsService.getByPrimaryKey((long) clubid);
        if (clubRegistration.getStatus() == 1){
            entity.setClub_id(clubid);
            entity.setId(null);
            entity.setUpdateTime(new Date());
            entity.setCreateTime(new Date());
            //获取到当前用户的ID
            Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
            entity.setApplicant_id(applicationId);
            entity.setApplication_date(new Date());
            entity.setStatus(0);
            User user = sysUserService.getByPrimaryKey((long) applicationId);
            entity.setApplicant_name(user.getUsername());
            clubCancellationMapper.insert(entity.getClubCancellation());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateSelective2(ClubCancellationEntity entity) {
        Assert.notNull(entity, "ClubCancellationEntity不可为空！");
        ClubCancellationEntity cancellationEntity = clubCancellationService.getByPrimaryKey(entity.getId());
        if (entity.getStatus() == 0){
            return 2;
        }else if (cancellationEntity.getStatus() == 1){
            return 3;
        }
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setReviewer_id(id);
        entity.setReviewer_name(user.getUsername());
        entity.setUpdateTime(new Date());
        entity.setReview_date(new Date());
        //如果执行到这儿就把社团的状态改成已注销
        if (entity.getStatus() == 1){
            long club_id = entity.getClub_id();
            clubRegistrationApplicationsService.writeOffUser(club_id);
        }
        return clubCancellationMapper.updateByPrimaryKeySelective(entity.getClubCancellation());
    }


    @Override
    public ClubCancellationEntity insert(ClubCancellationEntity entity) {
        return null;
    }

    @Override
    public void insertList(List<ClubCancellationEntity> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ClubCancellationEntity entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubCancellationEntity entity) {
        Assert.notNull(entity, "ClubCancellationEntity不可为空！");
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setReviewer_id(id);
        entity.setReviewer_name(user.getUsername());
        entity.setUpdateTime(new Date());
        entity.setReview_date(new Date());
        //如果执行到这儿就把社团的状态改成已注销
        if (entity.getStatus() == 1){
            long club_id = entity.getClub_id();
            clubRegistrationApplicationsService.writeOffUser(club_id);
        }
        return clubCancellationMapper.updateByPrimaryKeySelective(entity.getClubCancellation()) > 0;
    }

    @Override
    public ClubCancellationEntity getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ClubCancellation clubCancellation = clubCancellationMapper.selectByPrimaryKey(primaryKey);
        return null == clubCancellation ? null : new ClubCancellationEntity(clubCancellation);
    }

    @Override
    public ClubCancellationEntity getOneByEntity(ClubCancellationEntity entity) {
        return null;
    }

    @Override
    public List<ClubCancellationEntity> listAll() {
        return null;
    }

    @Override
    public List<ClubCancellationEntity> listByEntity(ClubCancellationEntity entity) {
        return null;
    }
}
