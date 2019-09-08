package com.xuzhi.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


    /**
     * 采用 SpringJDBC 获取数据源，排除掉原有的 DataSource ， 将自己配置的 DataSource 加入
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {













        /**
        // 基于内存存储令牌
        clients
                .inMemory()
                // client_ID
                .withClient("client")
                // secret_ID，客户端ID，客户端安全码
                .secret(passwordEncoder.encode("secret"))
                // 授权类型，授权模式，有四种
                .authorizedGrantTypes("authorization_code")
                // 作用域，区分客户端类型
                .scopes("app")
                // 回调地址
                .redirectUris("https://www.zyyz.pro");

         **/
    }
}
