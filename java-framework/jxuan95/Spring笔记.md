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

