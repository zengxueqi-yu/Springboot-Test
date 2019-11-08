# Springboot-Test
用spring boot开发的测试项目
# 概述

- 主要用于实际开发中需要用到的项目demo功能

- 做了一些改造，增加了一些功能和一些代码的重构

- 关于项目，对于开发的练手项目，能够工程化，严谨一些。

- 关于文档，本文主要中从项目需求，项目设计的方式来阐述.

- **如何从零开始**，使用springboot开发项目。

- 记录一些在开发过程中遇到的一些问题，总结开发技巧


## 功能需求
### 集成插件信息
#### Redis
- 首次集成Redis信息，解压Redis程序包，进入redis目录，命令：redis-server启动

- 开发Redis简单使用工具RedisToolUtils

#### Nacos
- 集成Nacos平台，用户系统集中配置系统参数信息，进去Nacos的bin目录，输入命令：sudo sh startup.sh -m standalone 启动本地nacos

- 用于实现服务的注册与发现，为后续微服务开发做准备

- 项目启动访问http://localhost:8848/nacos，默认用户名：nacos，默认密码：nacos

# 为后续待开发，请耐心等待。。。