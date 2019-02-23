package com.service;

import com.database.ReviewEntity;
import com.database.ScoreAnalystEntity;
import com.repository.AnalystRepository;
import com.repository.CustomersRepository;
import com.repository.FilmRepository;
import com.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;

@Service
public class AnalystService {
    private final AnalystRepository analystRepository;
    private final ReviewRepository reviewRepository;
    private final FilmRepository filmRepository;
    private final CustomersRepository customersRepository;

    @Autowired
    public AnalystService(AnalystRepository analystRepository, ReviewRepository reviewRepository, FilmRepository filmRepository, CustomersRepository customersRepository) {
        this.analystRepository = analystRepository;
        this.reviewRepository = reviewRepository;
        this.filmRepository = filmRepository;
        this.customersRepository = customersRepository;
    }

    public TreeMap<String, String> allReviewsByAnalystId(int id) {
        TreeMap<String, String> filmRev = new TreeMap<String, String>();
        LinkedList<ReviewEntity> revs = reviewRepository.reviewsForOneAnalyst(id);
        for (ReviewEntity e : revs) {
            filmRev.put(filmRepository.findById(e.getIdFilm()).getName(), e.getBody());
        }

        return filmRev;
    }

    public String[] analystInfo(int id) {

        String[] info = new String[3];

        info[0] = (customersRepository.findById(id).getName());
        info[1] = (analystRepository.findByIdt(1).getAboutMe());
        info[2] = String.valueOf((customersRepository.findById(id).getImg()));

        return info;
    }

    public double analystScore(int id) {
        Collection<ScoreAnalystEntity> anScore = analystRepository.findByIdt(1).getScoreAnalysts();
        Float sum = 1f;

        for (ScoreAnalystEntity e : anScore) sum += e.getScore();

        return Math.round(sum / anScore.size() * 100.0) / 100.0;
    }

    public void addNewReview(int idAnalyst, int idFilm, String body) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setIdAnalyst(idAnalyst);
        reviewEntity.setIdFilm(idFilm);
        reviewEntity.setBody(body);
        reviewRepository.save(reviewEntity);

    }

    //TODO : удалить ревью
public void deleteReview(long id ){
        reviewRepository.deleteById(id);
}

}
