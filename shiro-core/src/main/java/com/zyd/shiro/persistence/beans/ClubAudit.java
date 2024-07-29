package com.zyd.shiro.persistence.beans;

import com.zyd.shiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.28 下午 02:30
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubAudit  extends AbstractDO {
    //社团ID
    private Integer club_id;
    //申请时间
    private Date application_date;
    //审核人ID
    private Integer auditor_id;
    //申请事项
    private String audit_item;
    //审批状态
    private Integer status;
    //审核意见
    private String comments;
    //社团名称
    private String club_name;
    //审核人
    private String auditor_name;
    //申请人ID
    private Integer applicant_id;
    //申请人名称
    private String applicant_name;

}
