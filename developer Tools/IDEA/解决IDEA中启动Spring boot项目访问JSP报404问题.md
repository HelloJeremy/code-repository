### 将Spring Boot项目(Maven项目管理)导入到IDEA中以Spring Boot工程启动，项目可以启动成功而JSP访问404，而在Eclipse中启动没有问题的解决方案

- **解决方案1** ：以Spring Boot项目启动，加上mvn spring-boot:run启动指令
![enter image description here](https://github.com/HelloJeremy/code-repository/blob/master/images/developer%20tools/IDEA/add_spring_boot_run.png?raw=true)

- **解决方案2** ：以maven启动
![enter image description here](https://github.com/HelloJeremy/code-repository/blob/master/images/developer%20tools/IDEA/run_as_maven_project.png?raw=true)

- **解决方案3**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope><!--由JDK或者容器提供-->
</dependency>
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>
```

把上面两个依赖的<scope>provided<scope> 注释掉，对于这种作用范围idea编译启动后找不到被指定为provided这种jar包，如果第一个依赖的<scope>provided<scope> 未去掉，会报ClassNotFound错误，第二个依赖的<scope>provided<scope> 未去掉则访问时会报404错误。

>ps:如果项目中没有添加spring-boot-starter-tomcat依赖，可以只将tomcat-embed-jasper的<scope>provided<scope> 注释掉。如果项目中有其他的类报错：ClassNotFound，只要将相对应的依赖的<scope>provided<scope> 注释掉即可。

```xml
<dependency>
	<groupId>jstl</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
	<!--<scope>provided</scope>-->
</dependency>
```

另外需要配置工作目录，如下图
![enter image description here](https://github.com/HelloJeremy/code-repository/blob/master/images/developer%20tools/IDEA/run_as_springbootPj_addWorkDir.png?raw=true)




## 参考博客
[Spring Boot+JSP启动报404错误找不到页面](https://blog.csdn.net/ab7253957/article/details/78022860)





