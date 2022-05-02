package pc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 引导类 Spring boot 项目入口
 */
/*  @MapperScan扫描mapper接口所在的包*/
@MapperScan("pc.disease.mapper")
@SpringBootApplication
@EnableScheduling //开启对定时任务的支持
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
