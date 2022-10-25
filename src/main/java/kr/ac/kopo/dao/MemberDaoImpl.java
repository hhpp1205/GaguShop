package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.pager.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao{
    @Autowired
    SqlSession sql;

    @Override
    public Member login(Member member) {
        return sql.selectOne("member.login", member);
    }

    @Override
    public List<Gagu> beforeLoginList() {
        return sql.selectList("gagu.beforeLoginList");
    }

    @Override
    public void signup(Member member) {
        sql.insert("member.signup", member);
    }

    @Override
    public int checkId(String id) {
        return sql.selectOne("member.checkId", id);
    }

    @Override
    public int findPwd(Member member) {
        return sql.selectOne("member.findPwd", member);
    }

    @Override
    public void newPwd(Member member) {
        sql.update("member.newPwd", member);
    }

    @Override
    public List<Member> findId(Member member) {
        return sql.selectList("member.findId", member);
    }

    @Override
    public List<Gagu> afterLoginList(String memberId) {
        return sql.selectList("gagu.afterLoginList", memberId);
    }

    @Override
    public int findIdCheck(Member member) {
        return sql.selectOne("member.findIdCheck", member);
    }

    @Override
    public int findPwdCheck(Member member) {
        return sql.selectOne("member.findPwdCheck", member);
    }

    @Override
    public List<Gagu> adminGagu(Pager pager) {
        return sql.selectList("gagu.adminGagu", pager);
    }




}
