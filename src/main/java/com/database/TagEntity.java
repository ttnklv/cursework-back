package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tag", schema = "public", catalog = "postgres")
public class TagEntity {
    private int id;
    private String tagName;
    private int count;
    private Collection<FilmTagEntity> filmTags;
    private Collection<PostTagEntity> postTags;
    private Collection<RevTagEntity> revTags;
    private Collection<VotesTagEntity> votesTags;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tag_name", nullable = false, length = -1)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagEntity tagEntity = (TagEntity) o;

        if (id != tagEntity.id) return false;
        if (count != tagEntity.count) return false;
        if (tagName != null ? !tagName.equals(tagEntity.tagName) : tagEntity.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @OneToMany(mappedBy = "tags")
    public Collection<FilmTagEntity> getFilmTags() {
        return filmTags;
    }

    public void setFilmTags(Collection<FilmTagEntity> filmTagsById) {
        this.filmTags = filmTagsById;
    }

    @OneToMany(mappedBy = "tags")
    public Collection<PostTagEntity> getPostTags() {
        return postTags;
    }

    public void setPostTags(Collection<PostTagEntity> postTagsById) {
        this.postTags = postTagsById;
    }

    @OneToMany(mappedBy = "tags")
    public Collection<RevTagEntity> getRevTags() {
        return revTags;
    }

    public void setRevTags(Collection<RevTagEntity> revTagsById) {
        this.revTags = revTagsById;
    }

    @OneToMany(mappedBy = "tags")
    public Collection<VotesTagEntity> getVotesTags() {
        return votesTags;
    }

    public void setVotesTags(Collection<VotesTagEntity> votesTagsById) {
        this.votesTags = votesTagsById;
    }
}
