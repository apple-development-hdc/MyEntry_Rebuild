package com.myentry.MyEntry.Utils;


/**
 * This class will extend Spring's AuthenticationEntryPoint class and override its method .
 * It rejects every unauthenticated request and send error code 401
 */
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
/**
 * Author :SAURAV ROY
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    /**
     * Commence the API throw the PreAuthorizer
     * @param request {@link HttpServletResponse}
     * @param response {@link HttpServletResponse}
     * @param authException {@link AuthenticationException}
     * @throws IOException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
