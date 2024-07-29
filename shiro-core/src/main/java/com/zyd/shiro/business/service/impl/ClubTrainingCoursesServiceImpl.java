package com.zyd.shiro.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.ClubTrainingCoursesEntity;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.service.ClubTrainingCoursesService;
import com.zyd.shiro.business.vo.ClubTrainingCoursesVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.persistence.mapper.ClubCancellationMapper;
import com.zyd.shiro.persistence.mapper.ClubTrainingCoursesMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liulei
 * @date 2023.09.28 下午 04:12
 * @Description
 */
@Service
public class ClubTrainingCoursesServiceImpl implements ClubTrainingCoursesService {

    @Autowired
    private ClubTrainingCoursesMapper clubTrainingCoursesMapper;

    @Override
    public PageInfo<ClubTrainingCourses> findPageBreakByCondition(ClubTrainingCoursesVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<ClubTrainingCourses> clubTrainingCourses = clubTrainingCoursesMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(clubTrainingCourses)) {
            return null;
        }
        List<ClubTrainingCourses> clubTrainingCourses1 = new ArrayList<>();
        for (ClubTrainingCourses club : clubTrainingCourses) {
            clubTrainingCourses1.add(club);
        }
        PageInfo bean = new PageInfo<ClubTrainingCourses>(clubTrainingCourses);
        bean.setList(clubTrainingCourses1);
        return bean;
    }


    @Override
    public ClubTrainingCoursesEntity insert(ClubTrainingCoursesEntity entity) {
        Assert.notNull(entity, "ClubTrainingCoursesEntity不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        clubTrainingCoursesMapper.insert(entity.getClubTrainingCourses());
        return entity;
    }

    @Override
    public void insertList(List<ClubTrainingCoursesEntity> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return clubTrainingCoursesMapper.deleteByPrimaryKey(primaryKey) > 0;
    }

    @Override
    public boolean update(ClubTrainingCoursesEntity entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ClubTrainingCoursesEntity entity) {
        Assert.notNull(entity, "ClubTrainingCoursesEntity不可为空！");
        //获取到当前用户的ID
        entity.setUpdateTime(new Date());
        return clubTrainingCoursesMapper.updateByPrimaryKeySelective(entity.getClubTrainingCourses()) > 0;
    }

    @Override
    public ClubTrainingCoursesEntity getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ClubTrainingCourses clubTrainingCourses = clubTrainingCoursesMapper.selectByPrimaryKey(primaryKey);
        return null == clubTrainingCourses ? null : new ClubTrainingCoursesEntity(clubTrainingCourses);
    }

    @Override
    public ClubTrainingCoursesEntity getOneByEntity(ClubTrainingCoursesEntity entity) {
        return null;
    }

    @Override
    public List<ClubTrainingCoursesEntity> listAll() {
        return null;
    }

    @Override
    public List<ClubTrainingCoursesEntity> listByEntity(ClubTrainingCoursesEntity entity) {
        return null;
    }
}
