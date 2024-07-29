package com.zyd.shiro.persistence.mapper;

import com.zyd.shiro.business.vo.ClubMembershipVO;
import com.zyd.shiro.business.vo.ClubRegistrationConditionVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.persistence.beans.ClubMembership;
import com.zyd.shiro.persistence.beans.ClubRegistrationApplications;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liulei
 * @date 2023.10.04 上午 09:44
 * @Description
 */
@Repository
public interface ClubMembershipMapper  extends BaseMapper<ClubMembership> {

    List<ClubMembership> findPageBreakByCondition(ClubMembershipVO vo);

    List<ClubMembership> findByApplicantIdAndClubId(Map<String, Object> map);

    List<ClubMembership> findPageBreakByCondition2(HashMap<String, Object> hashMap);

    List<ClubMembership> findPageBreakByCondition3(HashMap<String, Object> hashMap);
}
