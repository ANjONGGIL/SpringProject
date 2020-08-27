package kr.co.fastcampus.cli.dao;

import kr.co.fastcampus.cli.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(JdbcTemplate dataSource){
        this.jdbcTemplate = dataSource;
    }

    @Transactional
    public void insert(String username, String password)throws SQLException{
//        var statement = dataSource.getConnection().createStatement();
//        statement.executeUpdate("insert into member(username,password)values(`jonggil`,`112341`)");
        jdbcTemplate.update("insert into member(username,password)values(?,?)",username,password);
    }
    public void print() throws SQLException {
//        var statement = jdbcTemplate.getConnection().createStatement();
//        var resultSet = statement.executeQuery("select id, username, password from member");
//        while (resultSet.next()){
//            var member = new Member(resultSet);
//            log.info(member.toString());
//        }
        List<Member> list = jdbcTemplate.query("select id, username, password from member",
                (RowMapper<Member>) (resultSet, i) -> {
                    return new Member(resultSet);
                });
    }
}
