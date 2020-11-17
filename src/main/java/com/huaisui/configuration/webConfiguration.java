package com.huaisui.configuration;

import com.huaisui.utils.myUrlUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfiguration {

    LoginInterceptor loginInterceptor = new LoginInterceptor();
    ErrorInterceptor errorInterceptor = new ErrorInterceptor();
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(loginInterceptor)
                        .addPathPatterns("/upload");

                registry.addInterceptor(errorInterceptor)
                        .addPathPatterns("/**");
            }


            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);
            }

            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径("file:"是规定写法)
                registry.addResourceHandler("/images/**")
                        .addResourceLocations("file:" + myUrlUtils.UPLOADED_FOLDER);
                registry.addResourceHandler("/**")
                        .addResourceLocations("file:" + myUrlUtils.frontFiles);
            }
        };
    }
}
