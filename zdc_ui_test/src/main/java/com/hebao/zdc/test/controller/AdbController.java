package com.hebao.zdc.test.controller;

import com.hebao.zdc.test.sevice.AdbService;
import com.hebao.zdc.test.utils.ReaderFileUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;

/*
 * @ClassName AdbController
 * @Description TODO
 * @Author XiaoAn
 * @Date 2021/1/21
 * @Version 1.0
 */
@Log4j2
@RestController
@RequestMapping("zdc")
public class AdbController {

    @Autowired
    private AdbService adbService;

    private ReaderFileUtil readerFileUtil = new ReaderFileUtil();

    @GetMapping("adb")
    public String adb(){
        String str;
        try {
            BufferedReader bufferedReader = readerFileUtil.getReaderFile();
            while ((str = bufferedReader.readLine()) != null){
                String[] split = str.split(",");
                int length = split.length;
                //判断长度必须为偶数，否则参数错误
                if ((length%2) != 0){
                    return "参数错误！";
                }else if (length == 4){
                    //判断长度为4的是滑动操作
                    adbService.adbSwipe(split[0],split[1],split[2],split[3],"1000");
                }else {
                    //其余长度为点击操作
                    adbService.adbTap(split[0],split[1]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("adb工具执行失败原因：{}",e.toString());
        }
        return "success！";
    }
}
