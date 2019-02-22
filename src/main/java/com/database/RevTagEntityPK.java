package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RevTagEntityPK implements Serializable {
    private int idTag;
    private int idReview;

    @Column(name = "id_tag", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Column(name = "id_review", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RevTagEntityPK that = (RevTagEntityPK) o;

        if (idTag != that.idTag) return false;
        if (idReview != that.idReview) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTag;
        result = 31 * result + idReview;
        return result;
    }
}
