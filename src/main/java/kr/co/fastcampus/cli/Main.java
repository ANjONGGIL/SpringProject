package kr.co.fastcampus.cli;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.sql.SQLException;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kr.co.fastcampus.cli");
        context.refresh();
        context.register(AppDevConfig.class,AppDefaultConfig.class,AppConfig.class);
        Dao dao = context.getBean(Dao.class);
        dao.run();
        context.close();
    }
}
