package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.sql.Connection;

@Configuration
public class AppConfig {

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
}
