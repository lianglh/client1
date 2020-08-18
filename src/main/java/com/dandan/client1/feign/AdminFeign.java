package com.dandan.client1.feign;


import com.dandan.client1.common.ResultObject;
import com.dandan.client1.entity.Admin;
import com.dandan.client1.feign.hystrix.AdminFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(value = "client2",fallback = AdminFeignHystrix.class)
public interface AdminFeign {
    String API="${service.prefix}/adminApi";
    @PostMapping( value =API+ "/addAdmin" )
    public ResultObject addAdmin(Admin admin);
}
