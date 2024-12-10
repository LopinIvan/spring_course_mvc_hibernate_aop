package com.lopinivan.spring.mvc_hibernate_aop.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class FlywayConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("WEB-INF/db/migration")
                .baselineOnMigrate(true)
                .validateOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }
}
