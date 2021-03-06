package com.mnaufalazwar.springsecurityjpa.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnaufalazwar.springsecurityjpa.dto.ResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        ResponseDto responseDTO = new ResponseDto("401", authEx.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        writer.println(objectMapper.writeValueAsString(responseDTO));
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Utangku App");
        super.afterPropertiesSet();
    }

}
