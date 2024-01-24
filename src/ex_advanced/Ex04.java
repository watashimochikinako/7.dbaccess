package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex04 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                begin;
                        update members set
                        id = 6,
                        name = '渡邉健',
                        birth_day = '1997-08-22',
                        color_id = 6
                        where name = '大野智';
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
