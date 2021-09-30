package com.dsg.common.security.handler;

import com.dsg.common.core.entity.DsgResponse;
import com.dsg.common.core.utils.DsgUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cdw
 */
public class DsgAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        DsgResponse dsgResponse = new DsgResponse();
        DsgUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, dsgResponse.message("没有权限访问该资源"));
    }
}
