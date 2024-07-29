package com.zyd.shiro.persistence.mapper;


import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.persistence.beans.SysUser;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClubRegistrationApplicationsMapper extends BaseMapper<ClubRegistrationApplications> {

    List<ClubRegistrationApplications> findPageBreakByCondition(ClubRegistrationConditionVO vo);

    List<ClubRegistrationApplications> findByApplicantId(Map<String, Object> map);

    List<ClubRegistrationApplications> findPageBreakByCondition2(ClubRegistrationConditionVO vo);

    List<ClubRegistrationApplications> findPageBreakByCondition3(Map<String, Object> map);
}
