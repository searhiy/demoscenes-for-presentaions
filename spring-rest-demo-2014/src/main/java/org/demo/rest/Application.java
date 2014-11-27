package org.demo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// TODO 1: Component scan, enable auto-configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    // TODO 1: main() method
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}
