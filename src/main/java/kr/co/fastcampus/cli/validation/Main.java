package kr.co.fastcampus.cli.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Person person = new Person("",200);
        PersonValidation validation = new PersonValidation();
        if(validation.supports(person.getClass())){
            BindException error = new BindException(person,"person");
            validation.validate(person, error);
            log.error(">>"+error.hasErrors());
        }else{
            log.error("invalid class");
        }
    }
}
