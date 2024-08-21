package com.javalent.curio;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CurioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurioApplication.class, args);
    }

    @Value("#{'${cors.origins}'.toLowerCase().split(',')}")
    private List<String> origins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins(
                        origins.toArray(new String[0]));
            }
        };
    }

}
