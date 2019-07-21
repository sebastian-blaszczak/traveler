package travel.app.traveler.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {

    public void connect(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://ec2-174-129-227-146.compute-1.amazonaws.com:5432/d44l55q96g9ime?user=vrlrqkofgvkbpw&password=7d50e6e458925469ef401ad9cec529660e0e6cfce8ad3badfb1c5e588d034783&sslmode=require");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
