package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;

@Configuration
@Profile("default")
@PropertySource("classpath:application.properties")
public class AppDefaultConfig {


    @Bean(initMethod = "init",destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(){
        return new ConnectionFactory("org.h2.Driver","jdbc:h2:mem:test","sa","");
    }

}
