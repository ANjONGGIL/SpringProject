package kr.co.fastcampus.cli;

import org.springframework.context.annotation.*;

import java.sql.Connection;

@Configuration
@Profile("dev")
public class AppDevConfig {



    @Bean(initMethod = "init",destroyMethod = "destroy")
    public ConnectionFactory connectionFactory() {
        return new ConnectionFactory("org.h2.Driver", "jdbc:h2:file:test", "sa", "");
    }
}
