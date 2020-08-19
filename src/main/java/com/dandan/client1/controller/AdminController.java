package com.dandan.client1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("c")
public class AdminController {

    @Value("${server.port}")
    String port;
    @GetMapping("hello")
    public String hello(@RequestParam String name){

        return "hello "+name+" 我的服务端口是："+port;
    }


}
