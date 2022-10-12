package kr.ac.kopo.service;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;

import java.util.List;

public interface MemberService {
    boolean login(Member member);

    List<Gagu> beforeLoginList();

    void signup(Member member);

    boolean checkId(String id);

    boolean findPwd(Member member);

    void newPwd(Member member);

    Member findId(Member member);

    List<Gagu> search(String keyword);

    List<Gagu> afterLoginList(String memberId);
}
