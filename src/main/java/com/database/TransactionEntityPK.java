package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TransactionEntityPK implements Serializable {
    private int idSender;
    private int idRecipient;

    @Column(name = "id_sender", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Column(name = "id_recipient", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntityPK that = (TransactionEntityPK) o;

        if (idSender != that.idSender) return false;
        if (idRecipient != that.idRecipient) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSender;
        result = 31 * result + idRecipient;
        return result;
    }
}
