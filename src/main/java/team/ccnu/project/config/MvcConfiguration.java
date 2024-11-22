package team.ccnu.project.config;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry; // Add this import statement
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Add this import statement

import team.ccnu.project.interceptor.WriteInterceptor; // Add this import statement

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private WriteInterceptor viewInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/")
                .addResourceLocations("classpath:/static/css/images")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(viewInterceptor).addPathPatterns("/**/write/**");

    }
}