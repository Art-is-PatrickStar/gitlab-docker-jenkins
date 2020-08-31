package online.hengtian;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 *
 * @lastModified
 * @history
 * @Description: 使用@SpringBootApplication标注主程序，表示这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //启用SpringBoot应用
        SpringApplication.run(MainApplication.class,args);//传入主程序类的Class对象
    }
}

