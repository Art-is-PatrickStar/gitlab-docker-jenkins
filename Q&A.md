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

### 如何编写gitignore并使之生效
1. 确保.gitignore文件与.git文件夹在同一目录下
2. 语法
    ```bash
    #         # 此为注释 – 将被 Git 忽略
    *.a       # 忽略所有 .a 结尾的文件
    !lib.a    # 但 lib.a 除外（排除）
    /TODO     # 仅仅忽略项目根目录下的 TODO 文件，不包括 subdir/TODO
    build/    # 忽略 build/ 目录下的所有文件
    doc/*.txt # 会忽略 doc/notes.txt 但不包括 doc/server/arch.txt
    ```
3. 配置生效
    ```bash
    git rm -r --cached .
    git add .
    git commit -m 'update .gitignore'
    ```