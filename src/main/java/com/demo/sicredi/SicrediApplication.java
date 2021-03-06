package com.demo.sicredi;


import java.time.LocalDateTime;

import com.demo.sicredi.DAO.VotoDAO;
import com.demo.sicredi.domain.Pauta;
import com.demo.sicredi.util.Session;
import com.demo.sicredi.util.Util;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@EntityScan(basePackages = {"com.demo.sicredi.domain"})
public class SicrediApplication extends QuartzJobBean {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobLauncher jobLauncher;

	@Autowired
	public JobExplorer jobExplorer;

	@Autowired
	private VotoDAO votoDAO;

	@Bean
	public Trigger trigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(30)
				.repeatForever();
		
		return TriggerBuilder.newTrigger()
				.forJob(jobDetail())
				.withSchedule(scheduleBuilder)
				.build();
	}
	
	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob(SicrediApplication.class)
				.storeDurably()
				.build();
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobParameters parameters = new JobParametersBuilder(jobExplorer)
				.getNextJobParameters(job())
				.toJobParameters();
		
		try {
			
			this.jobLauncher.run(job(), parameters);
			
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Bean
	public Step step() {
		return this.stepBuilderFactory.get("step").tasklet(new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("The run time is: " + LocalDateTime.now());
				System.out.println("Espera 10 segundos.");
				Session.setPossivelVotar(true);
				Pauta p = Util.getListPauta().get(Util.getListPauta().size()-1);
				Thread.sleep(p.getSecond()*1000);

				p.setPossibleToVote(false);

				//votoDAO.findClosePauta(p.getId());
				Util.getListPauta().remove(p);
				System.out.println("Finalizado.");
				return RepeatStatus.FINISHED;
			}
		}).build();

	}

	@Bean
	public Job job() {
		return this.jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).start(step()).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SicrediApplication.class, args);
	}

}
