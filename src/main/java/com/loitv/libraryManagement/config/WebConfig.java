package com.loitv.libraryManagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/assets/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/assets/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/assets/img/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/assets/fonts/");
        registry.addResourceHandler("/view/**").addResourceLocations("/WEB-INF/view/");

    }
}
