package org.cmp.security.listener;

import com.analizy.cmp.core.util.SpringApplicationUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.stereotype.Component;

/**
 * @author: wangjian
 * @date: 2021/04/30 16:53
 */
@Component
@ConditionalOnProperty(prefix = "config.oauth", name = "enable", havingValue = "true")
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AuthorizationEndpoint authorizationEndpoint = SpringApplicationUtil.getApplicationContext().getBean(AuthorizationEndpoint.class);
        authorizationEndpoint.setErrorPage("forward:/slefOAuth/error");
    }
}
