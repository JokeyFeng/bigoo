package com.jokey.bigoo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author JokeyFeng
 * date:2019/4/25
 * project:bigoo
 * package:com.jokey.bigoo.admin
 * comment:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jokey.bigoo.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
