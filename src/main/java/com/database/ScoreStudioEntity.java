package com.database;

import javax.persistence.*;

@Entity
@Table(name = "score_studio", schema = "public", catalog = "postgres")
@IdClass(ScoreStudioEntityPK.class)
public class ScoreStudioEntity {
    private int idUserUs;
    private int idStudio;
    private float score;
    private UserUsEntity userUss;
    private StudioEntity studios;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_studio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
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

        ScoreStudioEntity that = (ScoreStudioEntity) o;

        if (idUserUs != that.idUserUs) return false;
        if (idStudio != that.idStudio) return false;
        if (Float.compare(that.score, score) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idStudio;
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
    @JoinColumn(name = "id_studio", referencedColumnName = "id_studio", nullable = false)
    public StudioEntity getStudios() {
        return studios;
    }

    public void setStudios(StudioEntity studioByIdStudio) {
        this.studios = studioByIdStudio;
    }
}
