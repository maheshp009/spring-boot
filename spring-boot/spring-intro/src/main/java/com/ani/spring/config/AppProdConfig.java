package com.ani.spring.config;

import com.ani.spring.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class AppProdConfig {
    @Bean
    public DateUtil dateUtil1() {
        DateUtil util = new DateUtil();;
        util.setProfile("prod");
        return util;
    }
}
