# 使用GitLab+Docker+Jenkins实现项目自动化部署

项目地址
git@gitlab.com:growing-bald/gitlab-docker-jenkins.git

[TOC]

## 背景

### 软件开发生命周期

> 软件开发生命周期又叫**SDLC**(Software Development Life Cycle)，它是集成了计划、开发、测试和部署过程的集合

需求分析 -》 设计 -》实现 -》 测试 -》 进化

### 软件的敏捷开发

> 敏捷开发的核心是**迭代开发**和**增量开发**

#### 迭代开发

​	迭代开发将开发过程拆分为多个小周期，即一次"大开发"变成多次"小开发"，每次小开发都是同样的流程，所以看上去好像重复在做同样的步骤。

#### 增量开发

​	软件的每个版本，都会新增一个用户可以感知的完善功能。也就是说，按照新增功能来划分迭代。

#### 敏捷开发的好处

+ 早期交付：持续交付可以减少资金压力
+ 降低风险：及时了解市场需求

### 什么是持续集成

> 持续集成（ Continuous integeration , 简称CI ）指的是：频繁地（一天多次）将代码集成到主干

#### 持续集成的目的

​	可以让产品**快速迭代**，同时**保持高质量**。它的核心措施是，将代码集成到主干之前，必须通过自动化测试。只要有一个测试用例失败。就不能集成。

#### 持续集成的好处

​	通过持续集成，团队可以快速的从一个功能到另一个功能。

​	简而言之，敏捷开发很大一部分要归功于持续集成。

#### 持续集成流程

![1599100157201](images/敏捷开发流程.png)

提交  -》 测试（第一轮） -》 构建 -》 测试（第二轮，可不测） -》 部署 -》 回滚（发生问题）

#### 持续集成的组成要素

+ 持续集成服务器
+ 代码存储仓库，可用于版本控制
+ 一个自动构建过程，自动化完成检出代码、编译构建、运行测试、结果记录、测试统计

## Jenkins

​	Jenkins是一款流行的开源持续集成工具，广泛用于项目开发，具有自动化构建、测试和部署等功能。

### Jenkins持续集成流程

![images](images/jenkins%E6%B5%81%E7%A8%8B.png)

1. 开发人员提交代码到版本控制仓库
2. Jenkins作为持续集成工具，拉取代码到集成服务器，再配合JDK、Maven等软件完成代码编译、代码测试和审查、测试、打包等工作
3. 代码编译成功后，Jenkins把生成的jar或war包分发到测试服务器或生产服务器，测试人员或用户就可以访问使用

### Jenkins持续集成环境配置

#### Jenkins登录密码

```txt
admin
HengTian0.0
```

#### Maven安装路径

```sh
/usr/local/apache-maven-3.5.4 #maven_home
/usr/local/maven/repo	#maven仓库
```
#### 基本配置

1. 插件安装

   配置jenkins数据源：系统管理-》插件管理-》升级站点

   ```bash
   https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json 
   ```

   

   ![1599441279039](images/配置数据源.png)

2. 安装maven相关插件、git相关插件、pipline插件、gitlab相关插件、ssh相关插件、public over ssh插件（使用ssh进行远程上传）、Generic Webhook Trigger （webhook触发器）

3. 系统管理-》全局工具配置

   + ![1599215126960](images/maven_全局工具配置.png)
   + ![1599215525304](images/jdk配置_全局工具配置.png)
   + ![1599215586432](images/git配置_全局工具配置.png)
   + ![1599215646237](images/增加maven_全局工具配置.png)

4. 系统管理-》系统配置

   + ![1599215859722](images/Jenkins路径.png)

   + ![1599216049006](images/gitlab配置.png)

   + ![1599216285706](images/public_over_ssh.png)

   + ![1599216697532](images/服务器SSH.png)
     服务器SSH生成的文件有：id_rsa,id_rsa.pub
     前提：Jenkins所在服务器linuxA、应用服务器LinuxB

     目的：解决从Jenkins所在的服务器A向服务器B传输文件

     第一步：

     服务器A，生成一个密钥对

     命令：ssh-keygen -t rsa

     [root@test .ssh]$ ssh-keygen -t rsa 

     第二步：

     服务器B，在/root/.ssh路径下建立authorized_keys文件

     将服务器A生成的id_rsa.pub（公钥）内容复制到authorized_keys文件下(注意，是文件，不文件夹）

     重启服务器B的SSH，命令：service sshd restart

5. 凭证管理

   ![1599440722504](images/凭证配置.png)

   ![1599440945849](images/全局凭据.png)

   

   + 配置gitlab上的access token（用于系统配置中的gitlab配置）
     ![1599217265733](images/gitlab_token_1.png)
     ![1599217425205](D:\A\MyJustProject\gitlab-docker-jenkins\images\gitlab_token_2.png)

   + 配置git的ssh凭证（服务器上生成的用于服务器的git拉取gitlab上的代码）

     ```bash
     # 在服务器执行
     git config --global  user.name "这里换上你的用户名"
     git config --global user.email "这里换上你的邮箱"
     ssh ssh-keygen -t rsa -C "这里换上你的邮箱"
     ```

     由于之前已经生成public over ssh使用的ssh，所以要在生成ssh的时候更换目录，此时就需要在/root/.ssh目录下编译一个config文件，让拉取代码时能找到相关的ssh公钥和密钥

     ![1599440488720](images/ssh_config.png)

     ![1599440571626](images/ssh_config_detail.png)

     ![1599440641864](images/ssh_config_result.png)

#### 构造一个maven单项目的持续集成

1. 构建一个maven项目：新建任务-》构建一个maven项目

   ![1599441686297](images/new_task.png)

2. 配置源码管理

   ![1599441838626](images/源码管理.png)

3. 构建触发器

   ![1599442244495](images/构建触发器.png)

   构建触发器前提是要配置好gitlab上的webhook（先保存再出来）

   首先生成jenkins的api-token

   ![1599442487567](images/jenkins_aip_token.png)

   路径：用户列表-》admin-》设置

   ![1599442649638](images/jenkins_api_token_2.png)

   添加好token后，复制token名称和密钥

   ![1599442341795](images/gitlab_webhook.png)

   ![1599442965850](images/配置gitlab_webhook.png)

   添加参数

   ![1599443146691](images/triger_ref.png)

   ![1599443190600](images/triger_project.png)

   ![1599443224897](images/triger_username.png)

   ![1599443263980](images/triger_token.png)

   ![1599443303713](images/triger_config.png)

4. build配置，这里可以在Goals and options中填写maven命令如：clean install，不写也行

   ![1599443359532](images/bulid.png)

5. 构建后操作配置

   ![1599443466581](images/构建后操作.png)

   depoly.sh内容

   ```bash
   #!/bin/bash
   source /etc/profile	#!!!这一句很重要
   echo "----------------"
   if [ $(ps -ef |grep gitlab-docker-jenkins*|wc -l) -gt 1 ];then
           kill -9 $(ps -ef |grep gitlab-docker-jenkins* |awk '{print $2}' |sed -n '1p'|tr -s '\n' ' ')
           echo "kill $ID done"
   fi
   echo "----------------"
   
   nohup  java -jar /usr/local/generate/gitlab-docker-jenkins*.jar --spring.profiles.active=dev --logging.level.root=debug >runninglog 2>&1 &
   echo "success"
   exit
   
   ```

#### jenkins -- Generic Webhook Trigger插件

```txt
JenkinsHook
11b8f797685d1a118a838cbd78f3dab044
http://JENKINS_URL/generic-webhook-trigger/invoke.
refs/heads/master_[a-zA-Z0-9-]{1,}(?!yh)
$ref_$project_$username
```

