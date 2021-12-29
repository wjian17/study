package org.cmp.security.config;

import cn.hutool.core.util.ArrayUtil;
import com.analizy.cmp.core.constant.HttpConstant;
import com.analizy.cmp.core.resp.CmpResponse;
import org.cmp.security.excp.OauthErrorCode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import java.io.PrintWriter;

/**
 * @author: wangjian
 * @date: 2021/01/19 10:15
 */
//@Configuration
//@ConditionalOnMissingBean(WebSecurityConfigurerAdapter.class)
//@EnableResourceServer
//@ConditionalOnProperty(prefix = "config.oauth-resource", name = "enable", havingValue = "true")
public class CmpResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private RemoteTokenServices remoteTokenServices;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${spring.application.name:resourceId}")
    private String resourceId;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId(resourceId)
                .accessDeniedHandler((req, resp, authentication) -> {
                    resp.setContentType(HttpConstant.APPLICATION_JSON);
                    CmpResponse cmpResponse = new CmpResponse(OauthErrorCode.FORBIDDEN);
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(cmpResponse));
                    out.flush();
                    out.close();
                })
                .authenticationEntryPoint((req, resp, authentication) -> {
                    resp.setContentType(HttpConstant.APPLICATION_JSON);
                    CmpResponse cmpResponse = new CmpResponse(OauthErrorCode.UNAUTHORIZED);
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(cmpResponse));
                    out.flush();
                    out.close();
                });
    }

    private static String[] basicIgnoreUrls = new String[]{
            "/login",
            "/actuator/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/webjars/**",
            "/favicon.ico",
            "/v*/api-docs",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/doc.html",
            "/api/base/v1/api-docs",
            "/oauth/**",
            "/remote/**"
    };

    @Value("${config.security.ignoreUrls:ignoreUrls}")
    private String[] ignoreUrls;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(ArrayUtil.addAll(basicIgnoreUrls, ignoreUrls)).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
