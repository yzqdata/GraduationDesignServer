package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.service.ClubMembershipService;
import com.zyd.shiro.business.service.ClubRegistrationApplicationsService;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.10.04 上午 08:56
 * @Description
 */
@RestController
@RequestMapping("/usercommunity")
public class UserCommunityController {

    @Autowired
    private ClubRegistrationApplicationsService clubRegistrationApplicationsService;

    @Autowired
    private ClubMembershipService clubMembershipService;

    @RequiresPermissions("usercommunity")
    @PostMapping("/list")
    public PageResult list(ClubRegistrationConditionVO vo) {
        PageInfo<ClubRegistrationApplications> pageInfo = clubRegistrationApplicationsService.findPageBreakByCondition2(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 发起入团申请并且插入一条申请记录
     * @param ids
     * @return
     */
    @RequiresPermissions("resource:usercommunity:rtsq")
    @PostMapping(value = "/rtsq")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        //如果不存在成功申请返回0，如果存在记录并且状态是待审核返回1.如果存在审核通过返回2，如果存在审核不通过返回3
        int state=clubMembershipService.rtsqs(ids[0]);
        if (state ==0){
            return ResultUtil.success("申请成功");
        }else if (state ==1){
            return ResultUtil.success("已经提交申请，请勿重新提交，当前状态为待审核");
        }else if (state ==2){
            return ResultUtil.success("你已加入该社团");
        }else {
            return ResultUtil.success("已拒绝你加入该社团，详见入团记录表");
        }
    }
}
