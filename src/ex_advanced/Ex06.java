package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex06 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                begin;
                    drop table members;
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
