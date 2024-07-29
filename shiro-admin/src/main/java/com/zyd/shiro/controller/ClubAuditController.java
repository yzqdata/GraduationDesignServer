package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubAuditService;
import com.zyd.shiro.business.vo.ClubAuditVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubAudit;

import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.09.28 下午 02:49
 * @Description
 */
@RestController
@RequestMapping("/audit")
public class ClubAuditController {
    @Autowired
    private ClubAuditService clubAuditService;

    @RequiresPermissions("audit")
    @PostMapping("/list")
    public PageResult list(ClubAuditVO vo) {
        PageInfo<ClubAudit> pageInfo = clubAuditService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }


    /**
     * @Author: liulei
     * @Description: 添加审批信息
     * @Date: 2023.11.13 上午 11:05
     * @Param: [clubRegistration]
     * @return: [com.zyd.shiro.business.entity.ClubRegistration]
     **/
    @RequiresPermissions("resource:audit:add")
    @PostMapping("/add")
    public ResponseVO add(ClubAuditEntity clubAuditEntity) {
        try {
            clubAuditService.insert(clubAuditEntity);
            return ResultUtil.success("添加审批信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("添加审批信息失败");
        }
    }


    /**
     * 管理员审批用于回显审批的信息
     * @param id
     * @return
     */
    @RequiresPermissions("resource:audit:adminshenpi")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.clubAuditService.getByPrimaryKey(id));
    }


    /**
     * @Author: liulei
     * @Description: 审批事件的状态
     * @Date: 2023.11.13 上午 11:05
     * @Param: [clubRegistration]
     * @return: [com.zyd.shiro.business.entity.ClubRegistration]
     **/
    @RequiresPermissions("resource:audit:adminshenpi")
    @PostMapping("/edit")
    public ResponseVO edit(ClubAuditEntity clubAuditEntity) {
        try {
            int val =clubAuditService.updateSelective2(clubAuditEntity);
            if (val == 2){
                return ResultUtil.error("当前状态是待审批，请重新审批");
            }else if (val == 3){
                return ResultUtil.error("无需重复审批");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("审批事项失败");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

}
