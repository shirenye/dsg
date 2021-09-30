package com.dsg.gateway.configure;

import com.dsg.common.core.constant.DsgConstant;
import com.dsg.gateway.runner.DsgRouteEnhanceRunner;
import com.dsg.gateway.service.BlackListService;
import com.dsg.gateway.service.RateLimitRuleService;
import com.dsg.gateway.service.RouteEnhanceCacheService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author MrBird
 */
@EnableAsync
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.dsg.gateway.mapper")
@ConditionalOnProperty(name = "febs.gateway.enhance", havingValue = "true")
public class DsgRouteEnhanceConfigure {

    @Bean(DsgConstant.ASYNC_POOL)
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("Febs-Gateway-Async-Thread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean
    public ApplicationRunner febsRouteEnhanceRunner(RouteEnhanceCacheService cacheService,
                                                    BlackListService blackListService,
                                                    RateLimitRuleService rateLimitRuleService) {
        return new DsgRouteEnhanceRunner(cacheService, blackListService, rateLimitRuleService);
    }
}
