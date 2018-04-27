package com.abdts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author pzy
 */
@SpringBootApplication
public class SpringSearch extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringSearch.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSearch.class, args);
    }

}
