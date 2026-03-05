package com.example.springbootissue;

import com.example.springbootissue.entity.EntityEntity;
import com.example.springbootissue.entity.EntityEntityRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootIssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIssueApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(EntityEntityRepository entityEntityRepository) {

        return args -> {

            var entityEntity = new EntityEntity();

            var parentEntity = new EntityEntity();

            entityEntityRepository.save(parentEntity);

            entityEntity.setParentEntity(parentEntity);

            entityEntityRepository.save(entityEntity);

            System.out.println();

        };
    }


}
