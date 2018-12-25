//package com.idea.cms.Scheduled;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
///**
// *
// * 定时任务测试
// */
//@Service
//public class ScheduledTasks {
//    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
//    private static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedDelay=2)
//    public void phoneWorktask() {
//        logger.info("定时任务开始时间", dataFromat.format(new Date()));
//        for (int i = 0; i < 100; i++) {
//            logger.info("第一个线程--"+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        logger.info("定时任务结束时间", dataFromat.format(new Date()));
//    }
//    @Scheduled(fixedDelay=2)
//    public void phoneWorktask1() {
//        logger.info("定时任务开始时间", dataFromat.format(new Date()));
//        for (int i = 0; i < 100; i++) {
//            logger.info("第二个线程----"+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        logger.info("定时任务结束时间", dataFromat.format(new Date()));
//    }
//    @Scheduled(fixedRate=2)
//    public void phoneWorktask2() {
//        logger.info("定时任务开始时间", dataFromat.format(new Date()));
//        for (int i = 0; i < 100; i++) {
//            logger.info("第四个线程---->>>"+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        logger.info("定时任务结束时间", dataFromat.format(new Date()));
//    }
//    @Scheduled(cron = "0 * * * * ?")
//    public void phoneWorktask3() {
//        logger.info("定时任务开始时间", dataFromat.format(new Date()));
//        for (int i = 0; i < 100; i++) {
//            logger.info("第三个线程                  ------"+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        logger.info("定时任务结束时间", dataFromat.format(new Date()));
//    }
//}
//
