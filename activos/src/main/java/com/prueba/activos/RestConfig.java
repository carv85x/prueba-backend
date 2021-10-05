package com.prueba.activos;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class RestConfig extends WebMvcConfigurerAdapter {
	@Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
    }
}

