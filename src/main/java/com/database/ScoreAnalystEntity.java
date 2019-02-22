package com.database;

import javax.persistence.*;

@Entity
@Table(name = "score_analyst", schema = "public", catalog = "postgres")
@IdClass(ScoreAnalystEntityPK.class)
public class ScoreAnalystEntity {
    private int idUserUs;
    private int idAnalyst;
    private float score;
    private UserUsEntity userUss;
    private AnalystEntity analysts;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
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

        ScoreAnalystEntity that = (ScoreAnalystEntity) o;

        if (idUserUs != that.idUserUs) return false;
        if (idAnalyst != that.idAnalyst) return false;
        if (Float.compare(that.score, score) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idAnalyst;
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
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalysts() {
        return analysts;
    }

    public void setAnalysts(AnalystEntity analystByIdAnalyst) {
        this.analysts = analystByIdAnalyst;
    }
}
