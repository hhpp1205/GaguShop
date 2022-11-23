package kr.ac.kopo.dao;

import kr.ac.kopo.model.Review;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDaoImpl implements ReviewDao{


    private final SqlSession sql;

    @Override
    public void addReview(Review review) {
        sql.insert("review.add", review);
    }

    @Override
    public List<Review> getReviewByGaguId(int id) {
        return sql.selectList("review.list", id);
    }

    @Override
    public void deleteReviewByGaguId(int id) {
        sql.delete("review.deleteReviewByGaguId", id);
    }

    @Override
    public void deleteReviewById(int id) {
        sql.delete("review.deleteReviewById", id);
    }

    @Override
    public void update(Review review) {
        sql.update("review.update", review);
    }
}
