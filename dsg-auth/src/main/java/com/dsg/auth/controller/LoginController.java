package com.dsg.auth.controller;

//import lombok.RequiredArgsConstructor;
import com.dsg.common.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cdw
 * @date 2021/9/4 14:52
 */

@RestController
public class LoginController {

    @Autowired
    private RedisService redisService;

    @PreAuthorize("hasAuthority('user:view')")
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        redisService.set("asfsaf","时发生大事发生法发");

        return (String) redisService.get("asfsaf");
    }

    @PostMapping("/l")
    @ResponseBody
    public String loginSuccess() {

        return "loginSuccess";
    }
    @GetMapping("/login")
    @ResponseBody
    public String login() {

        return "login";
    }

    @PostMapping("/loginFail")
    @ResponseBody
    public String loginFail() {

        return "loginFail";
    }
}
