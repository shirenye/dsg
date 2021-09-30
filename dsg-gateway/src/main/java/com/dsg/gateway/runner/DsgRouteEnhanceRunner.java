package com.dsg.gateway.runner;

import com.dsg.gateway.service.BlackListService;
import com.dsg.gateway.service.RateLimitRuleService;
import com.dsg.gateway.service.RouteEnhanceCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author MrBird
 */
@RequiredArgsConstructor
public class DsgRouteEnhanceRunner implements ApplicationRunner {

    private final RouteEnhanceCacheService cacheService;
    private final BlackListService blackListService;
    private final RateLimitRuleService rateLimitRuleService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("已开启网关增强功能：请求日志、黑名单&限流。");
        cacheService.saveAllBlackList(blackListService.findAll());
        cacheService.saveAllRateLimitRules(rateLimitRuleService.findAll());
    }
}
