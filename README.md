# springboot-shiro

#### 项目介绍
Springboot + shiro权限管理。这或许是流程最详细、代码最干净、配置最简单的shiro上手项目了。

#### 开发环境

| 工具    | 版本或描述                  |    
| ----- |------------------------|    
| OS    | Windows 10             |    
| JDK   | 1.8+                   |    
| IDE   | IntelliJ IDEA 2023.1.1 |    
| Maven | 3.3.1                  |    
| MySQL | 5.7.4                  |    

#### 模块划分

| 模块         | 释义                      |    
| ---------- | ----------------------- |    
| shiro-core  | 核心业务类模块，提供基本的数据操作、工具处理等 |    
| shiro-admin | 后台管理模块                  |    

#### SQL Model

![sql model](https://gitee.com/yadong.zhang/shiro/raw/master/docs/img/sql-model.png?v=1.0)

#### 使用说明

1. 使用IDE导入本项目
2. 新建数据库`CREATE DATABASE shiro;`
3. 导入数据库`docs/db/shiro.sql`
4. 修改(`resources/application.yml`)配置文件
   1. 数据库链接属性(可搜索`datasource`或定位到L.19) 
   2. redis配置(可搜索`redis`或定位到L.69)
5. 运行项目(三种方式)
   1. 项目根目录下执行`mvn -X clean package -Dmaven.test.skip=true`编译打包，然后执行`java -jar shiro-admin/target/shiro-admin.jar`
   2. 项目根目录下执行`mvn springboot:run`
   3. 直接运行`ShiroAdminApplication.java`
6. 浏览器访问`http://127.0.0.1:8080`

**用户密码**

_超级管理员_： 账号：root  密码：123456 

_普通管理员_： 账号：admin  密码：123456

**Druid监控**

_链接_： `http://127.0.0.1:8080/druid/index.html`

用户名：zyd-druid  密码：zyd-druid


#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

#### 参考资料

1. 本项目部分代码参考自网络文章。[查看原文链接](http://blog.csdn.net/poorcoder_/article/details/71374002)    
2. 前端模板来源自开源模板。[查看模板链接](https://colorlib.com/polygon/gentelella/index.html)，[查看开源项目](https://github.com/puikinsh/gentelella)    
3. 部分js实现参考自本人开源项目。[查看开源项目](https://gitee.com/yadong.zhang/DBlog)    
4. 感谢[SpringBoot](https://github.com/spring-projects/spring-boot)和[Mybatis](https://github.com/mybatis/mybatis-3)等优秀开源项目。


