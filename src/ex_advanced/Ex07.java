package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex07 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                create table tests(id integer primary key,name text);

                    insert into tests(id, name)
                    values(1, 'watanabe');
                        """;

        try (
                Connection con = DriverManager.getConnection(url, user, passward);
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.executeUpdate();
            // int numOfUpdate = pstmt.executeUpdate();
            // System.out.println(numOfUpdate);

        } catch (SQLException ex) {
            ex.getSQLState();
        }
    }
}
