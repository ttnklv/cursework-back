package com.database;

import javax.persistence.*;

@Entity
@Table(name = "votes_user", schema = "public", catalog = "postgres")
@IdClass(VotesUserEntityPK.class)
public class VotesUserEntity {
    private int idVotes;
    private int idUser;
    private VotesEntity votes;
    private UserUsEntity userUss;

    @Id
    @Column(name = "id_votes", nullable = false)
    public int getIdVotes() {
        return idVotes;
    }

    public void setIdVotes(int idVotes) {
        this.idVotes = idVotes;
    }

    @Id
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesUserEntity that = (VotesUserEntity) o;

        if (idVotes != that.idVotes) return false;
        if (idUser != that.idUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVotes;
        result = 31 * result + idUser;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_votes", referencedColumnName = "id", nullable = false)
    public VotesEntity getVotes() {
        return votes;
    }

    public void setVotes(VotesEntity votesByIdVotes) {
        this.votes = votesByIdVotes;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user_us", nullable = false)
    public UserUsEntity getUserUss() {
        return userUss;
    }

    public void setUserUss(UserUsEntity userUsByIdUser) {
        this.userUss = userUsByIdUser;
    }
}
