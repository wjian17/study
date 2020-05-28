package org.company.forward.study.feignserver.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}