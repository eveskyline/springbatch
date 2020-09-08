package com.springbatch.config;

import com.springbatch.listener.JobCompletionListener;
import com.springbatch.step.Processor;
import com.springbatch.step.Reader;
import com.springbatch.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author raogs
 * @version 1.0
 * @date 2020/9/7 17:46
 */
@Configuration
public class BatchConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())// 监听
                .flow(orderStep1()).end().build(); // 创建步骤1
    }

    // 步骤1 bean 先读再写
    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
                .reader(new Reader()).processor(new Processor())    // 读取。处理
                .writer(new Writer()).build();  // 最后写
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener(); // 创建监听
    }
}
