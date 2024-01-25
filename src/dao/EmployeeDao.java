package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    // private static final String TABLE_NAME = "employees";

    public Employee load(int id) {
        Connection con = DBManager.createConnection();

        String sql = """
                select id, name, age, gender, department_id
                from employees
                where id = ?
                """;
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender(rs.getString("gender"));
                employee.setDepartmentid(rs.getInt("department_id"));
                return employee;
            }
            return null;
        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("load処理に失敗しました", ex);
        } finally {
            DBManager.closeConnection(con);
        }
    }

    public List<Employee> findByDepartmentId(int departmentId) {
        Connection con = DBManager.createConnection();
        String sql = """
                select id, name, age, gender, department_id
                from employees
                where department_id = ?
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();

            List<Employee> employeeList = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setGender(rs.getString("gender"));
                employee.setDepartmentid(rs.getInt("department_id"));
                employeeList.add(employee);
            }
            return employeeList;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("検索結果に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }

    public int insert(Employee employee) {
        Connection con = DBManager.createConnection();
        String sql = """
                insert into
                employees(id, name, age, gender, department_id)
                values(?, ?, ?, ?, ?);
                """;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getAge());
            pstmt.setString(4, employee.getGender());
            pstmt.setInt(5, employee.getDepartmentid());

            int affected = pstmt.executeUpdate();
            return affected;

        } catch (SQLException ex) {
            System.err.println("SQL = " + sql);
            throw new RuntimeException("insert処理に失敗しました", ex);

        } finally {
            DBManager.closeConnection(con);
        }
    }
}
