package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubTrainingRoleEntity;
import com.zyd.shiro.business.service.ClubTrainingRoleService;
import com.zyd.shiro.business.vo.ClubTrainingRoleVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.11.20 下午 02:26
 * @Description
 */

@RestController
@RequestMapping("/trainingrole")
public class ClubTrainingRoleController {

    @Autowired
    private ClubTrainingRoleService clubTrainingRoleService;


    @RequiresPermissions("trainingrole")
    @PostMapping("/list")
    public PageResult getAll(ClubTrainingRoleVO vo) {
        PageInfo<ClubTrainingRole> pageInfo = clubTrainingRoleService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }



    @RequiresPermissions("resource:trainingrole:addtraining")
    @PostMapping("/addtraining")
    public ResponseVO addTraining(Long[] ids){
        try {
            int satus=clubTrainingRoleService.addTraining(ids[0]);
            if (satus == 0){
                return ResultUtil.success("你已报名，无须重复报名，请及时参加培训！！！");
            }else if (satus == 2){
                return ResultUtil.success("报名失败，报名人数已满！！！");
            }
            return ResultUtil.success("报名成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("error");
        }
    }

}
