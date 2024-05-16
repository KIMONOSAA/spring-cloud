package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
//@RefreshScope   #第一种方法nacos动态获取配置信息值
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")  //第一种方法配合nacos 的注解@RefreshScope动态获取配置信息值
//    private String dateformat;

    @Autowired
    private PatternProperties patternProperties;    //第二种方法注入配置类使用@ConfigurationProperties(prefix = "pattern")这个注解不需要使用@RefreshScope就能动态获取配置信息值



    @GetMapping("/prop")
    public PatternProperties properties(){
        return patternProperties;
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }



    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }
}
