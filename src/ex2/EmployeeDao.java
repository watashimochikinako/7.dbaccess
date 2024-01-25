package ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    public Employee load(int id) {
        Connection con = DBManager.createConnection();
        String sql = """
            select
            e.id as e_id,
            e.name as e_name,
            e.age as e_age,
            e.gender as e_gender,
            e.department_id as e_department_id,
            d.id as d_id,
            d.name as d_name
        from employees e
        right join departments d
        on e.department_id = d.id
        where e.id = ?;
                    """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();

                employee.setId(rs.getInt("e.id"));
                employee.setName(rs.getString("e.name"));
                employee.setAge(rs.getInt("e.age"));
                employee.setGender(rs.getString("e.gender"));
                employee.setDepartmentId(rs.getInt("e.department_id"));
                employee.setId(rs.getInt("d.id"));
                employee.setName(rs.getString("d.name"));
                return employee;
            }
            return null;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("load処理に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }
}
