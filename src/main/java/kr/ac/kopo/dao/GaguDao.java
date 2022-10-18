package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Pager;

import java.util.HashMap;
import java.util.List;

public interface GaguDao {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);

    List<String> keywordList();

    List<Gagu> search(String keyword, Pager pager);

    int total(Pager pager);
}
