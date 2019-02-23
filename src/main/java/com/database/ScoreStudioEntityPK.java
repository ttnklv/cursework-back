package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ScoreStudioEntityPK implements Serializable {
    private int idUserUs;
    private int idStudio;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
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

        ScoreStudioEntityPK that = (ScoreStudioEntityPK) o;

        if (idUserUs != that.idUserUs) return false;
        if (idStudio != that.idStudio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idStudio;
        return result;
    }
}
