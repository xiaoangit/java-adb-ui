package com.hebao.zdc.test;

import com.hebao.zdc.test.controller.AdbController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/*
 * @ClassName ZdcUiApplicationStart
 * @Description TODO
 * @Author XiaoAn
 * @Date 2021/1/21
 * @Version 1.0
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class ZdcUiApplicationStart {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ZdcUiApplicationStart.class, args);
//        System.out.println("==================="+run.getBean("getReaderFile"));
    }
}
