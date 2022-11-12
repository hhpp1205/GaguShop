package kr.ac.kopo.dao;

import kr.ac.kopo.model.Review;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDaoImpl implements ReviewDao{

    @Autowired
    SqlSession sql;

    @Override
    public void addReview(Review review) {
        sql.insert("review.add", review);
    }
}
