####Spring-MVC配置文件

1. 版本1：

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		       xmlns:context="http://www.springframework.org/schema/context"
		       xmlns:mvc="http://www.springframework.org/schema/mvc"
		       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
	
	    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
	    <context:component-scan base-package="me.test.controller"/>
	
	    <!--避免IE执行AJAX时，返回JSON出现下载文件 -->
	    <!--Jxuan:需要引入jackson jar包-->
	    <!--<bean id="mappingJacksonHttpMessageConverter"-->
	    <!--class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">-->
	    <!--<property name="supportedMediaTypes">-->
	    <!--<list>-->
	    <!--<value>text/html;charset=UTF-8</value>-->
	    <!--</list>-->
	    <!--</property>-->
	    <!--</bean>-->
	
	    <!-- 启动SpringMVC的注解功能，完成请求和注解POJO的映射 -->
	    <!--<bean-->
	    <!--class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">-->
	    <!--<property name="messageConverters">-->
	    <!--<list>-->
	    <!--<ref bean="mappingJacksonHttpMessageConverter" /> &lt;!&ndash; JSON转换器 &ndash;&gt;-->
	    <!--</list>-->
	    <!--</property>-->
	    <!--</bean>-->
	
	    <!-- HandlerMapping -->
	    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
	
	    <!-- HandlerAdapter -->
	    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
	
	    <!-- 定义跳转的文件的前后缀 ，视图模式配置-->
	    <!--Jxuan:这是配置jsp的，本项目使用beetl-->
	    <!--<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
	    <!--&lt;!&ndash; 这里的配置我的理解是自动给后面action的方法return的字符串加上前缀和后缀，变成一个 可用的url地址 &ndash;&gt;-->
	    <!--<property name="prefix" value="/pages/"/>-->
	    <!--<property name="suffix" value=".jsp"/>-->
	    <!--</bean>-->
	
	    <!--配置beetl-->
	    <bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
	    </bean>
	    <bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
	        <property name="prefix" value="/pages/"/>
	        <property name="suffix" value=".html"/>
	        <property name="contentType" value="text/html;charset=UTF-8"/>
	    </bean>
	
	    <!-- 配置文件上传，如果没有使用文件上传可以不用配置，当然如果不配，那么配置文件中也不必引入上传组件包 -->
	    <bean id="multipartResolver"
	          class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	        <!-- 默认编码 -->
	        <property name="defaultEncoding" value="utf-8"/>
	        <!-- 文件大小最大值 -->
	        <property name="maxUploadSize" value="10485760000"/>
	        <!-- 内存中的最大值 -->
	        <property name="maxInMemorySize" value="40960"/>
	    </bean>
	
	    <!-- 对静态资源文件的访问  方案一 （二选一） -->
	    <!--<mvc:default-servlet-handler/>-->
	
	    <!-- 对静态资源文件的访问  方案二 （二选一）-->
	    <mvc:resources location="/pages/" mapping="/pages/**"/>
	    <mvc:resources location="/image/" mapping="/image/**"/>
	    <mvc:resources location="/js/" mapping="/js/**"/>
	    <mvc:resources location="/css/" mapping="/css/**"/>
	    <mvc:resources location="/slide_pic/" mapping="/slide_pic/**"/>
	
	    <mvc:annotation-driven />
	
	    <!--配置自定义拦截器-->
	    <mvc:interceptors>
	        <mvc:interceptor>
	            <mvc:mapping path="/admin/**"/>
	            <mvc:mapping path="/user/**"/>
	            <mvc:exclude-mapping path="/admin/checkLogin"/>
	            <mvc:exclude-mapping path="/user/checkLogin"/>
	            <bean class="me.test.interceptor.Interceptor"/>
	        </mvc:interceptor>
	    </mvc:interceptors>
	
		</beans>

2.版本2：

        <?xml version="1.0" encoding="UTF-8"?>  
        <beans xmlns="http://www.springframework.org/schema/beans"  
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"  
            xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"  
            xmlns:jdbc="http://www.springframework.org/schema/jdbc" xmlns:mvc="http://www.springframework.org/schema/mvc"  
            xmlns:util="http://www.springframework.org/schema/util"  
            xsi:schemaLocation="http://www.springframework.org/schema/beans  
                             http://www.springframework.org/schema/beans/spring-beans.xsd  
                             http://www.springframework.org/schema/tx  
                             http://www.springframework.org/schema/tx/spring-tx.xsd  
                             http://www.springframework.org/schema/context   
                             http://www.springframework.org/schema/context/spring-context.xsd  
                             http://www.springframework.org/schema/aop  
                             http://www.springframework.org/schema/aop/spring-aop.xsd  
                             http://www.springframework.org/schema/jdbc  
                             http://www.springframework.org/schema/jdbc/spring-jdbc-3.2.xsd  
                             http://www.springframework.org/schema/util        
                             http://www.springframework.org/schema/util/spring-util-3.2.xsd  
                             http://www.springframework.org/schema/mvc   
                             http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">  
            <!-- spring自动扫描注解的组件 -->  
            <context:component-scan base-package="cn.xx.xx"  
                use-default-filters="false">  
                <context:include-filter expression="org.springframework.stereotype.Controller"  
                    type="annotation" />  
            </context:component-scan>  
          
            <mvc:annotation-driven>  
                <mvc:message-converters>  
                    <ref bean="stringHttpMessageConverter" />  
                    <ref bean="fastJsonHttpMessageConverter" />  
                    <ref bean="marshallingHttpMessageConverter" />  
                </mvc:message-converters>  
            </mvc:annotation-driven>  
          
            <bean id="stringHttpMessageConverter"  
                class="org.springframework.http.converter.StringHttpMessageConverter">  
                <constructor-arg value="UTF-8" index="0"></constructor-arg><!--  
                    避免出现乱码 -->  
                <property name="supportedMediaTypes">  
                    <list>  
                        <value>text/plain;charset=UTF-8</value>  
                    </list>  
                </property>  
            </bean>  
            <bean id="fastJsonHttpMessageConverter"  
                class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">  
          
                <property name="supportedMediaTypes">  
                    <list>  
                        <value>application/json;charset=UTF-8</value>  
                        <value>text/html;charset=UTF-8</value><!-- 避免IE出现下载JSON文件的情况 -->  
                    </list>  
                </property>  
                <property name="features">  
                    <util:list>  
                        <!-- <value>WriteMapNullValue</value> -->  
                        <value>QuoteFieldNames</value>  
                        <value>WriteDateUseDateFormat</value>  
                    </util:list>  
                </property>  
            </bean>  
              
            <bean id="marshallingHttpMessageConverter"  
                class="org.springframework.http.converter.xml.MarshallingHttpMessageConverter">  
                <property name="marshaller" ref="castorMarshaller" />  
                <property name="unmarshaller" ref="castorMarshaller" />  
                <property name="supportedMediaTypes">  
                    <list>  
                        <value>text/xml;charset=UTF-8</value>  
                        <value>application/xml;charset=UTF-8</value>  
                    </list>  
                </property>  
            </bean>  
          
            <!-- 返回类型定义 -->  
            <util:list id="messageConverters">  
                <ref bean="stringHttpMessageConverter" />  
                <ref bean="fastJsonHttpMessageConverter" />  
                <ref bean="marshallingHttpMessageConverter" />  
            </util:list>  
          
            <bean id="castorMarshaller" class="org.springframework.oxm.castor.CastorMarshaller" />  
          
            <!-- AOP自动注解功能 -->  
            <aop:aspectj-autoproxy />  
          
            <!-- 不进行拦截的 -->  
            <mvc:resources location="/" mapping="/**/*.html" order="0" />  
            <mvc:resources location="/images/" mapping="/images/**" />  
            <mvc:resources location="/img/" mapping="/img/**" />  
            <mvc:resources location="/download/" mapping="/download/**" />  
          
            <mvc:resources location="/js/" mapping="/js/**" />  
            <mvc:resources location="/css/" mapping="/css/**" />  
            <mvc:resources location="/plugin/" mapping="/plugin/**" />  
            <mvc:resources location="/WEB-INF/pages/" mapping="/pages/**" />  
          
            <bean id="messageSource"  
                class="org.springframework.context.support.ResourceBundleMessageSource">  
                <property name="basename" value="messages"></property>  
            </bean>  
          
            <bean  
                class="org.springframework.web.servlet.view.InternalResourceViewResolver">  
                <property name="prefix" value="/WEB-INF/pages/" />  
                <property name="suffix" value=".jsp" />  
          
            </bean>  
          
            <!-- 支持上传文件 -->  
            <bean id="multipartResolver"  
                class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />  
          
            <!-- restTemplate -->  
            <bean id="restTemplate" class="org.springframework.web.client.RestTemplate">  
                <property name="messageConverters" ref="messageConverters">  
                </property>  
            </bean>  
        </beans>  