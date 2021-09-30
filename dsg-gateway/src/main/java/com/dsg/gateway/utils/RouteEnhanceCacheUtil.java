package com.dsg.gateway.utils;


import com.dsg.common.core.constant.DsgConstant;

/**
 * @author MrBird
 */
public abstract class RouteEnhanceCacheUtil {

    private static final String BLACKLIST_CHACHE_KEY_PREFIX = "Dsg:route:blacklist:";
    private static final String RATELIMIT_CACHE_KEY_PREFIX = "Dsg:route:ratelimit:";
    private static final String RATELIMIT_COUNT_KEY_PREFIX = "Dsg:route:ratelimit:cout:";

    public static String getBlackListCacheKey(String ip) {
        if (DsgConstant.LOCALHOST.equalsIgnoreCase(ip)) {
            ip = DsgConstant.LOCALHOST_IP;
        }
        return String.format("%s%s", BLACKLIST_CHACHE_KEY_PREFIX, ip);
    }

    public static String getBlackListCacheKey() {
        return String.format("%sall", BLACKLIST_CHACHE_KEY_PREFIX);
    }

    public static String getRateLimitCacheKey(String uri, String method) {
        return String.format("%s%s:%s", RATELIMIT_CACHE_KEY_PREFIX, uri, method);
    }

    public static String getRateLimitCountKey(String uri, String ip) {
        return String.format("%s%s:%s", RATELIMIT_COUNT_KEY_PREFIX, uri, ip);
    }
}
