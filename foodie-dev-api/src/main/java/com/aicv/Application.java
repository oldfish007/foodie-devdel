/**
 *
 */
package com.aicv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author oldfish
 * @date 2020-11-21 17:05
 * @version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.aicv.mapper")//扫描mybatis通用mapper所在的包
@EnableTransactionManagement  //开启事务 这里可加可不加
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
