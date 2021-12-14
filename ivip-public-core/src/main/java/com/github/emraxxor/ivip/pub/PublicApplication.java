package com.github.emraxxor.ivip.pub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.github.emraxxor.ivip")
@EnableJpaRepositories
@EntityScan
@Slf4j
public class PublicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicApplication.class,args);
    }
}
