package kr.co.fastcampus.web.dao;

import kr.co.fastcampus.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    void init(){
        jdbcTemplate.update("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
    }

    @Autowired
    public MemberDao(JdbcTemplate dataSource){
        this.jdbcTemplate = dataSource;
    }

    @Transactional
    public void insert(String username, String password){
//        var statement = dataSource.getConnection().createStatement();
//        statement.executeUpdate("insert into member(username,password)values(`jonggil`,`112341`)");
        jdbcTemplate.update("insert into member(username,password)values(?,?)",username,password);
    }
    public List<Member> list()  {
//        var statement = jdbcTemplate.getConnection().createStatement();
//        var resultSet = statement.executeQuery("select id, username, password from member");
//        while (resultSet.next()){
//            var member = new Member(resultSet);
//            log.info(member.toString());
//        }
       return jdbcTemplate.query("select id, username, password from member",
                (RowMapper<Member>) (resultSet, i) -> {
                    return new Member(resultSet);
                });
    }
}
