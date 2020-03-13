package com.kingwsi.bs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
@MapperScan("com.kingwsi.bs.mapper")
public class BaseServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BaseServiceApplication.class, args);
    }

}