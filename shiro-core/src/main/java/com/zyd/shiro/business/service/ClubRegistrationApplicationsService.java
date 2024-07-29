package com.zyd.shiro.business.service;


import com.github.pagehelper.PageInfo;

import com.zyd.shiro.business.entity.ClubAuditEntity;
import com.zyd.shiro.business.entity.ClubRegistration;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.framework.object.AbstractService;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;

import java.util.List;
import java.util.Map;

public interface ClubRegistrationApplicationsService extends AbstractService<ClubRegistration, Long>{

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ClubRegistrationApplications> findPageBreakByCondition(ClubRegistrationConditionVO vo);

    PageInfo<ClubRegistrationApplications> findPageBreakByCondition2(ClubRegistrationConditionVO vo);

    void writeOffUser(Long id);


    List<ClubRegistration> findByApplicantId(Map<String, Object> map);

    int updateSelective2(ClubRegistration clubRegistration);
}
