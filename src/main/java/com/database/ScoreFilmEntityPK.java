package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ScoreFilmEntityPK implements Serializable {
    private int idUserUs;
    private int idFilm;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Column(name = "id_film", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreFilmEntityPK that = (ScoreFilmEntityPK) o;

        if (idUserUs != that.idUserUs) return false;
        if (idFilm != that.idFilm) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idFilm;
        return result;
    }
}
