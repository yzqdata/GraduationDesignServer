package com.zyd.shiro.persistence.mapper;

import com.zyd.shiro.business.vo.ClubCancellationVO;
import com.zyd.shiro.business.vo.ClubTrainingCoursesVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liulei
 * @date 2023.09.28 下午 04:15
 * @Description
 */
@Repository
public interface ClubTrainingCoursesMapper extends BaseMapper<ClubTrainingCourses> {
    List<ClubTrainingCourses> findPageBreakByCondition(ClubTrainingCoursesVO vo);
}
