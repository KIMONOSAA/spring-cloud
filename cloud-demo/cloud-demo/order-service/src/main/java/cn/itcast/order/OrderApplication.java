package cn.itcast.order;

import cn.itcast.fegin.clients.UserClient;
import cn.itcast.fegin.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//要扫描到UserClient这个类因为在当前他只是扫描了OrderApplication这个类所以要指定扫描包，或者对导入的包进行打包也是可以的
@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}