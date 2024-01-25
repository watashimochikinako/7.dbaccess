package dao;

public class LoadExercise {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();
        Department department = dao.load(1000);
        System.out.println("id = " + department.getId());
        System.out.println("name = " + department.getName());
    }
}
