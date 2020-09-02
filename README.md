## 使用GitLab+Docker+Jenkins实现项目自动化部署

项目地址
git@gitlab.com:growing-bald/gitlab-docker-jenkins.git

教程
https://www.jianshu.com/p/ee4a2a9e7e30



### Jenkins

![images](https://gitlab.com/growing-bald/gitlab-docker-jenkins/-/raw/master/images/jenkins%E6%B5%81%E7%A8%8B.png)

#### 拉取Jenkins镜像

```bash
docker pull jenkinsci/jenkins
```

#### 运行Jenkins

```bash
docker run \
-d \
-p 38080:8080 \
-p 50000:50000 \
--name jenkins \
-u root \
-v /opt/jenkins:/var/jenkins_home \
jenkinsci/jenkins:latest
```
#### Jenkins登录密码

```txt
admin
HengTian0.0
```

#### Jenkins较新的数据源

```sh
https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json 
```

#### Maven安装路径

```sh
/usr/local/apache-maven-3.5.4 #maven_home
/usr/local/maven/repo	#maven仓库
```

