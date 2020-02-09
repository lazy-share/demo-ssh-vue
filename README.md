# Getting Started

### 后台项目架构
- sprinboot
- hibernate(springdata)
- mysql
- logback
- junit

### 前端项目架构
- vue
- axios
- vuex
- element ui
- router
- vue-router
- webpack

### 操作系统安装好以下环境
- jdk1.8
- maven3.x
- nodejs10.x.x
- npm6.9.x
- mysql5.6.x
- git

### 从github上克隆项目

git clone https://github.com/lazy-share/demo-ssh-vue.git

### 创建mysql数据库

create database demo_ssh_vue;

或者通过类型navicat客户端创建

### 初始化sql脚本
sql脚本放置在: demo-ssh-vue/server-ssh/doc/sql.sql

### maven构建后台springboot项目
- 通过IDEA或eclipse导入demo-ssh-vue/server-ssh后端springboot项目
- 执行maven package进行依赖下载和打包

###  启动后台应用
直接运行DemoSshVueApplication主方法即可!



### 构建vue前端项目
- cmd命令行进入到demo-ssh-vue/web-vue项目
- 安装淘宝加速镜像cnpm: npm install -g cnpm --registry=https://registry.npm.taobao.org
- 安装依赖：cnpm install 
- 启动： npm start

### 访问地址：
http://localhost:8080

### 测试账号信息
lazy 123456
