package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ScoreAnalystEntityPK implements Serializable {
    private int idUserUs;
    private int idAnalyst;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Column(name = "id_analyst", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreAnalystEntityPK that = (ScoreAnalystEntityPK) o;

        if (idUserUs != that.idUserUs) return false;
        if (idAnalyst != that.idAnalyst) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idAnalyst;
        return result;
    }
}
