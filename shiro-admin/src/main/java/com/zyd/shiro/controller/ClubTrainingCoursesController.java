package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubTrainingCoursesEntity;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubAuditService;
import com.zyd.shiro.business.service.ClubTrainingCoursesService;
import com.zyd.shiro.business.vo.ClubAuditVO;
import com.zyd.shiro.business.vo.ClubTrainingCoursesVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.persistence.beans.ClubTrainingCourses;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.09.28 下午 04:08
 * @Description
 */
@RestController
@RequestMapping("/training")
public class ClubTrainingCoursesController {

    @Autowired
    private ClubTrainingCoursesService clubTrainingCoursesService;

    @RequiresPermissions("training")
    @PostMapping("/list")
    public PageResult list(ClubTrainingCoursesVO vo) {
        PageInfo<ClubTrainingCourses> pageInfo = clubTrainingCoursesService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * @Author: liulei
     * @Description: 添加培训资料
     * @Date: 2023.11.13 上午 11:05
     * @Param: [clubRegistration]
     * @return: [com.zyd.shiro.business.entity.ClubRegistration]
     **/

    @RequiresPermissions("resource:training:add")
    @PostMapping("/add")
    public ResponseVO add(ClubTrainingCoursesEntity clubTrainingCoursesEntity) {
        try {
            clubTrainingCoursesService.insert(clubTrainingCoursesEntity);
            return ResultUtil.success("培训资料添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("培训资料添加失败");
        }
    }


    /**
     * 编辑的时候根据主键id获取当前信息
     * @param id
     * @return
     */
    @RequiresPermissions("resource:training:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.clubTrainingCoursesService.getByPrimaryKey(id));
    }

    /**
     * @Author: liulei
     * @Description:提交修改培训资料的信息
     * @Date: 2023.11.13 上午 11:05
     * @Param: [clubRegistration]
     * @return: [com.zyd.shiro.business.entity.ClubRegistration]
     **/
    @RequiresPermissions("resource:training:edit")
    @PostMapping("/edit")
    public ResponseVO edit(ClubTrainingCoursesEntity clubTrainingCoursesEntity) {
        try {
            clubTrainingCoursesService.updateSelective(clubTrainingCoursesEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("培训资料信息修改失败");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }


    @RequiresPermissions("resource:training:delete")
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            clubTrainingCoursesService.removeByPrimaryKey(id);
        }
        return ResultUtil.success("成功删除");
    }
}
