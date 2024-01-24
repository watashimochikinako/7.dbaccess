package ex_advanced;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex03 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                select
                m.name,
                m.birth_day,
                m.gender,
                c.name as color_name
                from members m
                join colors c
                on c.id = m.color_id
                order by c.id;
                """;

        try (
                Connection con = DriverManager.getConnection(url, user, passward);
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                String name = rs.getString("name");
                Date birth_day = rs.getDate("birth_day");
                String gender = rs.getString("gender");
                String color_name = rs.getString("color_name");

                System.out.print("name = " + name);
                System.out.print(" birth_day = " + birth_day);
                System.out.print(" gender = " + gender);
                System.out.print(" color_name = " + color_name);
                System.out.println();
            }

        } catch (SQLException ex) {
            System.err.println("SQL関連のエラー");
            System.err.println("SQL=" + sql);
            ex.printStackTrace();
        }
    }
}
