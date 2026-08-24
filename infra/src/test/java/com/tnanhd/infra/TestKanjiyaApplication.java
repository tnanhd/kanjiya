package com.tnanhd.infra;

import org.springframework.boot.SpringApplication;

public class TestKanjiyaApplication {

    public static void main(String[] args) {
        SpringApplication.from(KanjiyaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
