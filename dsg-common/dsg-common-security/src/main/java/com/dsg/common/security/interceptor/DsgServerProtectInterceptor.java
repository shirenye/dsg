package com.dsg.common.security.interceptor;

import com.dsg.common.core.constant.DsgConstant;
import com.dsg.common.core.entity.DsgResponse;
import com.dsg.common.core.utils.DsgUtil;
import com.dsg.common.security.poperties.DsgSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MrBird
 */
public class DsgServerProtectInterceptor implements HandlerInterceptor {

    private DsgSecurityProperties properties;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws IOException {
        if (!properties.getOnlyFetchByGateway()) {
            return true;
        }
        String token = request.getHeader(DsgConstant.GATEWAY_TOKEN_HEADER);
        String gatewayToken = new String(Base64Utils.encode(DsgConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        if (StringUtils.equals(gatewayToken, token)) {
            return true;
        } else {
            DsgResponse febsResponse = new DsgResponse();
            DsgUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, febsResponse.message("请通过网关获取资源"));
            return false;
        }
    }

    public void setProperties(DsgSecurityProperties properties) {
        this.properties = properties;
    }
}
