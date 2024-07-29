package com.zyd.shiro.persistence.beans;

import com.zyd.shiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClubRegistrationApplications extends AbstractDO {

   //社团名称
   private String club_name;
   //社团简介
   private String club_description;
   //社团目标和计划
   private String club_goals;
   //申请者ID
   private Integer application_id;
   //申请时间
   private Date application_date;
   //社团状态 0待审批 1审批通过 2审批不通过 3注销
   private Integer status;
   //审核人id
   private Integer reviewer_id;
   //审核时间
   private Date review_date;
   //审核意见
   private String review_comments;
   //审核人
   private String reviewer_name;
   //申请者
   private String application_name;

}
