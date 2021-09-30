package com.dsg.common.gateway.configure;

import com.dsg.common.gateway.handler.DsgDocGatewayHandler;
import com.dsg.common.gateway.filter.DsgDocGatewayHeaderFilter;
import com.dsg.common.gateway.properties.DsgDocGatewayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * @author MrBird
 */
@Configuration
@EnableConfigurationProperties(DsgDocGatewayProperties.class)
@ConditionalOnProperty(value = "dsg.doc.gateway.enable", havingValue = "true", matchIfMissing = true)
public class DsgDocGatewayAutoConfigure {

    private final DsgDocGatewayProperties dsgDocGatewayProperties;
    private SecurityConfiguration securityConfiguration;
    private UiConfiguration uiConfiguration;

    public DsgDocGatewayAutoConfigure(DsgDocGatewayProperties DsgDocGatewayProperties) {
        this.dsgDocGatewayProperties = DsgDocGatewayProperties;
    }

    @Autowired(required = false)
    public void setSecurityConfiguration(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

    @Autowired(required = false)
    public void setUiConfiguration(UiConfiguration uiConfiguration) {
        this.uiConfiguration = uiConfiguration;
    }

    @Bean
    public DsgDocGatewayResourceConfigure dsgDocGatewayResourceConfigure(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        return new DsgDocGatewayResourceConfigure(routeLocator, gatewayProperties);
    }

    @Bean
    public DsgDocGatewayHeaderFilter dsgDocGatewayHeaderFilter() {
        return new DsgDocGatewayHeaderFilter();
    }

    @Bean
    public DsgDocGatewayHandler dsgDocGatewayHandler(SwaggerResourcesProvider swaggerResources) {
        DsgDocGatewayHandler DsgDocGatewayHandler = new DsgDocGatewayHandler();
        DsgDocGatewayHandler.setSecurityConfiguration(securityConfiguration);
        DsgDocGatewayHandler.setUiConfiguration(uiConfiguration);
        DsgDocGatewayHandler.setSwaggerResources(swaggerResources);
        DsgDocGatewayHandler.setProperties(dsgDocGatewayProperties);
        return DsgDocGatewayHandler;
    }
}
