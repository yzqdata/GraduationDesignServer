package com.zyd.shiro.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyd.shiro.framework.object.AbstractDO;
import jxl.write.DateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

/**
 * @author liulei
 * @date 2023.09.28 下午 03:50
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubTrainingCourses extends AbstractDO {
    private String course_name;
    private String course_description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date course_date;
//    private Time course_time;
    private String location;
    private String instructor_name;
    private Integer max_participants;
    private Integer current_participants;



}
