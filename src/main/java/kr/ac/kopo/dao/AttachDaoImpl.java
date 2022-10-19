package kr.ac.kopo.dao;

import kr.ac.kopo.model.Attach;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AttachDaoImpl implements AttachDao{
    @Autowired
    SqlSession sql;

    @Override
    public void add(Attach attach) {
        sql.insert("attach.add", attach);
    }

    @Override
    public void deleteById(int id) {
        sql.delete("attach.deleteById", id);
    }
}
