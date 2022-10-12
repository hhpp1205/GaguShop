package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;

import java.util.HashMap;
import java.util.List;

public interface GaguDao {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);

    List<String> keywordList();
}
