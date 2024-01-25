package dao;

public class InsertExample {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();

        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("テスト太郎");
        employee.setAge(22);
        employee.setGender("男");
        employee.setDepartmentid(2);

        dao.insert(employee);
    }
}
