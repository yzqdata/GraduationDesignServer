package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClubRegistrationConditionVO extends BaseConditionVO {
    private ClubRegistrationApplications clubRegistrationApplications;
}
