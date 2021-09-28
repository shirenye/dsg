package com.dsg.auth.controller;

//import lombok.RequiredArgsConstructor;
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
//@RequiredArgsConstructor
@RestController
public class LoginController {



    @PreAuthorize("hasAuthority('aaaa:bbbbb')")
    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "test";
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
