package com.service;

import com.database.*;
import com.repository.FilmRepository;
import com.repository.GenreFilmRepository;
import com.repository.PostRepository;
import com.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmService {

private final PostRepository postRepository;
    private final FilmRepository filmRepository;
    private final GenreFilmRepository genreFilmRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public FilmService(PostRepository postRepository, FilmRepository filmRepository, GenreFilmRepository genreFilmRepository, ReviewRepository reviewRepository) {
        this.postRepository = postRepository;
        this.filmRepository = filmRepository;
        this.genreFilmRepository = genreFilmRepository;
        this.reviewRepository = reviewRepository;
    }

    //SELECT film.name, film.id FROM film JOIN genre_film JOIN
    // genre g2 on genre_film.id_genre = g2.idg on film.id = g.id_film   WHERE g2.name = 'VAL'; !!!!
    public ArrayList<String> filmsSortByGenre(int id) {

        ArrayList<String> names = new ArrayList<String>();
        LinkedList<Integer> filmsId = new LinkedList<Integer>();

        LinkedList<GenreFilmEntity> genres = genreFilmRepository.filmsByGenre(3);

        for (GenreFilmEntity element : genres) {
            filmsId.add(element.getIdFilm());
        }

        for (Integer element : filmsId) {
            names.add(filmRepository.findById(element).getName());
        }
        return names;
    }

    //films for news feed
    //SELECT filM.name FROM film WHERE create_date <= current_date and  create_date >= current_date - 30;
    public String filmDate() {
        //Date date = new Date((new java.util.Date()).getTime());
        LinkedList<FilmEntity> listOfFilms = filmRepository.dateSelect();
        return listOfFilms.get(0).getName();
    }

    public String[] filmInfo(int id){
        String[] info = new String[5];
        filmRepository.findById(id);

        info[0]=( filmRepository.findById(id).getName());
        info[1]= String.valueOf(( filmRepository.findById(id).getCreateDate()));
        info[2]=( filmRepository.findById(id).getBody());
        info[3]= String.valueOf(( filmRepository.findById(id).getImg()));
        info[4]= String.valueOf(( filmRepository.findById(id).getCashbox()));

        return info;
    }

    public double filmScore(int id){
        Collection<ScoreFilmEntity> fScore = filmRepository.findById(1).getScoreFilms();
        Float sum = 1f;

        for(ScoreFilmEntity e: fScore) sum += e.getScore();

        return Math.round( sum/fScore.size()* 100.0) / 100.0 ;
    }

    public String getInfoForUserNewsFeed() {
        int id_user = 1;
        int count = 0;
        StringBuilder info = new StringBuilder();
        try {

//            LinkedList<PostEntity> postEntities = postRepository.getInfoForUserRelevantFeed(id_user);
            List<PostEntity> postEntities = postRepository.findAll();

            List<PostEntity> forFollowerPostList = new LinkedList<>();

            for (PostEntity postEntity : postEntities) {
                boolean flag = false;
                if (postEntity.getCustomers().getActors() != null) {
                    for (FollowerActorEntity followers : postEntity.getCustomers().getActors()
                            .getFollowerActors()) {
                        if (followers.getCustomers().getId() == id_user) flag = true;
                    }
                }

                if (postEntity.getCustomers().getAnalysts() != null) {
                    for (FollowerAnalystEntity followers : postEntity.getCustomers().getAnalysts()
                            .getFollowerAnalysts()) {
                        if (followers.getCustomers().getId() == id_user) flag = true;
                    }
                }

                if (postEntity.getCustomers().getStudio() != null) {
                    for (FollowerStudioEntity followers : postEntity.getCustomers().getStudio()
                            .getFollowerStudios()) {
                        if (followers.getCustomers().getId() == id_user) flag = true;
                    }
                }

                if (flag) forFollowerPostList.add(postEntity);
            }

            for (PostEntity postEntity : postEntities) {
                info.append("Author:")
                        .append(postEntity.getCustomers().getName())
                        .append("Post:")
                        .append(postEntity.getBody());
                count++;
                if (count > 50) return String.valueOf(info);
            }

//            List<TagEntity> tagEntities = tagRepository.findAll();
//            TreeMap<Integer, TagEntity> mapTag = new TreeMap<>();
//            for (TagEntity tagEntity : tagEntities) {
//                int tip = random.nextInt(5);
//                java.util.Collection c = mapTag.keySet();
//                Iterator itr = c.iterator();
//                while (itr.hasNext()) {
//                    if ((float) itr.next() == tagEntity.getCount()) mapTag.put(tagEntity.getCount() + tip, tagEntity);
//                    else mapTag.put(tagEntity.getCount() + tip, tagEntity);
//                }
//            }
//            StringBuilder info = new StringBuilder();

//            for (int i = 0; i < mapTag.size(); i++) {
//                List<PostTagEntity> postTagEntities = postTagRepository.findAllByIdTag(mapTag.get(i).getId());
//                for (int j = 0; j < postTagEntities.size(); j++) {
//                    count++;
//                    int id = postTagEntities.get(i).getIdTag();
//                    TagEntity tagEntity = (tagRepository.findById(id));
//
//                    boolean flag = false;
//
//                    List<FollowerStudioEntity> followerStudioEntities = followerStudioRepository.findByIdCustomers((int) id_user);
//                    List<FollowerActorEntity> followerActorEntities = followerActorRepository.findByIdCustomers((int) id_user);
//                    List<FollowerAnalystEntity> followerAnalystEntities = followerAnalystRepository.findByIdCustomers((int) id_user);
//
//                    for (FollowerStudioEntity followerStudioEntity : followerStudioEntities) {
//                        if (followerStudioEntity.getIdCustomers() == id_user)
////                                && followerStudioEntity.getIdStudio() == tagEntity.getAuthor())
//                            flag = true;
//                    }
//
//                    for (FollowerActorEntity followerActorEntity : followerActorEntities) {
//                        if (followerActorEntity.getIdCustomers() == id_user)
////                                && followerActorEntity.getIdActor() == tagEntity.getAuthor())
//                            flag = true;
//                    }
//
//                    for (FollowerAnalystEntity followerAnalystEntity : followerAnalystEntities) {
//                        if (followerAnalystEntity.getIdCustomers() == id_user)
////                                && followerAnalystEntity.getIdAnalyst() == tagEntity.getAuthor())
//                            flag = true;
//                    }
//
//                    if (flag) {
//
//                        id_post = postTagEntities.get(i).getIdPost();
//                        info.append("Name: ")
//                                .append(filmRepository.findById(id_post).getName())
//                                .append("  Body: ").append(filmRepository.findById(id_post).getBody())
//                                .append("  CashBox:  ").append(filmRepository.findById(id_post).getCashbox());
//                        if (count > 50) return String.valueOf(info);
//                    }
//                }
//            }

//            return
            return "UserFeed";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findTheMostInterestingAnnotation() {
        int id_film = 1;
        StringBuilder answer = new StringBuilder();
        try{
            List<ReviewEntity> reviewEntities = reviewRepository.findAllByIdFilm(id_film);
            TreeMap<ReviewEntity, Float> entityTreeMap = new TreeMap<>();

            for (ReviewEntity reviewEntity : reviewEntities) {
                float sum = 0;
                for (ScoreAnalystEntity score : reviewEntity.getAnalysts().getScoreAnalysts()) {
                    sum = +score.getScore();
                }
                entityTreeMap.put(reviewEntity, sum);
            }

            for (ReviewEntity review: reviewEntities) {
                answer.append(" Analyst: ")
                        .append(review.getAnalysts().getCustomersAnalyst().getName())
                        .append(" Body: ")
                        .append(review.getBody());
            }
//        Random random = new Random();
//        StringBuilder answer = new StringBuilder();
//        try {
//            List<ScoreAnalystEntity> scoreAnalystEntities = scoreAnalystRepository.findAll();
//            TreeMap<Float, ScoreAnalystEntity> scoreMap = new TreeMap<>();
//            List<Float> key = new ArrayList<>();
//            boolean flag = false;
//            for (ScoreAnalystEntity scoreEntity : scoreAnalystEntities) {
//                List<ReviewEntity> reviewEntitiesOfThisFilm = reviewRepository.findAllByIdAnalyst(scoreEntity.getIdAnalyst());
//                for (ReviewEntity aReviewEntitiesOfThisFilm : reviewEntitiesOfThisFilm) {
////                    if ((aReviewEntitiesOfThisFilm.getFilmByIdFilm().getId() == id_film)
////                            && (scoreEntity.getAnalystByIdAnalyst().getIdAnalyst() == aReviewEntitiesOfThisFilm.getIdAnalyst()))
////                        flag = true;
//                }
//                boolean flagForCheckingKey = true;
//                if (flag) {
//                    java.util.Collection c = scoreMap.keySet();
//                    float tip = (float) (0.1 * random.nextFloat());
//                    for (Object aC : c) {
//                        if ((Float) aC == scoreEntity.getScore()) flagForCheckingKey = false;
//                    }
//                    if (flagForCheckingKey) scoreMap.put(scoreEntity.getScore() + tip, scoreEntity);
//                    key.add(scoreEntity.getScore());
//                }
//            }
//            int count = 0;
//            java.util.Collection c = scoreMap.keySet();
//            Iterator itr = c.iterator();
//            while (itr.hasNext() && count < 3) {
//                count++;
//                Float keyOfObject = (Float) itr.next();
//                answer.append(" Analyst: ")
//                        .append(reviewRepository.findByIdAnalystAndAndFilmByIdFilm(scoreMap.get(keyOfObject).getIdAnalyst(), id_film).getIdAnalyst())
//                        .append(" Body: ")
//                        .append(reviewRepository.findByIdAnalystAndAndFilmByIdFilm(scoreMap.get(keyOfObject).getIdAnalyst(), id_film).getBody());
//            }
//            return String.valueOf(answer);
            return "the most interesting reviews";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getInfoForPopularFilms() {
        StringBuilder info = new StringBuilder();
        int count = 0;
        try {
            LinkedList<FilmEntity> filmEntities = filmRepository.popularFilmForFeed();
            for (FilmEntity filmEntity : filmEntities) {
                count++;
                info.append("Name: ")
                        .append(filmEntity.getName())
                        .append("  Body: ").append(filmEntity.getBody())
                        .append("  CashBox:  ").append(filmEntity.getCashbox());
                if (count > 50) return String.valueOf(info);
            }
            return "popular feed";
        } catch (NullPointerException ex) {
            return null;
        }
    }


    public String findMainInfoForTheFilm() {
        try {
            int film_id = 1;
            FilmEntity filmEntity = filmRepository.findById(film_id);
            return "Name:  " + filmEntity.getName() + "   Body:  " + filmEntity.getBody();
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
