package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubMembershipEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubMembershipService;
import com.zyd.shiro.business.vo.ClubMembershipVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubMembership;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:36
 * @Description
 */
@RestController
@RequestMapping("/membership")
public class ClubMembershipController {

    @Autowired
    private ClubMembershipService clubMembershipService;

    @RequiresPermissions("membership")
    @PostMapping("/list")
    public PageResult list(ClubMembershipVO vo) {
        PageInfo<ClubMembership> pageInfo = clubMembershipService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @RequiresPermissions("resource:membership:membershipedit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.clubMembershipService.getByPrimaryKey(id));
    }

    /**
     * 审批入团
     * @param clubMembershipEntity
     * @return
     */
    @RequiresPermissions("resource:membership:membershipedit")
    @PostMapping("/edit")
    public ResponseVO edit(ClubMembershipEntity clubMembershipEntity) {
        try {
            int val=clubMembershipService.updateSelective2(clubMembershipEntity);
            if (val == 2){
                return ResultUtil.error("当前审批为待审核状态，请重新审核");
            }else if (val == 3){
                return ResultUtil.error("已审批通过，无需重新审批");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("审批入团失败");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }
}
