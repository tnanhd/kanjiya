package com.tnanhd.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tnanhd")
public class KanjiyaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KanjiyaApplication.class, args);
  }
}
