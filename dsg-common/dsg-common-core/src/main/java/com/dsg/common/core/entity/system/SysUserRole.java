package com.dsg.common.core.entity.system;

import lombok.Data;

/**
 * 用户角色关联
 *
 * @author cdw
 * @date 2021-03-29
 */
@Data
public class SysUserRole {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;
}
