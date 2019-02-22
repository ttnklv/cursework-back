package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VotesUserEntityPK implements Serializable {
    private int idVotes;
    private int idUser;

    @Column(name = "id_votes", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdVotes() {
        return idVotes;
    }

    public void setIdVotes(int idVotes) {
        this.idVotes = idVotes;
    }

    @Column(name = "id_user", nullable = false, insertable = false, updatable = false)
    @Id
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

        VotesUserEntityPK that = (VotesUserEntityPK) o;

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
}
