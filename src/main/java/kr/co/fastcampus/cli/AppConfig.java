package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class AppConfig {

    @Bean
    public B b(){
        return new B();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public A a(B b){
        return new A(b);
    }
    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }
    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }
}
