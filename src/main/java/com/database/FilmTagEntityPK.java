package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FilmTagEntityPK implements Serializable {
    private int idTag;
    private int idFilm;

    @Column(name = "id_tag", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
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

        FilmTagEntityPK that = (FilmTagEntityPK) o;

        if (idTag != that.idTag) return false;
        if (idFilm != that.idFilm) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTag;
        result = 31 * result + idFilm;
        return result;
    }
}
