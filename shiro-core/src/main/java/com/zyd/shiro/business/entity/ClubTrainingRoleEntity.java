package com.zyd.shiro.business.entity;

import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;

import java.util.Date;

/**
 * @author liulei
 * @date 2023.11.20 下午 02:31
 * @Description
 */
public class ClubTrainingRoleEntity {

    private ClubTrainingRole clubTrainingRole;


    public ClubTrainingRoleEntity() {
        this.clubTrainingRole = new ClubTrainingRole();
    }

    public ClubTrainingRoleEntity(ClubTrainingRole clubTrainingRole) {
        this.clubTrainingRole = clubTrainingRole;
    }

    public ClubTrainingRole getClubTrainingRole() {
        return clubTrainingRole;
    }

    public void setClubTrainingRole(ClubTrainingRole clubTrainingRole) {
        this.clubTrainingRole = clubTrainingRole;
    }

    public Long getId() {
        return this.clubTrainingRole.getId();
    }

    public void setId(Long id) {
        this.clubTrainingRole.setId(id);
    }

    public Integer getClubTrainingId() {
        return this.clubTrainingRole.getClubTrainingId();
    }

    public void setClubTrainingId(Integer clubTrainingId) {
        this.clubTrainingRole.setClubTrainingId(clubTrainingId);
    }

    public Integer getRoleId() {
        return this.clubTrainingRole.getRoleId();
    }

    public void setRoleId(Integer roleId) {
        this.clubTrainingRole.setRoleId(roleId);
    }

    public Date getCreateTime() {
        return this.clubTrainingRole.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubTrainingRole.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubTrainingRole.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubTrainingRole.setUpdateTime(updateTime);
    }

}
