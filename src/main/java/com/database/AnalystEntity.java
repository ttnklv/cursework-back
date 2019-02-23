package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "analyst", schema = "public", catalog = "postgres")
public class AnalystEntity {
    private Integer idAnalyst;
    private String aboutMe;
    private Long purse;
    private CustomersEntity customersAnalyst;
    private Collection<DialogueEntity> dialogues;
    private Collection<FollowerAnalystEntity> followerAnalysts;
    private Collection<MessageEntity> messages;
    private Collection<ReviewEntity> reviews;
    private Collection<ScoreAnalystEntity> scoreAnalysts;
    private Collection<TransactionEntity> transactions;

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Basic
    @Column(name = "about_me", nullable = true, length = -1)
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Basic
    @Column(name = "purse", nullable = true)
    public Long getPurse() {
        return purse;
    }

    public void setPurse(Long purse) {
        this.purse = purse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnalystEntity that = (AnalystEntity) o;

        if (idAnalyst != that.idAnalyst) return false;
        if (aboutMe != null ? !aboutMe.equals(that.aboutMe) : that.aboutMe != null) return false;
        if (purse != null ? !purse.equals(that.purse) : that.purse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnalyst;
        result = 31 * result + (aboutMe != null ? aboutMe.hashCode() : 0);
        result = 31 * result + (purse != null ? purse.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_analyst", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomersAnalyst() {
        return customersAnalyst;
    }

    public void setCustomersAnalyst(CustomersEntity customersByIdAnalyst) {
        this.customersAnalyst = customersByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<DialogueEntity> getDialogues() {
        return dialogues;
    }

    public void setDialogues(Collection<DialogueEntity> dialoguesByIdAnalyst) {
        this.dialogues = dialoguesByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<FollowerAnalystEntity> getFollowerAnalysts() {
        return followerAnalysts;
    }

    public void setFollowerAnalysts(Collection<FollowerAnalystEntity> followerAnalystsByIdAnalyst) {
        this.followerAnalysts = followerAnalystsByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageEntity> messagesByIdAnalyst) {
        this.messages = messagesByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<ReviewEntity> reviewsByIdAnalyst) {
        this.reviews = reviewsByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<ScoreAnalystEntity> getScoreAnalysts() {
        return scoreAnalysts;
    }

    public void setScoreAnalysts(Collection<ScoreAnalystEntity> scoreAnalystsByIdAnalyst) {
        this.scoreAnalysts = scoreAnalystsByIdAnalyst;
    }

    @OneToMany(mappedBy = "analysts")
    public Collection<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<TransactionEntity> transactionsByIdAnalyst) {
        this.transactions = transactionsByIdAnalyst;
    }
}
