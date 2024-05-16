package cn.itcast.fegin.clients;


import cn.itcast.fegin.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//单独的一个feign接口，用来调用user服务的接口
@FeignClient("uservices")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
