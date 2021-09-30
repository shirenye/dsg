package com.dsg.common.security.configure;

import com.dsg.common.security.interceptor.DsgServerProtectInterceptor;
import com.dsg.common.security.poperties.DsgSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MrBird
 */
public class DsgSecurityInteceptorConfigure implements WebMvcConfigurer {

    private DsgSecurityProperties properties;

    @Autowired
    public void setProperties(DsgSecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public HandlerInterceptor febsServerProtectInterceptor() {
        DsgServerProtectInterceptor dsgServerProtectInterceptor = new DsgServerProtectInterceptor();
        dsgServerProtectInterceptor.setProperties(properties);
        return dsgServerProtectInterceptor;
    }

    @Override
    @SuppressWarnings("all")
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(febsServerProtectInterceptor());
    }
}
