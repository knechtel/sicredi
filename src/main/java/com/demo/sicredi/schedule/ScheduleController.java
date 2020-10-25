package com.demo.sicredi.schedule;

import com.demo.sicredi.SicrediApplication;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maiquelknechtel on 24/10/20.
 */
@RestController
public class ScheduleController {

    @Autowired
    private Scheduler scheduler;
    int cont = 0;

    @GetMapping(value = "/schedule")
    public String scheduleJob() throws SchedulerException {
        cont++;
        JobDetail job = newJob("detail"+cont, "descrition");
        return scheduler.scheduleJob(job, trigger(job)).toString();
    }

    private JobDetail newJob(String identity, String description) {
        return JobBuilder.newJob().ofType(SicrediApplication.class).storeDurably()
                .withIdentity(JobKey.jobKey(identity))
                .withDescription(description)
                .build();
    }

    private SimpleTrigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .build();
    }
}