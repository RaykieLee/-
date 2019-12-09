##笔记
### Mybatis Generator插件 
### 涉及技术及框架         

|技术 | 说明 | 官网 |
|:-: | :-: | :-: | :-: | 
|SpringBoot | 容器+MVC框架 |  [spring.io](https://spring.io/projects/spring-boot)|
|MyBatis	|ORM框架	|[mybstis.org](http://www.mybatis.org/mybatis-3/zh/index.html)
|MyBatisGenerator|	数据层代码生成|[mybstis.org](http://www.mybatis.org/generator/index.html]|
|PageHelper	MyBatis|物理分页插件|[oschina.net](	http://git.oschina.net/free/Mybatis_PageHelper)
|Swagger-UI|	文档生产工具|	[swagger-api](https://github.com/swagger-api/swagger-ui)|
|Redis|	分布式缓存|	[redis.io](https://redis.io/)|
####   生成代码
- 引入 MyBatis Generator 依赖
````
<dependency>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-core</artifactId>
	<version>1.3.7</version>
	<scope>provided</scope>
</dependency>
````
- 引入 MyBatis Generator Maven 插件
````
			<plugin>
				<groupId>org.mybatis.generator</groupId>
				<artifactId>mybatis-generator-maven-plugin</artifactId>
				<version>1.3.7</version>

				<configuration>
					<configurationFile>src/main/resources/mybatis-generator.xml</configurationFile>
					<overwrite>true</overwrite>
				</configuration>

				<dependencies>
					<dependency>
						<groupId>mysql</groupId>
						<artifactId>mysql-connector-java</artifactId>
						<version>8.0.12</version>
					</dependency>
				</dependencies>
			</plugin>
````
- 准备 MyBatis Generator 配置文件
MyBatis Generator 需要一个 xml格式的配置文件，该文件的位置配在了引入 MyBatis Generator Maven 插件的 xml配置里，即src/main/resources/mybatis-generator.xml
````
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>

    <context id="MySql" defaultModelType="flat">

        <plugin type="org.mybatis.generator.plugins.SerializablePlugin" />

        <jdbcConnection
                driverClass="com.mysql.cj.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&amp;useSSL=false&amp;allowPublicKeyRetrieval=true&amp;nullCatalogMeansCurrent=true"
                userId="root"
                password="密码" />

        <javaModelGenerator targetPackage="com.example.mall.entity" targetProject="src/main/java"></javaModelGenerator>

        <sqlMapGenerator targetPackage="mapper"  targetProject="src/main/resources"></sqlMapGenerator>

        <javaClientGenerator targetPackage="com.example.mall.mapper" targetProject="src/main/java" type="ANNOTATEDMAPPER"></javaClientGenerator>

        <table tableName="user">
            <property name="modelOnly" value="false"/>
        </table>

    </context>

</generatorConfiguration>
````
- 直接生成简单crud 
```xml
        <table tableName="user" enableCountByExample="false" enableUpdateByExample="false">
            <property name="modelOnly" value="false"/>
        </table>
```

- connectionUrl中含有&符号问题
在&字符后添加 amp; 即改为 '&amp;'即可。
- < jdbcConnection /> 数据库连接配置，至关重要
- <javaModelGenerator /> 指定自动生成的 POJO置于哪个包下
- <sqlMapGenerator /> 指定自动生成的 mapper.xml置于哪个包下
- <javaClientGenerator /> 指定自动生成的 DAO接口置于哪个包下
- <table /> 指定数据表名，可以使用_和%通配符


#### 
## git
### git 更新出现stderr: error: bad signature fatal: index file corrupt
因为git在更新操作的时候会更新.git文件夹下的index文件，方便下一次更新的时候会找到更新的节点，而现在电脑突然崩溃，这个文件可能只更新了一部分，甚至直接导致这个文件破坏，所以再次更新的时候，发现这个index文件信息不全或者文件无法读取，这样就会出现上面的提示
>   到.git平行目录下依次执行以下命令  
$ rm -f .git/index     删除文件index，也可以手动删除    
$ git reset       这个是git命名可以恢复指定的版本号，这里没有就默认恢复上一次正确的文件  
重启即可    
然后发现自己本地的代码都丢完了。。。。。        
>      
