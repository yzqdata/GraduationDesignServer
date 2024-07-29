package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.ClubTrainingCoursesEntity;
import com.zyd.shiro.business.entity.ClubTrainingRoleEntity;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.service.ClubMembershipService;
import com.zyd.shiro.business.service.ClubTrainingCoursesService;
import com.zyd.shiro.business.service.ClubTrainingRoleService;
import com.zyd.shiro.business.vo.ClubTrainingRoleVO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;
import com.zyd.shiro.persistence.mapper.ClubTrainingRoleMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author liulei
 * @date 2023.11.20 下午 02:51
 * @Description
 */
@Service
public class ClubTrainingRoleServiceImpl implements ClubTrainingRoleService {

    @Autowired
    private ClubTrainingRoleMapper clubTrainingRoleMapper;

    @Autowired
    private ClubTrainingRoleService clubTrainingRoleService;

    @Autowired
    private ClubTrainingCoursesService clubTrainingCoursesService;

    @Override
    public PageInfo<ClubTrainingRole> findPageBreakByCondition(ClubTrainingRoleVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<ClubTrainingRole> clubTrainingRoles = clubTrainingRoleMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(clubTrainingRoles)) {
            return null;
        }
        List<ClubTrainingRole> clubTrainingRoles1 = new ArrayList<>();
        for (ClubTrainingRole club : clubTrainingRoles) {
            clubTrainingRoles1.add(club);
        }
        PageInfo bean = new PageInfo<ClubTrainingRole>(clubTrainingRoles1);
        bean.setList(clubTrainingRoles1);
        return bean;
    }

    @Transactional
    @Override
    public int addTraining(Long id) {
        Assert.notNull(id, "培训信息ID不可为空！");
        //获取到当前用户的ID
        ClubTrainingRoleEntity entity = new ClubTrainingRoleEntity();
        Integer applicationId = Integer.valueOf(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal().toString());
        entity.setRoleId(applicationId);
        //根据当前用户ID和前端传过来的培训资料ID去数据库里查询，如果存在直接返回不进行插入
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("club_training_id",id);
        hashMap.put("role_id",applicationId);
        List<ClubTrainingRoleEntity> clubTrainingRoleEntities = clubTrainingRoleService.findByRoleClubTrainingId(hashMap);
        if (!StringUtils.isEmpty(clubTrainingRoleEntities)){
            return 0;
        }
        entity.setUpdateTime(new Date());
        entity.setCreateTime(new Date());
        entity.setClubTrainingId(id.intValue());
        clubTrainingRoleMapper.insert(entity.getClubTrainingRole());
        //插入记录完成之后要将当前的培训资料表中的参与人数字段+1
        ClubTrainingCoursesEntity clubTrainingCoursesEntity = clubTrainingCoursesService.getByPrimaryKey(id);
        //最大的参与人数
        int max = clubTrainingCoursesEntity.getMax_participants();
        //当前参与的人数
        int current = clubTrainingCoursesEntity.getCurrent_participants();
        //在当前参与人数上+1
        int num=current + 1;
        //如果当前参与人数大于最大参与人数直接返回，不对培训资料的当前参与人数更新
        if (num > max){
            return 2;
        }
        clubTrainingCoursesEntity.setCurrent_participants(num);
        clubTrainingCoursesService.updateSelective(clubTrainingCoursesEntity);
        return 1;
    }

    @Override
    public List<ClubTrainingRoleEntity> findByRoleClubTrainingId(Map<String, Object> map) {
        List<ClubTrainingRole> clubTrainingRoles = clubTrainingRoleMapper.findByRoleClubTrainingId(map);
        if (CollectionUtils.isEmpty(clubTrainingRoles)) {
            return null;
        }
        List<ClubTrainingRoleEntity> clubTrainingRoleEntities = new ArrayList<>();
        for (ClubTrainingRole r : clubTrainingRoles) {
            clubTrainingRoleEntities.add(new ClubTrainingRoleEntity(r));
        }
        return clubTrainingRoleEntities;
    }

    @Override
    public ClubTrainingRoleEntity insert(ClubTrainingRoleEntity entity) {
        return null;
    }

    @Override
    public void insertList(List<ClubTrainingRoleEntity> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ClubTrainingRoleEntity entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubTrainingRoleEntity entity) {
        return false;
    }

    @Override
    public ClubTrainingRoleEntity getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ClubTrainingRoleEntity getOneByEntity(ClubTrainingRoleEntity entity) {
        return null;
    }

    @Override
    public List<ClubTrainingRoleEntity> listAll() {
        return null;
    }

    @Override
    public List<ClubTrainingRoleEntity> listByEntity(ClubTrainingRoleEntity entity) {
        return null;
    }


}
