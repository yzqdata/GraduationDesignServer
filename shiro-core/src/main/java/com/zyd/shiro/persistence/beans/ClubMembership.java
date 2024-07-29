package com.zyd.shiro.persistence.beans;

import com.zyd.shiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:23
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubMembership extends AbstractDO {
    private Integer club_id;
    private String club_name;
    private Integer applicant_id;
    private Date application_date;
    private Integer status;
    private Integer reviewer_id;
    private Date review_date;
    private String review_comments;
    private String applicant_name;
    private String reviewer_name;

}
