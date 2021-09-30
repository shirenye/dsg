package com.dsg.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 网关启动类
 * @author cdw
 * @date 2021/9/19 17:03
 */

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DsgGateWayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DsgGateWayApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ dsg网关启动成功  └(^o^)┘└(^o^)┘");
    }
}
