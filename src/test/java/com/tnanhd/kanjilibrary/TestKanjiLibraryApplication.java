package com.tnanhd.kanjilibrary;

import org.springframework.boot.SpringApplication;

public class TestKanjiLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.from(KanjiLibraryApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
