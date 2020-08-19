package kr.co.fastcampus;

import jdk.jfr.DataAmount;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
    private int id;
    @NonNull private String username;
    @NonNull private String password;

    public Member(ResultSet resultSet) {
        try{
            this.id = resultSet.getInt("id");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
