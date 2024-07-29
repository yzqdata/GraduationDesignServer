package com.zyd.shiro.business.entity;

import com.zyd.shiro.framework.object.AbstractBO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.beans.ClubMembership;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:27
 * @Description
 */
public class ClubMembershipEntity extends AbstractBO {
    private ClubMembership clubMembership;


    public ClubMembershipEntity() {
        this.clubMembership = new ClubMembership();
    }

    public ClubMembershipEntity(ClubMembership clubMembership) {
        this.clubMembership = clubMembership;
    }

    public ClubMembership getClubMembership() {
        return clubMembership;
    }

    public void setClubMembership(ClubMembership clubMembership) {
        this.clubMembership = clubMembership;
    }

    public Long getId() {
        return this.clubMembership.getId();
    }

    public void setId(Long id) {
        this.clubMembership.setId(id);
    }

    public Integer getClub_id() {
        return this.clubMembership.getClub_id();
    }

    public void setClub_id(Integer club_id) {
        this.clubMembership.setClub_id(club_id);
    }

    public String getClub_name() {
        return this.clubMembership.getClub_name();
    }

    public void setClub_name(String club_name) {
        this.clubMembership.setClub_name(club_name);
    }

    public Integer getApplicant_id() {
        return this.clubMembership.getApplicant_id();
    }

    public void setApplicant_id(Integer applicant_id) {
        this.clubMembership.setApplicant_id(applicant_id);
    }

    public Date getApplication_date() {
        return this.clubMembership.getApplication_date();
    }

    public void setApplication_date(Date application_date) {
        this.clubMembership.setApplication_date(application_date);
    }

    public Integer getStatus() {
        return  this.clubMembership.getStatus();
    }

    public void setStatus(Integer status) {
        this.clubMembership.setStatus(status);
    }

    public Integer getReviewer_id() {
        return this.clubMembership.getReviewer_id();
    }

    public void setReviewer_id(Integer reviewer_id) {
        this.clubMembership.setReviewer_id(reviewer_id);
    }

    public Date getReview_date() {
        return this.clubMembership.getReview_date();
    }

    public void setReview_date(Date review_date) {
        this.clubMembership.setReview_date(review_date);
    }

    public String getReview_comments() {
        return this.clubMembership.getReview_comments();
    }

    public void setReview_comments(String review_comments) {
        this.clubMembership.setReview_comments(review_comments);
    }

    public String getApplicant_name() {
        return this.clubMembership.getApplicant_name();
    }

    public void setApplicant_name(String applicant_name) {
        this.clubMembership.setApplicant_name(applicant_name);
    }

    public String getReviewer_name() {
        return this.clubMembership.getReviewer_name();
    }

    public void setReviewer_name(String reviewer_name) {
        this.clubMembership.setReviewer_name(reviewer_name);
    }

    public Date getCreateTime() {
        return this.clubMembership.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubMembership.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubMembership.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubMembership.setUpdateTime(updateTime);
    }
}
