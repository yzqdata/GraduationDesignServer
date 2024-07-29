package com.zyd.shiro.business.entity;

import com.zyd.shiro.framework.object.AbstractBO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.27 下午 03:55
 * @Description
 */
public class ClubCancellationEntity extends AbstractBO {

    private ClubCancellation clubCancellation;


    public ClubCancellationEntity() {
        this.clubCancellation = new ClubCancellation();
    }

    public ClubCancellationEntity(ClubCancellation clubCancellation) {
        this.clubCancellation = clubCancellation;
    }

    public Long getId() {
        return this.clubCancellation.getId();
    }

    public void setId(Long id) {
        this.clubCancellation.setId(id);
    }

    public ClubCancellation getClubCancellation() {
        return clubCancellation;
    }

    public void setClubCancellation(ClubCancellation clubCancellation) {
        this.clubCancellation = clubCancellation;
    }

    public Integer getClub_id() {
        return this.clubCancellation.getClub_id();
    }

    public void setClub_id(int club_id) {
        this.clubCancellation.setClub_id(club_id);
    }

    public Integer getApplicant_id() {
        return  this.clubCancellation.getApplicant_id();
    }

    public void setApplicant_id(int applicant_id) {
        this.clubCancellation.setApplicant_id(applicant_id);
    }

    public Date getApplication_date() {
        return this.clubCancellation.getApplication_date();
    }

    public void setApplication_date(Date application_date) {
        this.clubCancellation.setApplication_date(application_date);
    }

    public String getReason_for_cancellation() {
        return this.clubCancellation.getReason_for_cancellation();
    }

    public void setReason_for_cancellation(String reason_for_cancellation) {
        this.clubCancellation.setReason_for_cancellation(reason_for_cancellation);
    }

    public Integer getStatus() {
        return this.clubCancellation.getStatus();
    }

    public void setStatus(int status) {
        this.clubCancellation.setStatus(status);
    }

    public Integer getReviewer_id() {
        return this.clubCancellation.getReviewer_id();
    }

    public void setReviewer_id(int reviewer_id) {
        this.clubCancellation.setReviewer_id(reviewer_id);
    }

    public Date getReview_date() {
        return this.clubCancellation.getReview_date();
    }

    public void setReview_date(Date review_date) {
        this.clubCancellation.setReview_date(review_date);
    }

    public String getReview_comments() {
        return this.clubCancellation.getReview_comments();
    }

    public void setReview_comments(String review_comments) {
        this.clubCancellation.setReview_comments(review_comments);
    }


    public Date getCreateTime() {
        return this.clubCancellation.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubCancellation.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubCancellation.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubCancellation.setUpdateTime(updateTime);
    }

    public String getApplicant_name() {
        return this.clubCancellation.getApplicant_name();
    }

    public void setApplicant_name(String applicant_name) {
        this.clubCancellation.setApplicant_name(applicant_name);
    }

    public String getReviewer_name() {
        return this.clubCancellation.getReviewer_name();
    }

    public void setReviewer_name(String reviewer_name) {
        this.clubCancellation.setReviewer_name(reviewer_name);
    }

    public String getClub_name() {
        return this.clubCancellation.getClub_name();
    }

    public void setClub_name(String club_name) {
        this.clubCancellation.setClub_name(club_name);
    }
}
