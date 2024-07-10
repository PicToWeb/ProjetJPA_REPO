package com.imdb.jpa;

import com.imdb.jpa.services.file.ImportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;

@SpringBootConfiguration
public class WriteData implements CommandLineRunner {
    @Value("${initialisation.base}")
    private boolean initialisationBase;

    @Autowired
    private ImportFile importFile;
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WriteData.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception{

        if(!initialisationBase) {
            System.out.println("la base est déjà initialisée.");
            return;
        }
        importFile.run();
    }
}
