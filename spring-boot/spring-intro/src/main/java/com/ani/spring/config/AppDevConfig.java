package com.ani.spring.config;

import com.ani.spring.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class AppDevConfig {

    @Bean
    public DateUtil dateUtil1() {
        DateUtil util = new DateUtil();;
        util.setProfile("dev");
        return util;
    }

}
