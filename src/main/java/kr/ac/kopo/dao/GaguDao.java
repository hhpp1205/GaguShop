package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface GaguDao {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);

    List<String> keywordList();

    List<Gagu> search(String keyword, Pager pager, int changeSort);

    int total(Pager pager, String keyword);

    int searchCount(String keyword);

    int setAdminTotal(Pager pager);

    void init(Member member);

    List<Gagu> list();
}
