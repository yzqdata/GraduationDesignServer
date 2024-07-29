package com.zyd.shiro.business.service;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubTrainingCoursesEntity;
import com.zyd.shiro.business.vo.ClubTrainingCoursesVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;

/**
 * @author liulei
 * @date 2023.09.28 下午 04:11
 * @Description
 */
public interface ClubTrainingCoursesService extends AbstractService<ClubTrainingCoursesEntity, Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubTrainingCourses> findPageBreakByCondition(ClubTrainingCoursesVO vo);

}
