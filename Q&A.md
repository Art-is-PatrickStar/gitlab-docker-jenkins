### 启动jar包时出现找不到主类的错误

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <outputDirectory>
                    /usr/local/generate			
                </outputDirectory>
                <mainClass>com.wsw.wswserver.WswServerApplication</mainClass>
                <layout>JAR</layout>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

maven命令

```bash
clean package install
```

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