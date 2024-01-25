package ex_member_management;

import java.util.List;

public class Beginner4 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        List<Member> memberList = dao.findAll();

        for (Member member : memberList) {
            System.out.println("id = " + member.getId());
            System.out.println("name = " + member.getName());
            System.out.println("birthDay = " + member.getBirthDay());
            System.out.println("gender = " + member.getGender());
            System.out.println("colorId = " + member.getColorId());
        }
    }
}
