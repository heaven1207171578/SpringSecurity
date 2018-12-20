package com.bucom.boot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginfailureHandler loginfailureHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }


    //基于HTTP请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic()Basic认证
        http.formLogin() //表单认证
            .loginPage("/login.html")
            .successHandler(loginSuccessHandler)
            .failureHandler(loginfailureHandler)
           // .loginPage("/authentication/require")
            .and()
            .authorizeRequests()//请求的授权↓
            .antMatchers("/login.html","/*.js").permitAll()///loginCang.html这个路径授权匹配,不需要身份认证
            .anyRequest()//任何请求
            .authenticated()//认证(都需要身份认证审核)
            .and().csrf().disable();//csrf请求伪造拦截暂关闭
        //用表单登陆的任何请求都需要身份认证审核

    }
}
