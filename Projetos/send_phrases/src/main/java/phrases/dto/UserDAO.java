package phrases.dto;

import phrases.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAO {

    private final String url;
    private final String user;
    private final String password;

    public UserDAO(Properties config){
        String host = config.getProperty("db.host");
        String dbName = config.getProperty("db.name");
        this.user = config.getProperty("db.user");
        this.password = config.getProperty("db.password");
        this.url = "jdbc:mysql://" + host + ":3306/" + dbName + "?useSSL=false&serverTimezone=UTC";
    }

    public void insertUser(User u) throws SQLException{

        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try(Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, u.getUserName());
                ps.setString(2, u.getUserEmail());

                ps.executeUpdate();

            }

    }

}
