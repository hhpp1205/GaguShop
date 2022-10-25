package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.pager.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class GaguDaoImpl implements GaguDao{

    @Autowired
    SqlSession sql;

    @Override
    public void add(Gagu item) {
        sql.insert("gagu.add", item);
    }

    @Override
    public Gagu info(int id) {
        return  sql.selectOne("gagu.info", id);
    }

    @Override
    public void update(Gagu item) {
        sql.update("gagu.update", item);
    }

    @Override
    public void delete(int id) {
        sql.delete("gagu.delete", id);
    }

    @Override
    public List<String> keywordList() {
        return sql.selectList("gagu.keywordList");
    }

    @Override
    public List<Gagu> search(String keyword, Pager pager, int changeSort) {
        HashMap map = new HashMap<>();
        map.put("changeSort", changeSort);
        map.put("pager", pager);
        map.put("keyword", keyword);
        return sql.selectList("gagu.search", map);
    }

    @Override
    public int total(Pager pager, String keyword) {

        return sql.selectOne("gagu.total", keyword);
    }

    @Override
    public int searchCount(String keyword) {
        return sql.selectOne("gagu.searchCount", keyword);
    }

    @Override
    public int setAdminTotal(Pager pager) {
        return sql.selectOne("gagu.setAdminTotal", pager);
    }
}
