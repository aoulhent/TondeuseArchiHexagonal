package com.arena.batch;

import com.arena.model.Lawn;
import com.arena.model.Mower;
import com.arena.model.Orientation;
import com.arena.model.Position;
import com.arena.port.MowerCommandExecutorPort;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
@EnableBatchProcessing
@EnableTransactionManagement
public class MowerJobConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Job mowerJob(Step step1, JobRepository jobRepository) {
        return new JobBuilder("mowerJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(ItemReader<MowerCommand> reader,
                      ItemProcessor<MowerCommand, Mower> processor,
                      ItemWriter<Mower> writer,JobRepository jobRepository) {
        return new StepBuilder("step1",jobRepository)
                .<MowerCommand, Mower>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(transactionManager(dataSource()))
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<MowerCommand> reader() {
        return new ItemReader<MowerCommand>() {
            private BufferedReader reader;

            @Override
            public MowerCommand read() throws Exception {
                if (reader == null) {
                    // Initialize the reader for the input file
                    reader = new BufferedReader(new InputStreamReader(new ClassPathResource("input.txt").getInputStream()));
                    reader.readLine(); // Skip the first line containing the lawn dimensions => 5 5
                }

                // Read position and orientation line (e.g., "1 2 N")
                String positionLine = reader.readLine();
                if (positionLine == null) {
                    return null;
                }

                String[] positionParts = positionLine.split(" ");
                int x = Integer.parseInt(positionParts[0]);
                int y = Integer.parseInt(positionParts[1]);
                String orientation = positionParts[2];

                // Read the command line (e.g., "GAGAGAGAA")
                String commandLine = reader.readLine();
                if (commandLine == null) {
                    throw new IllegalStateException("Ligne command vide");
                }

                // Create a MowerCommand object with the read data
                return new MowerCommand(x, y, orientation, commandLine);
            }
        };
    }

    @Bean
    public ItemProcessor<MowerCommand, Mower> processor(MowerCommandExecutorPort mowerCommandExecutor) {
        return mowerCommand -> {
            // Assume fixed lawn size
            Lawn lawn = new Lawn(5, 5);
            Mower mower = new Mower(
                    new Position(mowerCommand.getX(), mowerCommand.getY()),
                    Orientation.valueOf(mowerCommand.getOrientation())
            );

            mowerCommandExecutor.executeCommands(lawn, mower, mowerCommand.getCommands());

            return mower;
        };
    }



    @Bean
    public ItemWriter<Mower> writer() {
        return items -> items.forEach(mower ->
                System.out.println(mower.getPosition().getX() + " " + mower.getPosition().getY() + " " + mower.getOrientation())
        );
    }
}

