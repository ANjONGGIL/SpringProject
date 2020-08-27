package kr.co.fastcampus.cli;



import kr.co.fastcampus.cli.config.AppConfig;
import kr.co.fastcampus.cli.dao.Dao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(TransactionBean.class);

        createTable(context.getBean(DataSource.class).getConnection());

        Dao dao = context.getBean(Dao.class);
        try{
            dao.insert();
        }catch (Exception e) {
            dao.print();

            context.close();
        }


}

    private static void createTable(Connection connection) throws SQLException {
        connection.createStatement().execute("create table member(id int auto_increment,username varchar(255) not null, password varchar(255) not null,)");
    }
    }
