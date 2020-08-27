package kr.co.fastcampus.cli;


import kr.co.fastcampus.cli.config.AppConfig;
import kr.co.fastcampus.cli.controller.MemberController;
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
import java.util.Scanner;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        createTable(context.getBean(DataSource.class).getConnection());

        System.out.println("=================================");

        Scanner scanner = new Scanner(System.in);
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();

        MemberController controller = context.getBean(MemberController.class);
        controller.insert(username,password);
        controller.print();
        context.close();

}

    private static void createTable(Connection connection) throws SQLException {
        connection.createStatement().execute("create table member(id int auto_increment,username varchar(255) not null, password varchar(255) not null,)");
    }
    }
