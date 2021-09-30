package com.dsg.common.security.configure;

import com.dsg.common.core.constant.DsgConstant;
import com.dsg.common.core.utils.DsgUtil;
import com.dsg.common.security.handler.DsgAccessDeniedHandler;
import com.dsg.common.security.handler.DsgAuthExceptionEntryPoint;
import com.dsg.common.security.poperties.DsgSecurityProperties;
import feign.RequestInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.util.Base64Utils;

/**
 * @author MrBird
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(DsgSecurityProperties.class)
@ConditionalOnProperty(value = "Dsg.cloud.security.enable", havingValue = "true", matchIfMissing = true)
public class DsgSecurityAutoConfigure extends GlobalMethodSecurityConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public DsgAccessDeniedHandler accessDeniedHandler() {
        return new DsgAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public DsgAuthExceptionEntryPoint authenticationEntryPoint() {
        return new DsgAuthExceptionEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DsgSecurityInteceptorConfigure DsgCloudSecurityInteceptorConfigure() {
        return new DsgSecurityInteceptorConfigure();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(DefaultTokenServices.class)
    public DsgUserInfoTokenServices DsgUserInfoTokenServices(ResourceServerProperties properties) {
        return new DsgUserInfoTokenServices(properties.getUserInfoUri(), properties.getClientId());
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            String gatewayToken = new String(Base64Utils.encode(DsgConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(DsgConstant.GATEWAY_TOKEN_HEADER, gatewayToken);
            String authorizationToken = DsgUtil.getCurrentTokenValue();
            if (StringUtils.isNotBlank(authorizationToken)) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, DsgConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
            }
        };
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
