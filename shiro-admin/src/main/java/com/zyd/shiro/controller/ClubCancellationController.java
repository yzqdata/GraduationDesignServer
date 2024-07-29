package com.zyd.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.enums.ResponseStatus;
import com.zyd.shiro.business.service.ClubCancellationService;
import com.zyd.shiro.business.vo.ClubCancellationVO;
import com.zyd.shiro.framework.object.PageResult;
import com.zyd.shiro.framework.object.ResponseVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @date 2023.09.28 上午 10:00
 * @Description
 */
@RestController
@RequestMapping("/writeoff")
public class ClubCancellationController {

    @Autowired
    private ClubCancellationService clubCancellationService;

    @RequiresPermissions("writeoff")
    @PostMapping("/list")
    public PageResult list(ClubCancellationVO vo) {
        PageInfo<ClubCancellation> pageInfo = clubCancellationService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 注销社团审批过程根据id获取单个对象
     * @param id
     * @return
     */
    @RequiresPermissions("resource:writeoff:update")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.clubCancellationService.getByPrimaryKey(id));
    }

    /**
     * @Author: liulei
     * @Description: 添加审批信息
     * @Date: 2023.11.13 上午 11:05
     * @Param: [clubRegistration]
     * @return: [com.zyd.shiro.business.entity.ClubRegistration]
     **/
    @RequiresPermissions("resource:writeoff:update")
    @PostMapping("/edit")
    public ResponseVO edit(ClubCancellationEntity clubCancellationEntity) {
        try {
            int val =clubCancellationService.updateSelective2(clubCancellationEntity);
            if (val == 2){
                return ResultUtil.error("提交的状态为待审核，请检查状态");
            }else if (val == 3){
                return ResultUtil.error("已注销，状态无法继续更新");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("审批注销失败");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

}
