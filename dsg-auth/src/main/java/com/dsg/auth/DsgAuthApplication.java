package com.dsg.auth;

//import org.mybatis.spring.annotation.MapperScan;

import com.dsg.common.security.annotation.EnableDsgResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 授权模块启动类
 * @author cdw
 * @date 2021/9/2 1:01
 */
@EnableRedisHttpSession
@MapperScan("com.dsg.manager.mapper")
@EnableDsgResourceServer
@SpringBootApplication(scanBasePackages={"com.dsg.*"})
public class  DsgAuthApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DsgAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ" );
    }
}
