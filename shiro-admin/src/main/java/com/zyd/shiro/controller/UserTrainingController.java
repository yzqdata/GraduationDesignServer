package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.entity.ClubTrainingCoursesEntity;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubTrainingCoursesService;
import com.zyd.shiro.business.vo.ClubTrainingCoursesVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liulei
 * @date 2023.10.04 上午 10:03
 * @Description
 */
@RestController
@RequestMapping("/usertraining")
public class UserTrainingController {

    @Autowired
    private ClubTrainingCoursesService clubTrainingCoursesService;

    @RequiresPermissions("usertraining")
    @PostMapping("/list")
    public PageResult list(ClubTrainingCoursesVO vo) {
        PageInfo<ClubTrainingCourses> pageInfo = clubTrainingCoursesService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

}
