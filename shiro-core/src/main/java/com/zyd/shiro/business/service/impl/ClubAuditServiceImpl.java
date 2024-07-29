package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.*;
import com.zyd.shiro.business.service.ClubAuditService;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.service.SysUserRoleService;
import com.zyd.shiro.business.service.SysUserService;
import com.zyd.shiro.business.vo.ClubAuditVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.mapper.ClubAuditMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author liulei
 * @date 2023.09.28 下午 02:55
 * @Description
 */
@Service
public class ClubAuditServiceImpl implements ClubAuditService {

    @Autowired
    private ClubAuditMapper clubAuditMapper;
    @Autowired
    private ClubAuditService clubAuditService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public PageInfo<ClubAudit> findPageBreakByCondition(ClubAuditVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());

        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        UserRole userRole = new UserRole();
        userRole.setUserId((long)applicationId);
        Long roleId = sysUserRoleService.getOneByEntity(userRole).getRoleId();
        List<ClubAudit> clubAudits =null;
        if (roleId ==1 || roleId ==7){
            clubAudits = clubAuditMapper.findPageBreakByCondition(vo);
        }else {
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("application_id",applicationId);
            clubAudits = clubAuditMapper.findPageBreakByCondition2(hashMap);
        }
        if (CollectionUtils.isEmpty(clubAudits)) {
            return null;
        }
        List<ClubAudit> clubAudits1 = new ArrayList<>();
        for (ClubAudit club : clubAudits) {
            clubAudits1.add(club);
        }
        PageInfo bean = new PageInfo<ClubAudit>(clubAudits1);
        bean.setList(clubAudits1);
        return bean;
    }

    @Override
    public int updateSelective2(ClubAuditEntity entity) {
        Assert.notNull(entity, "ClubCancellationEntity不可为空！");
        if (entity.getStatus() == 0){
            return 2;
        }
        ClubAuditEntity clubAuditEntity = clubAuditService.getByPrimaryKey(entity.getId());
        if (clubAuditEntity.getStatus() == 1 || clubAuditEntity.getStatus() == 2){
            return 3;
        }
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setAuditor_id(id);
        entity.setAuditor_name(user.getUsername());
        entity.setUpdateTime(new Date());
        return clubAuditMapper.updateByPrimaryKeySelective(entity.getClubAuditEntity());
    }


    @Override
    public ClubAuditEntity insert(ClubAuditEntity entity) {
        Assert.notNull(entity, "ClubAuditEntity不可为空！");
        ClubRegistration clubRegistration = clubRegistrationApplicationsService.getByPrimaryKey((long) entity.getClub_id());
        entity.setClub_name(clubRegistration.getClub_name());
        entity.setUpdateTime(new Date());
        entity.setCreateTime(new Date());
        //获取到当前用户的ID
        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        entity.setApplicant_id(applicationId);
        User user = sysUserService.getByPrimaryKey((long) applicationId);
        entity.setApplicant_name(user.getUsername());
        entity.setApplication_date(new Date());
        entity.setStatus(0);
        clubAuditMapper.insert(entity.getClubAuditEntity());
        return entity;
    }

    @Override
    public void insertList(List<ClubAuditEntity> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ClubAuditEntity entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubAuditEntity entity) {
        Assert.notNull(entity, "ClubCancellationEntity不可为空！");
        //获取到当前用户的ID
        Integer id = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        User user = sysUserService.getByPrimaryKey((long)id);
        entity.setAuditor_id(id);
        entity.setAuditor_name(user.getUsername());
        entity.setUpdateTime(new Date());
        return clubAuditMapper.updateByPrimaryKeySelective(entity.getClubAuditEntity()) > 0;
    }

    @Override
    public ClubAuditEntity getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ClubAudit clubAudit = clubAuditMapper.selectByPrimaryKey(primaryKey);
        return null == clubAudit ? null : new ClubAuditEntity(clubAudit);
    }

    @Override
    public ClubAuditEntity getOneByEntity(ClubAuditEntity entity) {
        return null;
    }

    @Override
    public List<ClubAuditEntity> listAll() {
        return null;
    }

    @Override
    public List<ClubAuditEntity> listByEntity(ClubAuditEntity entity) {
        return null;
    }
}
