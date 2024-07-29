package com.zyd.shiro.business.service;


import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.entity.ClubTrainingRoleEntity;
import com.zyd.shiro.business.vo.ClubTrainingRoleVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;

import java.util.List;
import java.util.Map;


/**
 * @author liulei
 * @date 2023.11.20 下午 02:43
 * @Description
 */
public interface ClubTrainingRoleService extends AbstractService<ClubTrainingRoleEntity, Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubTrainingRole> findPageBreakByCondition(ClubTrainingRoleVO vo);

    int addTraining(Long id);

    List<ClubTrainingRoleEntity> findByRoleClubTrainingId(Map<String, Object> map);
}
