####MyBatis笔记
1.resultmap写法：

	<resultMap id="BaseResultMap" type="me.test.entity.Article">
        <id column="id" property="id" jdbcType="VARCHAR"/>
        <result column="title" property="title" jdbcType="VARCHAR"/>
        <result column="creat_time" property="creatTime" jdbcType="TIMESTAMP"/>
        <result column="click_num" property="clickNum" jdbcType="INTEGER"/>
        <result column="publish_department" property="publishDepartment" jdbcType="VARCHAR"/>
        <result column="user_id" property="userId" jdbcType="VARCHAR"/>
        <result column="content" property="content" jdbcType="VARCHAR"/>
        <result column="img_path" property="imgPath" jdbcType="VARCHAR"/>
        <result column="type" property="type" jdbcType="VARCHAR"/>
        <result column="valid" property="valid" jdbcType="BIT"/>
        <result column="is_pass" property="isPass" jdbcType="BIT"/>
        <result column="is_delete" property="isDelete" jdbcType="BIT"/>
    </resultMap>
      
2.geneator反向生成：

        generatorConfig.xml:
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE generatorConfiguration
                PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
                "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
        <generatorConfiguration>
            <!-- 数据库驱动-->
            <classPathEntry  location="mysql-connector-java-5.1.36.jar"/>
            <context id="DB2Tables"  targetRuntime="MyBatis3">
                <commentGenerator>
                    <property name="suppressDate" value="true"/>
                    <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
                    <property name="suppressAllComments" value="true"/>
                </commentGenerator>
                <!--数据库链接URL，用户名、密码 -->
                <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1:3306/graduate_test" userId="root" password="root">
                </jdbcConnection>
                <javaTypeResolver>
                    <property name="forceBigDecimals" value="false"/>
                </javaTypeResolver>
                <!-- 生成模型的包名和位置-->
                <javaModelGenerator targetPackage="com.blacktiger.graduate_websit.entity" targetProject="src/main/java">
                    <property name="enableSubPackages" value="true"/>
                    <property name="trimStrings" value="true"/>
                </javaModelGenerator>
                <!-- 生成映射文件的包名和位置-->
                <sqlMapGenerator targetPackage="com.blacktiger.graduate_websit.mapper.mapper" targetProject="src/main/java">
                    <property name="enableSubPackages" value="true"/>
                </sqlMapGenerator>
                <!-- 生成DAO的包名和位置-->
                <javaClientGenerator type="XMLMAPPER" targetPackage="com.blacktiger.graduate_websit.dao" targetProject="src/main/java">
                    <property name="enableSubPackages" value="true"/>
                </javaClientGenerator>
                <!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名-->
                <table tableName="jurisdiction" domainObjectName="Jurisdiction" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"/>
            </context>
        </generatorConfiguration>
        
        脚本命令：java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
        
        同时该目录下需要添加：mybatis-generator-core-1.3.2.jar mysql-connector-java-5.1.36.jar

        
        