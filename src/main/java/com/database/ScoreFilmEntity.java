package com.database;

import javax.persistence.*;

@Entity
@Table(name = "score_film", schema = "public", catalog = "postgres")
@IdClass(ScoreFilmEntityPK.class)
public class ScoreFilmEntity {
    private int idUserUs;
    private int idFilm;
    private float score;
    private UserUsEntity userUss;
    private FilmEntity films;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "score", nullable = false, precision = 0)
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreFilmEntity that = (ScoreFilmEntity) o;

        if (idUserUs != that.idUserUs) return false;
        if (idFilm != that.idFilm) return false;
        if (Float.compare(that.score, score) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idFilm;
        result = 31 * result + (score != +0.0f ? Float.floatToIntBits(score) : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user_us", referencedColumnName = "id_user_us", nullable = false)
    public UserUsEntity getUserUss() {
        return userUss;
    }

    public void setUserUss(UserUsEntity userUsByIdUserUs) {
        this.userUss = userUsByIdUserUs;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilms() {
        return films;
    }

    public void setFilms(FilmEntity filmByIdFilm) {
        this.films = filmByIdFilm;
    }
}
