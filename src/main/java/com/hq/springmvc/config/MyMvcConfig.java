package com.hq.springmvc.config;

import com.hq.springmvc.converter.MyMessageConverter;
import com.hq.springmvc.interceptors.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by hq on 17/10/15.
 */
@Configuration
@EnableWebMvc  //开启默认的mvc配置,开启SpringMvc支持,否则重写WebMvcConfigurerAdapter方法无效
@EnableScheduling
@ComponentScan("com.hq.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * ViewResolver是springmvc视图渲染的核心机制:spring'mvc里有个接口叫做ViewResolver(InternalResourceViewResolver实现了该接口)
     * 实现该接口需重写resolveViewName(),该方法返回值是接口View,而View的指责是使用model、request、response对象渲染视图并返回给
     * 浏览器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/classes/views/");  //运行时项目视图目录结构
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Bean  //配置文件上传信息
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10000000);
        return resolver;
    }

    @Bean  //添加自定义信息转换Bean
    public MyMessageConverter myMessageConverter() {
        return new MyMessageConverter();
    }

    @Override  //实现该方法会在已有的Converter中追加,不会覆盖默认注册的Converter
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        converters.add(myMessageConverter());  //将自定义的信息转换进行注册
    }

    @Override  //添加注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(demoInterceptor());
    }

    @Override  //配置静态资源映射
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        //addResourceLocations指文件放置的目录,addResourceHandler指对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override  //配置视图  可对视图进行配置
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/toUpload").setViewName("upload");
        registry.addViewController("/toConverter").setViewName("converter");
        registry.addViewController("/toAsync").setViewName("async");
    }

    @Override  //通过重写该方法 可实现路径中的多个配置
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false); //取消忽略后缀匹配, 可以获取路径点(.)后面的数据
    }


}
