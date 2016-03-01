####MySql笔记

1. sql语句排序：SELECT 字段列表 FROM 表名 WHERE 条件  ORDER BY 字段名1 [ASC|DESC][,字段名2 [ASC|DESC]...]; DESC表示按照降序排列，ASC表示按照升序排列。


2. 插入语句：

		<insert id="insert" parameterType="me.test.Department" >
	   	    insert into department (id, name, create_time) values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})
	   	</insert>
   	
   	