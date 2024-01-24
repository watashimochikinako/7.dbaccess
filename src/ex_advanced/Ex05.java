package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex05 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                begin;
                    delete from
                    members
                    where name in ('渡邉健', '櫻井翔');
                    commit;
                        """;

        try (
                Connection con = DriverManager.getConnection(url, user, passward);
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを操作しました");
        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            ex.printStackTrace();
        }
    }
}
