package com.hebao.zdc.test.sevice;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 * @ClassName AdbService
 * @Description TODO
 * @Author XiaoAn
 * @Date 2021/1/21
 * @Version 1.0
 */
@Log4j2
@Service
public class AdbService {

    /* @Author: XiaoAn
     * @Description: adb工具点击
     * @Date: 2021/1/21
     */
    public void adbTap(String tapX,String tapY){
        try {
            Runtime.getRuntime().exec("adb shell input tap "+tapX+" "+tapY);
            log.info("点击位置：{}，{}",tapX,tapY);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("adb点击执行失败原因：{}",e.toString());
        }
    }

    /* @Author: XiaoAn
     * @Description: adb工具滑动
     * @Date: 2021/1/21
     */
    public void adbSwipe(String x1,String y1,String x2,String y2,String time){
        try {
            Runtime.getRuntime().exec("adb shell input swipe "+x1+" "+y1+" "+x2+" "+y2+" "+time);
            log.info("滑动位置：{}，{}，{}，{}",x1,y1,x2,y2);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("adb滑动执行失败原因：{}",e.toString());
        }
    }
}
