package com.wsw.wswclient1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsw.wswclient1.entity.Hr;
import com.wsw.wswclient1.entity.ResponseBean;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author WangSongWen
 * @Date: Created in 11:21 2020/9/2
 * @Description: SSO客户端应用配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOAuth2Sso
public class ClientWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
        /*http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Hr hr = (Hr) authentication.getPrincipal();
                        hr.setPassword(null); //将返回给前端json中的密码隐藏
                        ResponseBean ok = ResponseBean.ok("登录成功！", hr);
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        ResponseBean error = ResponseBean.error("登录失败！");
                        if (e instanceof LockedException){
                            error.setMsg("账户被锁定，请联系管理员！");
                        }else if (e instanceof CredentialsExpiredException){
                            error.setMsg("密码过期，请联系管理员！");
                        }else if (e instanceof AccountExpiredException){
                            error.setMsg("账户过期，请联系管理员！");
                        }else if (e instanceof DisabledException){
                            error.setMsg("账户被禁用，请联系管理员！");
                        }else if (e instanceof BadCredentialsException){
                            error.setMsg("用户名或密码输入错误，请重新输入！");
                        }
                        String s = new ObjectMapper().writeValueAsString(error);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        ResponseBean ok = ResponseBean.ok("注销成功！");
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();*/
    }
}
