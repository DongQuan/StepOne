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
        
9. request.setAttribute()、session.setAttribute()和request.getParameter()、request.getAttribute()的联系与区别:[原文链接][3]

10. spring mvc session超时，处理ajax请求:[原文链接][4]

11. 放在服务器上的项目总是意外清除session的解决办法：

        有可能造成该问题的原因：在本地打包war文件的时候，会有一个警告，说是javaee-****.jar没有load，session是和这个jar包相关联的，没有加载这个包就会出问题。
        解决办法：<dependency>
                         <groupId>javax</groupId>
                         <artifactId>javaee-web-api</artifactId>
                         <version>7.0</version>
                         <scope>provided</scope>
                     </dependency>
                     在pom.xml里面添加<scope>provided</scope>这一行


12. Spring MVC 文件上传下载:[原文链接][5]

13. springmvc文件上传下载:[原文链接][6]

14. Spring MVC 文件下载功能：

         /**
             * 测试下载
             */
            @RequestMapping(value = "/download", method = RequestMethod.GET)
        //    public ResponseEntity<byte[]> download() throws IOException {
        //        HttpHeaders headers = new HttpHeaders();
        //        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //        headers.setContentDispositionFormData("attachment", "dict.txt");
        //        File file = new File("/attachment/test.txt");
        //        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File("/attachment/test.txt")),
        //                headers, HttpStatus.CREATED);
        //    }
            public static void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
                // 得到要下载的文件名
                String fileName = request.getParameter("filename");
                fileName = "test.txt";
                fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
                ServletContext sc = request.getSession().getServletContext();
                String fileSaveRootPath = sc.getRealPath("/attachment");
                File file = new File(fileSaveRootPath + "/" + fileName);
        //        File file = new File("/attachment/test/txt");
                // 如果文件不存在
                if (!file.exists()) {
                    request.setAttribute("message", "您要下载的资源已被删除！！");
                    System.out.println("您要下载的资源已被删除！！");
                    return;
                }
                // 处理文件名
                String realname = fileName.substring(fileName.indexOf("_") + 1);
                // 设置响应头，控制浏览器下载该文件
                response.setHeader("content-disposition", "attachment;filename="
                        + new String(realname.getBytes("utf-8"), "ISO8859-1"));
                // 读取要下载的文件，保存到文件输入流
                FileInputStream in = new FileInputStream(fileSaveRootPath + "/" + fileName);
                // 创建输出流
                OutputStream out = response.getOutputStream();
                // 创建缓冲区
                byte buffer[] = new byte[1024];
                int len = 0;
                // 循环将输入流中的内容读取到缓冲区当中
                while ((len = in.read(buffer)) > 0) {
                    // 输出缓冲区的内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }
                // 关闭文件输入流
                in.close();
                // 关闭输出流
                out.close();
            }

[1]: http://blog.sina.com.cn/s/blog_4f925fc30102ed40.html
[2]: http://www.cnblogs.com/fjsnail/p/3491033.html
[3]: http://blog.csdn.net/happyflyingave/article/details/8045447
[4]: http://my.oschina.net/zhk/blog/323452
[5]: http://blog.csdn.net/geloin/article/details/7537425
[6]: http://luoqi-email.iteye.com/blog/2122849