package com.zyd.shiro.business.service;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.vo.ClubCancellationVO;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubCancellation;


/**
 * @author liulei
 * @date 2023.09.28 上午 10:02
 * @Description
 */
public interface ClubCancellationService extends AbstractService<ClubCancellationEntity, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubCancellation> findPageBreakByCondition(ClubCancellationVO vo);

    int submitwriteoff(ClubCancellationEntity entity);

    int updateSelective2(ClubCancellationEntity clubCancellationEntity);
}
