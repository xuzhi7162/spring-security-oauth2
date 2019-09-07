package com.xuzhi.oauth2.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                // client_ID
                .withClient("client")
                // secret_ID，客户端ID，客户端安全码
                .secret("secret")
                // 授权类型，授权模式，有四种
                .authorizedGrantTypes("authorization_code")
                // 作用域，区分客户端类型
                .scopes("app")
                // 回调地址
                .redirectUris("https://www.zyyz.pro");
    }
}
