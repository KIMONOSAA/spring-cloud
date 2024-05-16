package cn.itcast.order.service;

import cn.itcast.fegin.clients.UserClient;
import cn.itcast.fegin.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;
    public Order  queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.利用FeignClient，发送请求，查询用户
        User user = userClient.findById(order.getUserId());
        // 2.1.拼接url路径
        order.setUser(user);
        // 4.返回
        return order;
    }
//    public Order  queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate，发送请求，查询用户
//        // 2.1.拼接url路径
//        String url = "http://uservices/user/" + order.getUserId();
//        //2.2.发送请求
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }

}
