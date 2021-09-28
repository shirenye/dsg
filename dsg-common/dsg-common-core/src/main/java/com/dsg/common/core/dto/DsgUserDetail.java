package com.dsg.common.core.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 用户信息
 * @author cdw
 * @date 2021/9/3 21:18
 */
public class DsgUserDetail extends User {

    public DsgUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
