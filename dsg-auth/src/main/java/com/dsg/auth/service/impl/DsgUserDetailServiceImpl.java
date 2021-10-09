package com.dsg.auth.service.impl;

import com.dsg.common.core.dto.DsgUserDetail;
import com.dsg.common.core.entity.system.SystemUser;
import com.dsg.manager.user.UserManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务实现类
 * @author cdw
 * @date 2021/9/3 21:32
 */
@Service
@RequiredArgsConstructor
public class DsgUserDetailServiceImpl implements UserDetailsService {

//    private final PasswordEncoder passwordEncoder;


    private final UserManager userManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());

             String password = systemUser.getPassword();

            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.NO_AUTHORITIES;
            if (StringUtils.isNotBlank(permissions)) {
                grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
            }
            DsgUserDetail authUser = new DsgUserDetail(systemUser.getUsername(), password, grantedAuthorities);

            BeanUtils.copyProperties(systemUser, authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }
}
