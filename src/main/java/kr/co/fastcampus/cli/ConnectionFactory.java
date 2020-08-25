package kr.co.fastcampus.cli;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionFactory implements DisposableBean {
    private String diverClass;
    public String url;
    public String user;
    public String password;
    private Connection connection=null;

    public ConnectionFactory(String driverClass,String url, String user, String password) {
        this.diverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public ConnectionFactory(String driverClass, String url, String user,String password,Connection connection) {
        this.diverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
        this.connection = connection;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(this.diverClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(this.url,this.user,this.password);
    }



    public void init() throws Exception {
        this.connection = createConnection();
    }

    @Override
    public void destroy() throws Exception {
        if (this.connection != null){
            this.connection.close();
        }
    }
}
