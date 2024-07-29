package com.zyd.shiro.business.service;

import com.github.pagehelper.PageInfo;
import com.zyd.shiro.business.entity.ClubMembershipEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.vo.ClubMembershipVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubMembership;

import java.util.List;
import java.util.Map;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:38
 * @Description
 */
public interface ClubMembershipService extends AbstractService<ClubMembershipEntity, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubMembership> findPageBreakByCondition(ClubMembershipVO vo);

    int rtsqs(Long id);

    List<ClubMembershipEntity> findByApplicantIdAndClubId(Map<String, Object> map);


    int updateSelective2(ClubMembershipEntity clubMembershipEntity);
}
