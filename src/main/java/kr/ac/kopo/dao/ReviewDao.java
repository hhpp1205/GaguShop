package kr.ac.kopo.dao;

import kr.ac.kopo.model.Review;

import java.util.List;

public interface ReviewDao {
    void addReview(Review review);

    List<Review> getReviewByGaguId(int id);

    void deleteReviewByGaguId(int id);

    void deleteReviewById(int id);

    void update(Review review);
}
