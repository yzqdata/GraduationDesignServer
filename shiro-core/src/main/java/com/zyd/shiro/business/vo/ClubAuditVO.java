package com.zyd.shiro.business.vo;

import com.zyd.shiro.framework.object.BaseConditionVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.09.28 下午 02:36
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubAuditVO extends BaseConditionVO {
    private ClubAudit clubAudit;
}
