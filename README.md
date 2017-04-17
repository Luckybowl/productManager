# productManager  
  基于Spring Cloud架构的微服务应用，并且前后端分离。  
  完成【商品管理】管理模块  

## 技术方案
  - **前端**
    - React.js
    - [Bootstrap](http://v3.bootcss.com)
  - **服务器**
  	- Spring Boot
    - Spring Cloud Netflix
      - Eureka
      - Feign
      - Ribbon
## 目录结构
```text
./
├─configs								# 配置文件存放处
├─dbscripts                             # 数据库执行脚本
├─docs        							# 项目相关文档
└─src									# 项目源码
    ├─client                            # 客户端代码
    │  ├─css                           # css样式文件
    │  ├─images                        # 图片资源  
    │  └─js                            # js文件
    │      └─lib                       # js通用库文件
    └─server                            # 服务端代码
        ├─eureka-server                 # eureka注册服务器
        ├─product-api                   # RESTful接口服务
        └─product-service               # 数据库操作服务
```
## ChangeLog
### v2.0.0 (2017-04-16)
- 新增客户端商品增删改查页面
- 完成和服务端对接
### v1.0.1 (2017-04-15)
- 服务端框架雏形
### v1.0.0 (2017-04-14)
- 定义目录结构

## 感谢
- [Google](https://www.google.com)
- [百度](https://www.baidu.com)     
