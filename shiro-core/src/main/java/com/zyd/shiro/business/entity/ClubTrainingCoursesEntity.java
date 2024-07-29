package com.zyd.shiro.business.entity;

import com.zyd.shiro.framework.object.AbstractBO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;

import java.sql.Time;
import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.28 下午 03:54
 * @Description
 */
public class ClubTrainingCoursesEntity extends AbstractBO {
    private ClubTrainingCourses clubTrainingCourses;

    public ClubTrainingCoursesEntity() {
        this.clubTrainingCourses = new ClubTrainingCourses();
    }

    public ClubTrainingCoursesEntity(ClubTrainingCourses clubTrainingCourses) {
        this.clubTrainingCourses = clubTrainingCourses;
    }

    public ClubTrainingCourses getClubTrainingCourses() {
        return clubTrainingCourses;
    }

    public Long getId() {
        return this.clubTrainingCourses.getId();
    }

    public void setId(Long id) {
        this.clubTrainingCourses.setId(id);
    }

    public void setClubTrainingCourses(ClubTrainingCourses clubTrainingCourses) {
        this.clubTrainingCourses = clubTrainingCourses;
    }

    public String getCourse_name() {
        return this.clubTrainingCourses.getCourse_name();
    }

    public void setCourse_name(String course_name) {
        this.clubTrainingCourses.setCourse_name(course_name);
    }

    public String getCourse_description() {
        return this.clubTrainingCourses.getCourse_description();
    }

    public void setCourse_description(String course_description) {
        this.clubTrainingCourses.setCourse_description(course_description);
    }

    public Date getCourse_date() {
        return this.clubTrainingCourses.getCourse_date();
    }

    public void setCourse_date(Date course_date) {
        this.clubTrainingCourses.setCourse_date(course_date);
    }

//    public Date getCourse_time() {
//        return this.clubTrainingCourses.getCourse_time();
//    }
//
//    public void setCourse_time(Time course_time) {
//        this.clubTrainingCourses.setCourse_time(course_time);
//    }

    public String getLocation() {
        return this.clubTrainingCourses.getLocation();
    }

    public void setLocation(String location) {
        this.clubTrainingCourses.setLocation(location);
    }

    public String getInstructor_name() {
        return this.clubTrainingCourses.getInstructor_name();
    }

    public void setInstructor_name(String instructor_name) {
        this.clubTrainingCourses.setInstructor_name(instructor_name);
    }

    public Integer getMax_participants() {
        return this.clubTrainingCourses.getMax_participants();
    }

    public void setMax_participants(Integer max_participants) {
        this.clubTrainingCourses.setMax_participants(max_participants);
    }

    public Integer getCurrent_participants() {
        return this.clubTrainingCourses.getCurrent_participants();
    }

    public void setCurrent_participants(Integer current_participants) {
        this.clubTrainingCourses.setCurrent_participants(current_participants);
    }

    public Date getCreateTime() {
        return this.clubTrainingCourses.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.clubTrainingCourses.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.clubTrainingCourses.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.clubTrainingCourses.setUpdateTime(updateTime);
    }
}
