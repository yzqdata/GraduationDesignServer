package com.zyd.shiro.persistence.mapper;

import com.zyd.shiro.business.entity.ClubCancellationEntity;
import com.zyd.shiro.business.vo.ClubCancellationVO;
import com.zyd.shiro.persistence.beans.ClubCancellation;
import com.zyd.shiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author liulei
 * @date 2023.09.28 上午 10:16
 * @Description
 */
@Repository
public interface ClubCancellationMapper extends BaseMapper<ClubCancellation> {

    List<ClubCancellation> findPageBreakByCondition(ClubCancellationVO vo);

    List<ClubCancellation> findPageBreakByCondition2(HashMap<String, Object> hashMap);
}
