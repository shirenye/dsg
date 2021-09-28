package com.dsg.common.core.entity.system;

import lombok.Data;

/**
 * 用户和岗位关联 sys_user_post
 *
 * @author cdw
 * @date 2021-03-29
 */
@Data
public class SysUserPost
{
    /** 用户ID */
    private Long userId;

    /** 岗位ID */
    private Long postId;


}
