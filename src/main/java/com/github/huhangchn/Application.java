package com.github.huhangchn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import static com.github.huhangchn.core.ProjectConstant.MAPPER_PACKAGE;

@MapperScan(basePackages = MAPPER_PACKAGE)
@SpringBootApplication
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

