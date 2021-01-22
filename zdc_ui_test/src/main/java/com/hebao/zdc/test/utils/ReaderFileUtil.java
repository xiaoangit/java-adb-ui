package com.hebao.zdc.test.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * @ClassName ReaderFileUtils
 * @Description TODO  读取定位元素
 * @Author 86158
 * @Date 2020/11/11
 * @Version 1.0
 */
public class ReaderFileUtil {

    /* @Author: XiaoAn
     * @Description: 读取 data/android-driver.csv文件,获取操作元素
     * @Date: 2020/11/30
     */
    public BufferedReader getReaderFile(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/test/android-driver.csv"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }


}
