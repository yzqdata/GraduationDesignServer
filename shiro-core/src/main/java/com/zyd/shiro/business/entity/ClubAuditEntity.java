package com.zyd.shiro.business.entity;

import com.zyd.shiro.framework.object.AbstractBO;
import com.zyd.shiro.persistence.beans.ClubAudit;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.28 下午 02:35
 * @Description
 */
public class ClubAuditEntity extends AbstractBO {
    private ClubAudit clubAudit;

    public ClubAuditEntity() {
        this.clubAudit = new ClubAudit();
    }

    public ClubAuditEntity(ClubAudit clubAudit) {
        this.clubAudit = clubAudit;
    }

    public ClubAudit getClubAuditEntity() {
        return clubAudit;
    }

    public void setClubAuditEntity(ClubAuditEntity clubAuditEntity) {
        this.clubAudit = clubAudit;
    }
    public Long getId() {
        return this.clubAudit.getId();
    }

    public void setId(Long id) {
        this.clubAudit.setId(id);
    }

    public Integer getClub_id() {
        return this.clubAudit.getClub_id();
    }

    public void setClub_id(Integer club_id) {
        this.clubAudit.setClub_id(club_id);
    }

    public Date getApplication_date() {
        return this.clubAudit.getApplication_date();
    }

    public void setApplication_date(Date application_date) {
        this.clubAudit.setApplication_date(application_date);
    }

    public Integer getAuditor_id() {
        return this.clubAudit.getAuditor_id();
    }

    public void setAuditor_id(Integer auditor_id) {
        this.clubAudit.setAuditor_id(auditor_id);
    }

    public String getAudit_item() {
        return this.clubAudit.getAudit_item();
    }

    public void setAudit_item(String audit_item) {
        this.clubAudit.setAudit_item(audit_item);
    }

    public Integer getStatus() {
        return this.clubAudit.getStatus();
    }

    public void setStatus(Integer status) {
        this.clubAudit.setStatus(status);
    }

    public String getComments() {
        return this.clubAudit.getComments();
    }

    public void setComments(String comments) {
        this.clubAudit.setComments(comments);
    }

    public Date getCreateTime() {
        return this.clubAudit.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubAudit.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubAudit.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubAudit.setUpdateTime(updateTime);
    }

    public String getClub_name() {
        return this.clubAudit.getClub_name();
    }

    public void setClub_name(String club_name) {
        this.clubAudit.setClub_name(club_name);
    }

    public String getAuditor_name() {
        return this.clubAudit.getAuditor_name();
    }

    public void setAuditor_name(String auditor_name) {
        this.clubAudit.setAuditor_name(auditor_name);
    }


    public Integer getApplicant_id() {
        return this.clubAudit.getApplicant_id();
    }

    public void setApplicant_id(Integer applicant_id) {
        this.clubAudit.setApplicant_id(applicant_id);
    }

    public String getApplicant_name() {
        return this.clubAudit.getApplicant_name();
    }

    public void setApplicant_name(String applicant_name) {
        this.clubAudit.setApplicant_name(applicant_name);
    }
}
