package org.company.forward.study.feignserver.config.shiro;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class JWTUtilTest {

    private static Logger logger = LoggerFactory.getLogger(JWTUtilTest.class);

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODg0OTMyNDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.6sXWSGRHBaFGxofjkQkOe6s3WNaaQPtpMK4-n1M79fM";
    String username = "admin";
    String password = "admin123";

    @Test
    void verify() {
        logger.info(JWTUtil.verify(token,username,password)+"");
    }

    @Test
    void getUsername() {
        String username = JWTUtil.getUsername(token);
        logger.info(username);
    }

    @Test
    void sign() {
        String token = JWTUtil.sign(username,password);
        logger.info(token);
    }
}