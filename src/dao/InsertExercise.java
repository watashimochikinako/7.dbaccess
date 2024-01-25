package dao;

public class InsertExercise {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();

        Department department = new Department();
        department.setId(1000);
        department.setName("システム情報部");

        dao.insert(department);
    }
}
