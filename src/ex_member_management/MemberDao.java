package ex_member_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    // loadメソッド
    public Member load(int id) {
        Connection con = DBManager.createConnection();

        String sql = """
                select
                id,
                name,
                birth_day,
                gender,
                color_id
                from members
                where id = ?
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirthDay(rs.getDate("birth_day").toLocalDate());
                member.setGender(rs.getString("gender"));
                member.setColorId(rs.getInt("color_id"));
                return member;
            }
            return null;
        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("load処理に失敗しました", ex);
        } finally {
            DBManager.closeConnection(con);
        }
    }

    // findByNameメソッド
    public List<Member> findByName(String name) {
        Connection con = DBManager.createConnection();
        String sql = """
                select id, name, birth_day, gender, color_id
                from members
                where name like ?;
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            List<Member> memberList = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirthDay(rs.getDate("birth_day").toLocalDate());
                member.setGender(rs.getString("gender"));
                member.setColorId(rs.getInt("color_id"));
                memberList.add(member);
            }
            return memberList;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("検索結果に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }

    // findAllメソッド
    public List<Member> findAll() {
        Connection con = DBManager.createConnection();
        String sql = """
                select * from members
                order by birth_day asc;
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Member> memberList = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirthDay(rs.getDate("birth_day").toLocalDate());
                member.setGender(rs.getString("gender"));
                member.setColorId(rs.getInt("color_id"));
                memberList.add(member);
            }
            return memberList;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("検索結果に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }

    // insertメソッド
    public int insert(Member member) {
        Connection con = DBManager.createConnection();

        String sql = """
                insert into members
                (name, birth_day, gender, color_id)
                values
                (?, ?, ?, ?);
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(member.getBirthDay()));
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());

            int affected = pstmt.executeUpdate();
            return affected;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("insert処理に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }

    // updateメソッド
    public int update(Member member) {
        Connection con = DBManager.createConnection();
        String sql = """
                update members
                set
                name = ?,
                birth_day = ?,
                gender = ?,
                color_id = ?
                where id = ?;
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(member.getBirthDay()));
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());
            pstmt.setInt(5, member.getId());

            int affected = pstmt.executeUpdate();
            return affected;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("insert処理に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }

    // deleteメソッド
    public int deleteById(int id) {
        Connection con = DBManager.createConnection();
        String sql = """
                delete from members
                where id = ?;
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            int affected = pstmt.executeUpdate();
            return affected;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("delete処理に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }
}
