package ex_member_management;

import java.time.LocalDate;

public class Beginner1 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();

        Member member1 = new Member();
        member1.setName("大野　智");
        member1.setBirthDay(LocalDate.parse("1980-11-26"));
        member1.setGender("男");
        member1.setColorId(1);
        dao.insert(member1);

        Member member2 = new Member();
        member2.setName("櫻井　翔");
        member2.setBirthDay(LocalDate.parse("1982-01-25"));
        member2.setGender("男");
        member2.setColorId(2);
        dao.insert(member2);

        Member member3 = new Member();
        member3.setName("相葉　雅紀");
        member3.setBirthDay(LocalDate.parse("1982-12-24"));
        member3.setGender("男");
        member3.setColorId(3);
        dao.insert(member3);

        Member member4 = new Member();
        member4.setName("二宮　和也");
        member4.setBirthDay(LocalDate.parse("1983-06-17"));
        member4.setGender("男");
        member4.setColorId(4);
        dao.insert(member4);

        Member member5 = new Member();
        member5.setName("松本　潤");
        member5.setBirthDay(LocalDate.parse("1983-08-30"));
        member5.setGender("男");
        member5.setColorId(5);
        dao.insert(member5);
        
    }
}
