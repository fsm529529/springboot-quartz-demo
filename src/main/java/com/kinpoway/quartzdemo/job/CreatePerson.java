package com.kinpoway.quartzdemo.job;
import com.kinpoway.quartzdemo.entity.Person;
import com.kinpoway.quartzdemo.service.MytestServiceImpl;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePerson implements Job {

    @Autowired
    MytestServiceImpl mytestService;

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String name = dataMap.getString("name");
        Person person = new Person();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        person.setName(name + " " + dateStr);
        person.setSex(0);
        person.setAge(18);
        System.out.println("==============="+new Date()+"===============name=>"+name);
        System.out.println("####################"+mytestService.getName());
      //  personMapper.insert(person);
    }
}
