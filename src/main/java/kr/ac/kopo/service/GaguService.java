package kr.ac.kopo.service;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;

import java.util.HashMap;
import java.util.List;

public interface GaguService {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);


    void addDeleteCart(HashMap map);


    List<Gagu> cartList(String memberId);

    List<String> keywordList();

    List<Gagu> search(String keyword);
}
