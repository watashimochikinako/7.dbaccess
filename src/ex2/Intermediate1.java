package ex2;

public class Intermediate1 {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.load(1);

        System.out.print("Employee [");
        System.err.print("id = " + employee.getId() + ", ");
        System.out.print("name = " + employee.getName() + ", ");
        System.out.print("age = " + employee.getAge() + ", ");
        System.out.print("gender = " + employee.getGender() + ", ");
        System.out.print("department_id = " + employee.getDepartmentId() + ", ");

        System.out.print("Department [");
        System.out.print("id = " + employee.getDepartment().getId() + ", ");
        System.out.print("name = " + employee.getDepartment().getName() + ", ");

    }
}
