package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Dao2 {

    private Connection connection;

    public Dao2(Connection connection){
        this.connection = connection;
    }
    public void run() throws ClassNotFoundException, SQLException {
        log.info("Hello World!");
        var statement = connection.createStatement();

        connection.setAutoCommit(false);
        statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        try {
                statement.executeUpdate("insert into member(username, password) values('Anjonggil', '1234')");
                connection.commit();
        } catch (SQLException e) {
                connection.rollback();
        }

        var resultSet = statement.executeQuery("select id, username, password from member");
        while (resultSet.next()) {
               var member = new Member("Anjonggil","1234");

               log.info(member.toString());
        }

    }
}
