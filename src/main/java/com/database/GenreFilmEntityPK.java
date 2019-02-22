package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GenreFilmEntityPK implements Serializable {
    private int idFilm;
    private int idGenre;

    @Column(name = "id_film", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Column(name = "id_genre", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreFilmEntityPK that = (GenreFilmEntityPK) o;

        if (idFilm != that.idFilm) return false;
        if (idGenre != that.idGenre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idGenre;
        return result;
    }
}
