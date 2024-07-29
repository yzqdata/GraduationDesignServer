package com.zyd.shiro.business.service;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.vo.ClubAuditVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubAudit;


/**
 * @author liulei
 * @date 2023.09.28 下午 02:53
 * @Description
 */
public interface ClubAuditService extends AbstractService<ClubAuditEntity, Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubAudit> findPageBreakByCondition(ClubAuditVO vo);

    int updateSelective2(ClubAuditEntity clubAuditEntity);
}
