package com.abdts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author pzy
 */
@SpringBootApplication
public class AuthSpring extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthSpring.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthSpring.class, args);
    }

}
