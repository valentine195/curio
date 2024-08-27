package com.javalent.curio;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.javalent.curio.models.Item;
import com.javalent.curio.repository.search.index.Indexer;

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

    @Bean
    public ApplicationRunner buildIndex(Indexer indexer) {
        return (ApplicationArguments args) -> {
            indexer.indexPersistedData(Item.class);
        };
    }

}
