package ex_member_management;

import java.time.LocalDate;

public class Beginner5 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();

        Member member = dao.load(1);
        member.setName("渡邉健");
        member.setBirthDay(LocalDate.parse("1997-08-22"));
        member.setGender("男");
        member.setColorId(6);

        dao.update(member);
    }
}
