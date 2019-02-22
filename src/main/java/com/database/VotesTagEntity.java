package com.database;

import javax.persistence.*;

@Entity
@Table(name = "votes_tag", schema = "public", catalog = "postgres")
@IdClass(VotesTagEntityPK.class)
public class VotesTagEntity {
    private int idTag;
    private int idVotes;
    private TagEntity tags;
    private VotesEntity votes;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_votes", nullable = false)
    public int getIdVotes() {
        return idVotes;
    }

    public void setIdVotes(int idVotes) {
        this.idVotes = idVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesTagEntity that = (VotesTagEntity) o;

        if (idTag != that.idTag) return false;
        if (idVotes != that.idVotes) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTag;
        result = 31 * result + idVotes;
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
    @JoinColumn(name = "id_votes", referencedColumnName = "id", nullable = false)
    public VotesEntity getVotes() {
        return votes;
    }

    public void setVotes(VotesEntity votesByIdVotes) {
        this.votes = votesByIdVotes;
    }
}
