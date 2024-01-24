package ex_advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String passward = "postgres";

        String sql = """
                    drop table if exists colors;
                    create table colors(
                        id integer primary key,
                        name text
                    );

                    drop table if exists members;
                    create table members(
                        id serial primary key,
                        name text not null,
                        birth_day date,
                        gender varchar(1),
                        color_id integer references colors(id)
                    );
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
