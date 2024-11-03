package com.kinpoway.quartzdemo.cotroller;

import com.kinpoway.quartzdemo.job.CreatePerson;
import org.quartz.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Resource
    private Scheduler scheduler;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start(@RequestParam("name") String name,@RequestParam("cronStr")String cronStr) throws Exception {
        String jobName = "createPerson";
        String jobGroup = "createJobGroup";
        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = JobBuilder.newJob(CreatePerson.class).withIdentity(jobKey).build();
        //表达式调度构造器
      //  String checkOutCron = "0/5 * * * * ? ";
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronStr)
                .withMisfireHandlingInstructionDoNothing();//不对Misfire进行处理
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
                .withSchedule(cronScheduleBuilder).build();
        //放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put("name", name);
        //判断是否存在
        if (scheduler.checkExists(new JobKey(jobName, jobGroup))) {
            //防止创建时存在数据问题，先移除，然后再执行创建操作
            scheduler.deleteJob(new JobKey(jobName, jobGroup));
        }
        scheduler.scheduleJob(jobDetail, trigger);
        return "人员创建定时任务开始";
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public String stop(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) throws Exception {
        scheduler.pauseJob(new JobKey(jobName, jobGroup));
        return "人员创建定时任务停止";
    }

}
