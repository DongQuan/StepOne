####Spring笔记

___

1. 从前端获取多个复选框的值：

	    request.getParameterValues("name");
	    这个可以把前端复选框的值转为一个数组

2. 配置异常页面：

		weh.xml:
			<error-page>
		        <error-code>404</error-code>
		        <location>/pages/exception.html</location>
		    </error-page>
	
		    <error-page>
		        <exception-type>java.lang.Exception</exception-type>
		        <location>/pages/exception.html</location>
			</error-page>

		spring-mvc.xml:
		
		<!--定义异常处理页面-->
		    <bean id="exceptionResolver" class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
		        <property name="exceptionMappings">
		            <props>
		                <!--<prop key="java.sql.SQLException">outException</prop>-->
		                <!--<prop key="java.io.IOException">outException</prop>-->
		                <prop key="java.lang.Throwable">Exception</prop>
		            </props>
		        </property>
		    </bean>

3. 前端发异步请求415错误解决办法：
		
		在spring-mvc配置文件中的adapter添加：
		<!-- HandlerAdapter -->
	    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">

	        <!--解决415错误-->
	        <property name="messageConverters">
	            <list>
	                <ref bean="jsonHttpMessageConverter" />
	            </list>
	        </property>
	    </bean>

		然后添加jackson包依赖：
		<!--添加jackson依赖包，解决415错误-->
	    <bean id="jsonHttpMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
	        <property name="supportedMediaTypes">
	            <list>
	                <value>application/json;charset=UTF-8</value>
	            </list>
	        </property>
	    </bean>
