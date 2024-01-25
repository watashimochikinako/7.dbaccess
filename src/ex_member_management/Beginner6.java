package ex_member_management;

public class Beginner6 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        dao.deleteById(1);
        dao.deleteById(2);
    }
}
