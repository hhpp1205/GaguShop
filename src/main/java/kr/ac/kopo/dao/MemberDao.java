package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;

import java.util.List;

public interface MemberDao {

    Member login(Member member);

    List<Gagu> beforeLoginList();

    void signup(Member member);

    int checkId(String id);

    int findPwd(Member member);

    void newPwd(Member member);

    Member findId(Member member);

    List<Gagu> afterLoginList(String memberId);

    int findIdCheck(Member member);

    int findPwdCheck(Member member);
}
