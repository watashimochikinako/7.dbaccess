package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex04 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, passward);

            sql = """
                    update
                    members
                    set
                    id = 1,
                        name = '渡邉健',
                        birth_day = '1997-08-22',
                        color_id = 6
                    where id = 1;
                    """;

            pstmt = con.prepareStatement(sql);

            int numOfUpdate = pstmt.executeUpdate();

            System.out.println(numOfUpdate + "件のデータを操作しました。");

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
