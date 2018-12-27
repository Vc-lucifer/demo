package com.idea.cms.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/***
 * Quartz设置项目全局的定时任务
 */
@Component
@EnableScheduling
public class ScheduledDemo {

    private Logger logger = LoggerFactory.getLogger(ScheduledDemo.class);

    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private int cronCount = 1;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "0/1 * * * * ?") // 每分钟执行一次
    public void work() throws Exception {
        System.out.println("执行调度任务： 每分钟执行一次" + format.format(new Date()));
        logger.info("===执行调度任务： 每分钟执行一次: 第{}次执行方法", fixedDelayCount++);
        logger.info(Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/2 * * * * ?") //每2秒执行一次
    public void doSomething() throws Exception {
        System.err.println("每2秒执行一个的定时任务：" + format.format(new Date()));
        logger.info("===每2秒执行一个的定时任务: 第{}次执行方法", initialDelayCount++);
        logger.info(Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/3 * * * * ?") //每2秒执行一次
    public void fuck() throws Exception {
        System.err.println("每2秒执行一个的定时任务：" + format.format(new Date()));
        logger.info("===每3秒执行一个的定时任务: 第{}次执行方法", initialDelayCount++);
        logger.info(Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/4 * * * * ?") //每2秒执行一次
    public void shit() throws Exception {
        System.err.println("每2秒执行一个的定时任务：" + format.format(new Date()));
        logger.info("===每4秒执行一个的定时任务: 第{}次执行方法", initialDelayCount++);
        logger.info(Thread.currentThread().getName());
    }

    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void play() throws Exception {
        System.out.println("执行Quartz定时器任务：每五秒执行一次" + format.format(new Date()));
        logger.info("===执行Quartz定时器任务：每五秒执行一次: 第{}次执行方法", fixedRateCount++);
        logger.info(Thread.currentThread().getName());
    }

    @Scheduled(cron = "0 0 0/1 * * ? ") // 每一小时执行一次
    public void goWork() throws Exception {
        System.out.println("每一小时执行一次的定时任务：" + format.format(new Date()));
        logger.info("===每一小时执行一次的定时任务: 第{}次执行方法", cronCount++);
        logger.info(Thread.currentThread().getName());
    }
}