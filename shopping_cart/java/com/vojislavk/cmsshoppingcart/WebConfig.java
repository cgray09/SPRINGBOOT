package com.vojislavk.cmsshoppingcart;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("home");
    // }

    // function isnt needed for uploading but for editing a file after
    // its uploaded
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/media/**") // all files in this folder
            .addResourceLocations("file:/C:/Users/Voja/Desktop/cmsshoppingcart/src/main/resources/static/media/");
    }
    
}