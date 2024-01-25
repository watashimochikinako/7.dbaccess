package ex_member_management;

import java.util.List;

public class Beginner3 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        List<Member> memberList = dao.findByName("%和%");

        for (Member member : memberList) {
            System.out.println("id = " + member.getId());
            System.out.println("name = " + member.getName());
            System.out.println("birthDay = " + member.getBirthDay());
            System.err.println("gender = " + member.getGender());
            System.out.println("colorId = " + member.getColorId());
        }
    }
}
