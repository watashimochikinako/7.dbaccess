package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private final static String URL = "jdbc:postgresql://localhost:5432/student";
    private final static String USER_NAME = "postgres";
    private final static String PASWARD = "postgres";

    public static Connection createConnection(){
        try {
            Connection con = DriverManager.getConnection(URL, USER_NAME, PASWARD);
            return con;

        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("DBの接続に失敗しました", ex);
        }
    }

    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("DBの接続に失敗しました", ex);
        }
    }
}
