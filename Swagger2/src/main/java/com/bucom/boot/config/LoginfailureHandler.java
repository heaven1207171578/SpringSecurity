package com.bucom.boot.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class LoginfailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger log=LoggerFactory.getLogger(getClass());


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        JSONObject res = new JSONObject();
        res.put("success",false);
        res.put("msg","登录失败,请检查账号密码是否正确");
        response.setStatus(500);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(res.toString());

    }
}
