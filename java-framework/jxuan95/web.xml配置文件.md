####Web.xml配置文件

1. 版本1：

        <?xml version="1.0" encoding="UTF-8"?>
        <web-app version="2.5" 
            xmlns="http://java.sun.com/xml/ns/javaee" 
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
            http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
            
            <!-- 上下文参数（第一启动），指定jdbc配置文件位置  -->
            <context-param>
                <param-name>contextConfigLocation</param-name>  
                <param-value>classpath:/config/jdbc.xml</param-value>  
              </context-param>     
             
            <!-- spring监听器（第二启动），监听springMvc环境 -->
            <listener>  
                <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>  
            </listener>  
            
            <!-- springMvc编码拦截器（第三启动），springMvc内置的编码拦截器 -->
            <filter>  
                <filter-name>encodingFilter</filter-name>  
                <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>  
            </filter>  
             
            <filter-mapping>  
                <filter-name>encodingFilter</filter-name>  
                <url-pattern>/*</url-pattern>  
            </filter-mapping>
              
              <!-- springMvc前置总控制器（第四启动），在分发其它的控制器前都要经过这个总控制器 -->
            <servlet>  
                <servlet-name>spring-mvc</servlet-name>  
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>  
            <init-param>  
                <param-name>contextConfigLocation</param-name>  
                <param-value>classpath:/config/springmvc.xml</param-value>  
            </init-param>  
            <load-on-startup>2</load-on-startup>  
            </servlet>  
             
            <servlet-mapping>  
                <servlet-name>spring-mvc</servlet-name>  
                <url-pattern>*.do</url-pattern>  
            </servlet-mapping>  
            
            <!-- 网站的默认首页   -->
            <welcome-file-list>
                <welcome-file>begin.jsp</welcome-file>
            </welcome-file-list>
        </web-app>