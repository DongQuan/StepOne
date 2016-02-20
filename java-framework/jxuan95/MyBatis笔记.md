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