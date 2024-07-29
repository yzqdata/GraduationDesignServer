package com.zyd.shiro.persistence.mapper;
import com.zyd.shiro.business.vo.ClubTrainingRoleVO;
import com.zyd.shiro.persistence.beans.ClubTrainingRole;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author liulei
 * @date 2023.09.28 下午 04:15
 * @Description
 */
@Repository
public interface ClubTrainingRoleMapper extends BaseMapper<ClubTrainingRole> {

    List<ClubTrainingRole> findPageBreakByCondition(ClubTrainingRoleVO vo);

    List<ClubTrainingRole> findByRoleClubTrainingId(Map<String, Object> map);
}
