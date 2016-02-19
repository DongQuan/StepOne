####Spring-MyBatis配置

1. xml文件：

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		       xmlns:context="http://www.springframework.org/schema/context"
		       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
		
		    <!-- 自动扫描 -->
		    <context:component-scan base-package="com.blacktiger.graduate_websit" />
		    <!-- 引入配置文件 -->
		    <bean id="propertyConfigurer"
		          class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		        <property name="location" value="classpath:/properties/jdbc.properties" />
		    </bean>
		
		    <!--阿里巴巴的连接池-->
		    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="close">
		        <!--database地址，账号，密码，-->
		        <property name="url" value="${url}"/>
		        <property name="username" value="${username}"/>
		        <property name="password" value="${password}"/>
		        <!--开启sql监控-->
		        <property name="filters" value="stat"/>
		        <!--连接池数量配置-->
		        <property name="initialSize" value="1"/>
		        <property name="minIdle" value="1"/>
		        <property name="maxActive" value="20"/>
		        <!--获取连接等待超时时间-->
		        <property name="maxWait" value="60000"/>
		        <!--配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒-->
		        <property name="timeBetweenEvictionRunsMillis" value="60000"/>
		        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		        <property name="minEvictableIdleTimeMillis" value="300000"/>
		        <!--在连接空闲时检测连接是否有效,检测时机是（空闲，取得，返回）-->
		        <property name="validationQuery" value="SELECT 'x'"/>
		        <property name="testWhileIdle" value="true"/>
		        <property name="testOnBorrow" value="true"/>
		        <property name="testOnReturn" value="true"/>
		        <!--打开PSCache，并且指定每个连接上PSCache的大小-->
		        <!--sql里用"?"占位，等待被替换。例如"select * from table1 where user_name = ? and age > ?",替换后的结果将被缓存起来-->
		        <property name="poolPreparedStatements" value="true"/>
		        <property name="maxPoolPreparedStatementPerConnectionSize" value="60"/>
		    </bean>
		
		    <!-- spring和MyBatis完美整合，不需要mybatis的配置映射文件 -->
		    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		        <property name="dataSource" ref="dataSource" />
		        <!-- 自动扫描mapping.xml文件 -->
		        <!--Jxuan:classpath需要标记resources文件夹，然后再建立一个mapper文件夹把xml文件放进去，暂时没有找到更好的解决办法-->
		        <property name="mapperLocations" value="classpath:/mapper/*.xml"/>
		    </bean>
		
		
		    <!-- DAO接口所在包名，Spring会自动查找其下的类 -->
		    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		        <property name="basePackage" value="com.blacktiger.graduate_websit.dao" />
		        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
		    </bean>
		
		    <!-- (事务管理)transaction manager, use JtaTransactionManager for global tx -->
		    <bean id="transactionManager"
		          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		        <property name="dataSource" ref="dataSource" />
		    </bean>
		</beans>

2.properties文件：

        #使用本地数据库
        url=jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf8
        username=root
        password=root