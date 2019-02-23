package com.database;

import javax.persistence.*;

@Entity
@Table(name = "rev_tag", schema = "public", catalog = "postgres")
@IdClass(RevTagEntityPK.class)
public class RevTagEntity {
    private int idTag;
    private int idReview;
    private TagEntity tags;
    private ReviewEntity reviews;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_review", nullable = false)
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

        RevTagEntity that = (RevTagEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id", nullable = false)
    public TagEntity getTags() {
        return tags;
    }

    public void setTags(TagEntity tagByIdTag) {
        this.tags = tagByIdTag;
    }

    @ManyToOne
    @JoinColumn(name = "id_review", referencedColumnName = "id", nullable = false)
    public ReviewEntity getReviews() {
        return reviews;
    }

    public void setReviews(ReviewEntity reviewByIdReview) {
        this.reviews = reviewByIdReview;
    }
}
