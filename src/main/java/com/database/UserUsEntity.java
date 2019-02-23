package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_us", schema = "public", catalog = "postgres")
public class UserUsEntity {
    private int idUserUs;
    private Collection<ChatUserEntity> chatUsers;
    private Collection<ScoreActorEntity> scoreActors;
    private Collection<ScoreAnalystEntity> scoreAnalysts;
    private Collection<ScoreFilmEntity> scoreFilms;
    private Collection<ScoreStudioEntity> scoreStudios;
    private CustomersEntity customers;
    private Collection<VotesUserEntity> votesUsers;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserUsEntity that = (UserUsEntity) o;

        if (idUserUs != that.idUserUs) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUserUs;
    }

    @OneToMany(mappedBy = "users")
    public Collection<ChatUserEntity> getChatUsers() {
        return chatUsers;
    }

    public void setChatUsers(Collection<ChatUserEntity> chatUsersByIdUserUs) {
        this.chatUsers = chatUsersByIdUserUs;
    }

    @OneToMany(mappedBy = "userUss")
    public Collection<ScoreActorEntity> getScoreActors() {
        return scoreActors;
    }

    public void setScoreActors(Collection<ScoreActorEntity> scoreActorsByIdUserUs) {
        this.scoreActors = scoreActorsByIdUserUs;
    }

    @OneToMany(mappedBy = "userUss")
    public Collection<ScoreAnalystEntity> getScoreAnalysts() {
        return scoreAnalysts;
    }

    public void setScoreAnalysts(Collection<ScoreAnalystEntity> scoreAnalystsByIdUserUs) {
        this.scoreAnalysts = scoreAnalystsByIdUserUs;
    }

    @OneToMany(mappedBy = "userUss")
    public Collection<ScoreFilmEntity> getScoreFilms() {
        return scoreFilms;
    }

    public void setScoreFilms(Collection<ScoreFilmEntity> scoreFilmsByIdUserUs) {
        this.scoreFilms = scoreFilmsByIdUserUs;
    }

    @OneToMany(mappedBy = "userUss")
    public Collection<ScoreStudioEntity> getScoreStudios() {
        return scoreStudios;
    }

    public void setScoreStudios(Collection<ScoreStudioEntity> scoreStudiosByIdUserUs) {
        this.scoreStudios = scoreStudiosByIdUserUs;
    }

    @OneToOne
    @JoinColumn(name = "id_user_us", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customersByIdUserUs) {
        this.customers = customersByIdUserUs;
    }

    @OneToMany(mappedBy = "userUss")
    public Collection<VotesUserEntity> getVotesUsers() {
        return votesUsers;
    }

    public void setVotesUsers(Collection<VotesUserEntity> votesUsersByIdUserUs) {
        this.votesUsers = votesUsersByIdUserUs;
    }
}
