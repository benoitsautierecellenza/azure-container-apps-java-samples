package org.springframework.batch.samples.petclinic;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
public class PetClinicOwnersExportBatchJobConfiguration {

    @Bean
    public JdbcCursorItemReader<Owner> ownersReader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Owner>()
            .name("ownersReader")
            .sql("SELECT * FROM OWNERS")
            .dataSource(dataSource)
            .rowMapper(new DataClassRowMapper<>(Owner.class))
            .build();
    }

    @Bean
    public FlatFileItemWriter<Owner> ownersWriter() {
        return new FlatFileItemWriterBuilder<Owner>()
            .name("ownersWriter")
            .resource(new FileSystemResource("owners.csv"))
            .delimited()
            .names("id", "firstname", "lastname", "address", "city", "telephone")
            .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager,
                   JdbcCursorItemReader<Owner> ownersReader, FlatFileItemWriter<Owner> ownersWriter) {
        return new JobBuilder("ownersExportJob", jobRepository)
            .start(new StepBuilder("ownersExportStep", jobRepository).<Owner, Owner>chunk(5, transactionManager)
                .reader(ownersReader)
                .writer(ownersWriter)
                .build())
            .build();
    }

}
