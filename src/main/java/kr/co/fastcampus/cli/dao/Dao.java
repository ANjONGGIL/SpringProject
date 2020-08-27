package kr.co.fastcampus.cli.dao;

import kr.co.fastcampus.cli.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
public class Dao {

    private DataSource dataSource;

    @Autowired
    public Dao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Transactional
    public void insert()throws SQLException{
        var statement = dataSource.getConnection().createStatement();
        statement.executeUpdate("insert into member(username,password)values(`jonggil`,`112341`)");
    }
    public void print() throws SQLException {
        var statement = dataSource.getConnection().createStatement();
        var resultSet = statement.executeQuery("select id, username, password from member");
        while (resultSet.next()){
            var member = new Member(resultSet);
            log.info(member.toString());
        }
    }
}
