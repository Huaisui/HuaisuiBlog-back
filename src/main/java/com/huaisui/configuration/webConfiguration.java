package com.huaisui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class webConfiguration {

    LoginInterceptor loginInterceptor = new LoginInterceptor();
    ErrorInterceptor errorInterceptor = new ErrorInterceptor();
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
                        if(response.getStatus()/100>=4){
                            System.err.println("访问URL:"+request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE));
                        }else {
                            System.out.println("访问URL:"+request.getRequestURI());
                        }
                    }
                });

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
                        .addResourceLocations("file:" + "C:/Users/49868/Desktop/Upload/");
                registry.addResourceHandler("/**")
                        .addResourceLocations("file:" + "D:\\Front_Test\\HuaisuiBlog\\");
            }
        };
    }
}
