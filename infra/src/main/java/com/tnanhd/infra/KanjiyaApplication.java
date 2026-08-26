package com.tnanhd.infra;

import com.tnanhd.application.common.ApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = "com.tnanhd")
@ComponentScan(
    includeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ApplicationService.class))
public class KanjiyaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KanjiyaApplication.class, args);
  }
}
