package com.zyd.shiro.persistence.mapper;

import com.zyd.shiro.business.vo.ClubAuditVO;
import com.zyd.shiro.persistence.beans.ClubAudit;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * @author liulei
 * @date 2023.09.28 下午 03:04
 * @Description
 */
@Repository
public interface ClubAuditMapper extends BaseMapper<ClubAudit> {
    List<ClubAudit> findPageBreakByCondition(ClubAuditVO vo);

    List<ClubAudit> findPageBreakByCondition2(Map<String, Object> hashMap);
}
