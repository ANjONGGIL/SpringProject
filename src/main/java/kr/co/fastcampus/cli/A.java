package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@Slf4j
public class A {

    @Autowired
    @Qualifier("b1")
    private B b;

    @Value("${catalog.name}")
    String catalogName;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    void init(){
        log.info(""+context);
    }
}
