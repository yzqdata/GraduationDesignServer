package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.Resources;
import com.zyd.shiro.business.entity.User;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubCancellationService;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.service.SysUserService;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.util.PasswordUtil;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/community")
public class ClubRegistrationApplicationsController {

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Autowired
    private ClubCancellationService clubCancellationService;

    @RequiresPermissions("community")
    @PostMapping("/list")
    public PageResult list(ClubRegistrationConditionVO vo) {
        PageInfo<ClubRegistrationApplications> pageInfo = clubRegistrationApplicationsService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @RequiresPermissions("resource:community:add")
    @PostMapping("/add")
    public ResponseVO add(ClubRegistration clubRegistration) {
        try {
            clubRegistrationApplicationsService.insert(clubRegistration);
            return ResultUtil.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("error");
        }
    }

    @RequiresPermissions("resource:community:proprieteredit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.clubRegistrationApplicationsService.getByPrimaryKey(id));
    }

    /**
     * 审批社团
     * @param clubRegistration
     * @return
     */

    @RequiresPermissions(value = {"resource:community:adminedit","resource:community:proprieteredit"}, logical= Logical.OR)
    @PostMapping("/edit")
    public ResponseVO edit(ClubRegistration clubRegistration) {
        try {
            int value = clubRegistrationApplicationsService.updateSelective2(clubRegistration);
//            System.out.println("状态码："+value);
            if (value == 2){
                return ResultUtil.error("社团名称无法编辑，请重新提交");
            }else if (value == 3){
                return ResultUtil.error("待审核状态，无法进行提交建议");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("提交失败");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }


    /**
     * 审批注销社团（逻辑删除）
     * @param
     * @return
     */
    @RequiresPermissions(value = {"resource:community:writeoff"}, logical = Logical.OR)
    @PostMapping(value = "/writeoff")
    public ResponseVO writeOff(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            clubRegistrationApplicationsService.writeOffUser(id);
        }
        return ResultUtil.success("成功注销 [" + ids.length + "] 个用户");
    }


    @RequiresPermissions(value = {"resource:community:submitwriteoff"}, logical = Logical.OR)
    @PostMapping(value = "/submitwriteoff")
    public ResponseVO submitwriteoff(ClubCancellationEntity clubCancellation) {
        if (null == clubCancellation) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        int i=clubCancellationService.submitwriteoff(clubCancellation);
        if (i == 0){
            return ResultUtil.error("提交注销失败，请检查你的审批状态是否符合要求");
        }
        return ResultUtil.success("成功提交注销 [" + 1 + "] 个社团");
    }

}
