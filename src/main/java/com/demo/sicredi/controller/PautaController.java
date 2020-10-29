package com.demo.sicredi.controller;

import com.demo.sicredi.DTO.PautaDTO;
import com.demo.sicredi.SicrediApplication;
import com.demo.sicredi.domain.Pauta;
import com.demo.sicredi.service.PautaService;
import com.demo.sicredi.util.Util;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maiquelknechtel on 25/10/20.
 */
@RestController
@RequestMapping("/api/pauta")
public class PautaController {
    @Autowired
    private PautaService pautaService;
    @Autowired
    private Scheduler scheduler;
    int idPautaJob=0;

    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpEntity<?> save(@RequestBody PautaDTO pautaDTO) {
        pautaService.save(pautaDTO.build(pautaDTO));
        return ResponseEntity.ok().build();

    }

    @RequestMapping(value = "/iniciaVotacao", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpEntity<?> iniciaVotacao(@RequestBody PautaDTO pautaDTO) throws SchedulerException{
        Pauta pauta = pautaService.findById(pautaDTO.getId());
        pauta.setPossibleToVote(true);
        Util.getListPauta().add(pauta);
        idPautaJob = pauta.getId();
        JobDetail job = newJob("id"+idPautaJob, "Pauta"+idPautaJob);
        scheduler.scheduleJob(job, trigger(job)).toString();

        return ResponseEntity.ok().build();

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

    @RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Pauta> getPauta(){
        return pautaService.findAll();
    }

}
