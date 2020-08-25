package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class A {

    private B b;


    @Autowired
    private ApplicationContext context;

    public A(B b) {
        this.b = b;
    }

    @PostConstruct
    void init(){
        log.info(""+context);
    }
}
