package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex02 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                begin;
                    insert into colors
                    (id, name)
                    values
                    (1, 'blue'),
                    (2, 'red'),
                    (3, 'green'),
                    (4, 'yellow'),
                    (5, 'purple'),
                    (6, 'orange');

                    insert into
                    members(
                        name,
                        birth_day,
                        gender,
                        color_id
                    )
                    values(
                        '大野智', '1980-11-26', '男', 1
                    ),
                    (
                        '櫻井翔', '1982-01-25', '男', 2
                    ),
                    (
                        '相葉雅紀', '1982-12-24', '男', 3
                    ),
                    (
                        '二宮和也', '1983-06-17', '男', 4
                    ),
                    (
                        '松本潤', '1983-08-30', '男', 5
                    );
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
