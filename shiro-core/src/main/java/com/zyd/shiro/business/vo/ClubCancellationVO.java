package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.09.27 下午 03:53
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubCancellationVO extends BaseConditionVO {
    private ClubCancellation clubCancellation;
}
