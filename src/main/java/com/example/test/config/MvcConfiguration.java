package com.example.test.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl; // Add this import statement
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry; // Add this import statement
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Add this import statement

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}