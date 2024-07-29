package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.11.20 下午 03:01
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubTrainingRoleVO extends BaseConditionVO {
    private ClubTrainingRole clubTrainingRole;
}
