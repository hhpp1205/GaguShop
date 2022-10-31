package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface MemberDao {

    Member login(Member member);

    void signup(Member member);

    int checkId(String id);

    int findPwd(Member member);

    void newPwd(Member member);

    List<Member> findId(Member member);


    int findIdCheck(Member member);

    int findPwdCheck(Member member);

    List<Gagu> adminGagu(Pager pager);


}
