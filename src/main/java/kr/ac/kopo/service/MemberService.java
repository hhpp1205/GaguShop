package kr.ac.kopo.service;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface MemberService {
    boolean login(Member member);

    void signup(Member member);

    boolean checkId(String id);

    boolean findPwd(Member member);

    void newPwd(Member member);

    List<Member> findId(Member member);

    int findIdCheck(Member member);

    int findPwdCheck(Member member);

    List<Gagu> adminGagu(Pager pager);

}
