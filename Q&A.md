### 项目部署到服务器后，启动之后访问长时间没反应

在JVM环境中解决：

打开$JAVA_PATH/jre/lib/security/java.security这个文件，找到下面的内容：

```bash
securerandom.source=file:/dev/random
```

替换成

```bash
securerandom.source=file:/dev/./urandom
```

