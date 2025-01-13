package com.microsoft.sample;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("org.springframework.batch.samples.petclinic")
public class PetClinicOwnersExportBatchJobApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(PetClinicOwnersExportBatchJobApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jobLauncher.run(job, new JobParameters());

        System.out.println("Checking exported owners file:");
        System.out.println("------------------------------");
		Files.readAllLines(Paths.get("owners.csv")).forEach(System.out::println);
	}

}
