## 使用GitLab+Docker+Jenkins实现项目自动化部署

项目地址
git@gitlab.com:growing-bald/gitlab-docker-jenkins.git

教程
https://www.jianshu.com/p/ee4a2a9e7e30



### Jenkins安装

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
60eb52f2ad544e859673366dc43404d4
```

