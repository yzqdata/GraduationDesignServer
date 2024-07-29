package com.zyd.shiro.persistence.beans;

import com.zyd.shiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.27 下午 03:45
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class    ClubCancellation extends AbstractDO {

    //社团ID
    private Integer club_id;
    //申请人id
    private Integer applicant_id;
    //申请时间
    private Date application_date;
    //注销原因
    private String reason_for_cancellation;
    //状态 0待审核 1已注销 2已拒绝
    private Integer status;
    //审核人id
    private Integer reviewer_id;
    //审核时间
    private Date review_date;
    //审核意见和评论
    private String review_comments;
    //申请人
    private String applicant_name;
    //审批人
    private String reviewer_name;
    //社团名称
    private String club_name;


}
