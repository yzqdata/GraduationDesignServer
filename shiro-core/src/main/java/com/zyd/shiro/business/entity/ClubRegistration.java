package com.zyd.shiro.business.entity;

import com.zyd.shiro.framework.object.AbstractBO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;

import java.util.Date;


public class  ClubRegistration extends AbstractBO {

    private ClubRegistrationApplications clubRegistrationApplications;

    public ClubRegistration() {
        this.clubRegistrationApplications = new ClubRegistrationApplications();
    }

    public ClubRegistration(ClubRegistrationApplications clubRegistrationApplications) {
        this.clubRegistrationApplications = clubRegistrationApplications;
    }

    public ClubRegistrationApplications getClubRegistrationApplications() {
        return clubRegistrationApplications;
    }

    public void setClubRegistrationApplications(ClubRegistrationApplications clubRegistrationApplications) {
        this.clubRegistrationApplications = clubRegistrationApplications;
    }


    public Long getId() {
        return this.clubRegistrationApplications.getId();
    }

    public void setId(Long id) {
        this.clubRegistrationApplications.setId(id);
    }

    public String getClub_name() {
        return this.clubRegistrationApplications.getClub_name();
    }

    public void setClub_name(String club_name) {
        this.clubRegistrationApplications.setClub_name(club_name);
    }

    public String getClub_description() {
        return this.clubRegistrationApplications.getClub_description();
    }

    public void setClub_description(String club_description) {
        this.clubRegistrationApplications.setClub_description(club_description);
    }

    public String getClub_goals() {
        return this.clubRegistrationApplications.getClub_goals();
    }

    public void setClub_goals(String club_goals) {
        this.clubRegistrationApplications.setClub_goals(club_goals);
    }

    public int getApplication_id() {
        return this.clubRegistrationApplications.getApplication_id();
    }

    public void setApplication_id(int application_id) {
        this.clubRegistrationApplications.setApplication_id(application_id);
    }

    public Date getApplication_date() {
        return this.clubRegistrationApplications.getApplication_date();
    }

    public void setApplication_date(Date application_date) {
        this.clubRegistrationApplications.setApplication_date(application_date);
    }

    public Integer getStatus() {
        return this.clubRegistrationApplications.getStatus();
    }

    public void setStatus(Integer status) {
        this.clubRegistrationApplications.setStatus(status);
    }

    public Integer getReviewer_id() {
        return this.clubRegistrationApplications.getReviewer_id();
    }

    public void setReviewer_id(Integer reviewer_id) {
        this.clubRegistrationApplications.setReviewer_id(reviewer_id);
    }

    public Date getReview_date() {
        return this.clubRegistrationApplications.getReview_date();
    }

    public void setReview_date(Date review_date) {
        this.clubRegistrationApplications.setReview_date(review_date);
    }

    public String getReview_comments() {
        return this.clubRegistrationApplications.getReview_comments();
    }

    public void setReview_comments(String review_comments) {
        this.clubRegistrationApplications.setReview_comments(review_comments);
    }
    public Date getCreateTime() {
        return this.clubRegistrationApplications.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubRegistrationApplications.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubRegistrationApplications.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubRegistrationApplications.setUpdateTime(updateTime);
    }

    public String getReviewer_name() {
        return this.clubRegistrationApplications.getReviewer_name();
    }

    public void setReviewer_name(String reviewer_name) {
        this.clubRegistrationApplications.setReviewer_name(reviewer_name);
    }

    public String getApplication_name() {
        return this.clubRegistrationApplications.getApplication_name();
    }

    public void setApplication_name(String application_name) {
        this.clubRegistrationApplications.setApplication_name(application_name);
    }


}
