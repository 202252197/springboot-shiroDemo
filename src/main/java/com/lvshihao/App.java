package com.lvshihao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @author: lvshihao
 * @Date: $ $
 * @Description:
 */

@SpringBootApplication
@MapperScan("com.lvshihao.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
