package kr.ac.kopo.dao;

import kr.ac.kopo.model.Attach;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AttachDaoImpl implements AttachDao{

    private final SqlSession sql;

    @Override
    public void add(Attach attach) {
        sql.insert("attach.add", attach);
    }

    @Override
    public void deleteAttachByGaguId(int id) {
        sql.delete("attach.deleteAttachByGaguId", id);
    }
}
