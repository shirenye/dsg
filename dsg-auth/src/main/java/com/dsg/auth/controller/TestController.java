//package com.dsg.auth.controller;
//
//import com.dsg.common.redis.service.RedisService;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @author cdw
// * @date 2021/9/3 1:26
// */
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/r/")
//public class TestController {
//
//    @Autowired
//    private RedisService redisService;
//
//    @GetMapping("test")
//    @ResponseBody
////    @PreAuthorize("hasAuthority('test:Geta')")
//    public String Test() {
//        redisService.set("test", "test");
//        return (String) redisService.get("test");
//    }
//}
