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
	    
	    在前端js中
	    
	    $.ajax({
                url: url,
                data: JSON.stringify(user),
                dataType: "json",
                type: "POST",
                contentType : 'application/json',
                success: function (data) {
                     console.log(data);
                }
               })
        设置contentType
        
4. ajax请求始终报405错误：
        
        问题原因除了网上常见的说法外还有一种就是版本问题，在解决415问题时需要添加jackson jar包，在spring4.2.X版本中是不能使用jackson 2.7.X版本的，使用之后也会造成
        405错误。
        
5. 服务器端maven打包war文件：

        在项目目录下运行mvn clean package命令，就会在target目录下生成该项目的war文件。
        
6. Maven编译代码的相关命令:[原文链接][1]

7. SpringMVC上传文件的三种方式：[原文链接][2]

8. FastJson日期格式化：

        FastJSON可以直接对日期类型格式化，在缺省的情况下，FastJSON会将Date转成long。
        
        例5：FastJSON将java.util.Date转成long。
        
        1 String dateJson = JSON.toJSONString(new Date());
        2 System.out.println(dateJson);
        输出结果：
        
        1401370199040
        例6：使用SerializerFeature特性格式化日期。
        
        1 String dateJson = JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat);
        2 System.out.println(dateJson);
        输出结果：
        
        "2014-05-29 21:36:24"
        也可以指定输出日期格式。
        
        例7：指定输出日期格式。
        
        1 String dateJson = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        2 System.out.println(dateJson);
        输出结果：
        
        "2014-05-29 21:47:00.154"



[1]: http://blog.sina.com.cn/s/blog_4f925fc30102ed40.html
[2]: http://www.cnblogs.com/fjsnail/p/3491033.html
