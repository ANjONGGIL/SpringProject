package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String diverClass;
    public String url;
    public String user;
    public String password;

    public ConnectionFactory(String driverClass,String url, String user, String password) {
        this.diverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(this.diverClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(this.url,this.user,this.password);
    }
}
