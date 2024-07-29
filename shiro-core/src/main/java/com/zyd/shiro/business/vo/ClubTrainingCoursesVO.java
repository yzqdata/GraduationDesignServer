package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.09.28 下午 03:53
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubTrainingCoursesVO  extends BaseConditionVO {
    private ClubTrainingCourses clubTrainingCourses;
}
