package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ScriptEntityPK implements Serializable {
    private int idFilm;
    private int idStudio;

    @Column(name = "id_film", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Column(name = "id_studio", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScriptEntityPK that = (ScriptEntityPK) o;

        if (idFilm != that.idFilm) return false;
        if (idStudio != that.idStudio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idStudio;
        return result;
    }
}
