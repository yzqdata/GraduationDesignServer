package com.zyd.shiro.persistence.beans;

import com.zyd.shiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liulei
 * @date 2023.11.20 下午 02:32
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClubTrainingRole  extends AbstractDO {

    private Integer clubTrainingId;
    private Integer roleId;

}
