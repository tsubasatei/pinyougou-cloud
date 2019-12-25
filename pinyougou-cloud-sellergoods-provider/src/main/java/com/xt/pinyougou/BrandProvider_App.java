package com.xt.pinyougou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient  // 该注解在采用eureka作为注册中心时使用，场景较为单一
//@EnableDiscoveryClient //场景更为广泛
@MapperScan(basePackages = {"com.xt.pinyougou.mapper"})
@SpringBootApplication
@EnableSwagger2
public class BrandProvider_App {

    public static void main(String[] args) {
        SpringApplication.run(BrandProvider_App.class, args);
    }
}
