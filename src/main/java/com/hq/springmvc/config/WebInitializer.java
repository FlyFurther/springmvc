package com.hq.springmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by hq on 17/10/15.
 */

/**
 * WebApplicationInitializer是spring提供用来配置servlet3.0+配置的接口,从而实现了替代web.xml的位置,实现该接口将会自动
 * 被SpringServletContainerInitializer(用来启动servlet3.0容器)获取到
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);//新建注册配置类,并将其和当前servletContext关联起来

        //注册springmvc的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true); //开启异步方法支持
    }
}
