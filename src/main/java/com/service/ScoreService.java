package com.service;

import com.database.ScoreActorEntity;
import com.database.ScoreAnalystEntity;
import com.database.ScoreFilmEntity;
import com.database.ScoreStudioEntity;
import com.repository.ScoreActorRepository;
import com.repository.ScoreAnalystRepository;
import com.repository.ScoreFilmRepository;
import com.repository.ScoreStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private final ScoreActorRepository scoreActorRepository;
    private final ScoreAnalystRepository scoreAnalystRepository;
    private final ScoreStudioRepository scoreStudioRepository;
    private final ScoreFilmRepository scoreFilmRepository;

    @Autowired
    public ScoreService(ScoreFilmRepository scoreFilmRepository, ScoreStudioRepository scoreStudioRepository,
                        ScoreAnalystRepository scoreAnalystRepository, ScoreActorRepository scoreActorRepository) {
        this.scoreActorRepository = scoreActorRepository;
        this.scoreAnalystRepository = scoreAnalystRepository;
        this.scoreFilmRepository = scoreFilmRepository;
        this.scoreStudioRepository = scoreStudioRepository;
    }

    public String findAllScoreForAnalyst() {
        int id_analyst = 2;
        float sum = 0;
        try {
            List<ScoreAnalystEntity> scoreAnalystEntities = scoreAnalystRepository.findAllByIdAnalyst(id_analyst);
            int count = scoreAnalystEntities.size();
            for (ScoreAnalystEntity scoreAnalystEntity : scoreAnalystEntities) {
                sum = sum + scoreAnalystEntity.getScore();
            }
            return "SumScoreAnalyst: " + sum + "   CountOfScores:  " + count;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllScoreForActor() {
        int id_actor = 2;
        float sum = 0;
        try {
            List<ScoreActorEntity> scoreActorEntities = scoreActorRepository.findAllByIdActor(id_actor);
            int count = scoreActorEntities.size();
            for (ScoreActorEntity scoreActorEntity : scoreActorEntities) {
                sum = sum + scoreActorEntity.getScore();
            }
            return "SumScoreActor: " + sum + "   CountOfScores:  " + count;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllScoreForStudio() {
        int id_studio = 2;
        float sum = 0;
        try {
            List<ScoreStudioEntity> scoreStudioEntities = scoreStudioRepository.findAllByIdStudio(id_studio);
            int count = scoreStudioEntities.size();
            for (ScoreStudioEntity scoreStudioEntity : scoreStudioEntities) {
                sum = sum + scoreStudioEntity.getScore();
            }
            return "SumScoreStudio: " + sum + "   CountOfScores:  " + count;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllScoreForFilm() {
        int id_film = 2;
        float sum = 0;
        try {
            List<ScoreFilmEntity> scoreFilmEntities = scoreFilmRepository.findAllByIdFilm(id_film);
            int count = scoreFilmEntities.size();
            for (ScoreFilmEntity scoreFilmEntity : scoreFilmEntities) {
                sum = sum + scoreFilmEntity.getScore();
            }
            return "SumScoreFilm: " + sum + "   CountOfScores:  " + count;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String insertNewScoreForAnalyst() {
        try {
            ScoreAnalystEntity scoreAnalystEntity  = new ScoreAnalystEntity();
            scoreAnalystEntity.setIdAnalyst(1);
            scoreAnalystEntity.setIdUserUs(2);
            scoreAnalystEntity.setScore(59);
            scoreAnalystRepository.save(scoreAnalystEntity);
            return "Save new score for analyst successfully";
        } catch (NullPointerException ex) {
            return null;
        }

    }

}
