package com.database;

import javax.persistence.*;

@Entity
@Table(name = "score_actor", schema = "public", catalog = "postgres")
@IdClass(ScoreActorEntityPK.class)
public class ScoreActorEntity {
    private int idUserUs;
    private int idActor;
    private float score;
    private UserUsEntity userUss;
    private ActorEntity actors;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
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

        ScoreActorEntity that = (ScoreActorEntity) o;

        if (idUserUs != that.idUserUs) return false;
        if (idActor != that.idActor) return false;
        if (Float.compare(that.score, score) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserUs;
        result = 31 * result + idActor;
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
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor", nullable = false)
    public ActorEntity getActors() {
        return actors;
    }

    public void setActors(ActorEntity actorByIdActor) {
        this.actors = actorByIdActor;
    }
}
