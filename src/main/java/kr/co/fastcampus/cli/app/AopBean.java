package kr.co.fastcampus.cli.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AopBean {

    public void log(){
        log.error("aop log");
    }
    public void beforeLog(){
        log.error("before");
    }
    public void afterLog(){
        log.error("after");
    }
    public void afterReturningLog(){
        log.error("afterReturn");
    }
    public void afterThrowingLog(){
        log.error("afterThrowing");
    }

}
