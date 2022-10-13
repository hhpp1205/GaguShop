package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao dao;

    @Override
    public boolean login(Member member) {

        if(dao.login(member) != null){
            member.setPwd(null);
            return true;
        }else
            return false;
    }

    @Override
    public List<Gagu> beforeLoginList() {
        return dao.beforeLoginList();
    }


    @Override
    public void signup(Member member) {
        dao.signup(member);
    }

    @Override
    public boolean checkId(String id) {
        if(dao.checkId(id) == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean findPwd(Member member) {
        if(dao.findPwd(member) == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void newPwd(Member member) {
        dao.newPwd(member);
    }

    @Override
    public Member findId(Member member) {
        return dao.findId(member);
    }


    @Override
    public List<Gagu> afterLoginList(String memberId) {
        return dao.afterLoginList(memberId);
    }


}
