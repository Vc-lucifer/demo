package com.idea.cms.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/***
 * Quartz设置项目全局的定时任务
 */
@Component
public class QuartzDemo {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "0 0/1 * * * ?") // 每分钟执行一次
    public void work() throws Exception {
        System.out.println("执行调度任务： 每分钟执行一次"+ format.format(new Date()));
    }


    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void play() throws Exception {
        System.out.println("执行Quartz定时器任务：每五秒执行一次"+format.format(new Date()));
    }



    @Scheduled(cron = "0/2 * * * * ?") //每2秒执行一次
    public void doSomething() throws Exception {
        System.err.println("每2秒执行一个的定时任务："+format.format(new Date()));
    }




    @Scheduled(cron = "0 0 0/1 * * ? ") // 每一小时执行一次
    public void goWork() throws Exception {
        System.out.println("每一小时执行一次的定时任务："+format.format(new Date()));
    }




}