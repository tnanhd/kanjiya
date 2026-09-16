package com.tnanhd.boot;

import com.tnanhd.application.common.ApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tnanhd")
@EntityScan(basePackages = "com.tnanhd.infrastructure.data")
@EnableJpaRepositories(basePackages = "com.tnanhd.infrastructure.data")
@ComponentScan(
    basePackages = "com.tnanhd",
    includeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ApplicationService.class))
@EnableFeignClients(basePackages = "com.tnanhd.infrastructure.data.kanji.remote")
public class BootApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootApplication.class, args);
  }
}
