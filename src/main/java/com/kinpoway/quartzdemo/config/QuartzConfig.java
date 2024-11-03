package com.kinpoway.quartzdemo.config;

import org.quartz.spi.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class QuartzConfig {
//
////    @Resource
////    private JobFactory jobFactory;
////
////    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setDataSource(dataSource);
//
//        //quartz参数
//        Properties prop = new Properties();
//        prop.put("org.quartz.scheduler.instanceName", "BusinessScheduler");
//        prop.put("org.quartz.scheduler.instanceId", "AUTO");
//        //线程池配置
//        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        prop.put("org.quartz.threadPool.threadCount", "20");
//        prop.put("org.quartz.threadPool.threadPriority", "5");
//        //JobStore配置
//        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//        //触发器超时临界值
//        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
//        //数据库表前缀
//        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
//        factory.setQuartzProperties(prop);
//
//        factory.setSchedulerName("BusinessScheduler");
//        //延时启动
//        factory.setStartupDelay(1);
//        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
//        //可选，QuartzScheduler
//        //启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
//        factory.setOverwriteExistingJobs(true);
//        //设置自动启动，默认为true
//        factory.setAutoStartup(true);
//        //设置自定义JobFactory，使得Spring能够管理Job的bean
//        factory.setJobFactory(jobFactory);
//
//        return factory;
//    }

}