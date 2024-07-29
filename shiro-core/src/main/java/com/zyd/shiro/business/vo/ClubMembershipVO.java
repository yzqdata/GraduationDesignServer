package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubMembership;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:25
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubMembershipVO  extends BaseConditionVO {
    private ClubMembership clubMembership;
}
