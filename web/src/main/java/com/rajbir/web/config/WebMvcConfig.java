package com.rajbir.web.config;

/**
 * Created by Sony on 03-09-2017.
 */

import com.rajbir.config.AbstractWebMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sony on 03-09-2017.
 */
//@Profile(value = {"dev", "prod", "local"})
@Configuration
@ComponentScan(value = {"com.rajbir.core"})
//@PropertySource("classpath:${spring.profiles.active}/base.properties")
class WebMvcConfig extends AbstractWebMvcConfig {


}
