package com.dsg.common.redis.propeties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis线程池配置类
 *
 * @author cdw
 * @date 2021-04-23
 */
@ConfigurationProperties(prefix = "dsg.lettuce.redis")
public class DsgLettuceRedisProperties {
    /**
     * 是否开启Lettuce Redis
     */
    private Boolean enable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "DsgLettuceRedisProperties{" +
                "enable=" + enable +
                '}';
    }
}
