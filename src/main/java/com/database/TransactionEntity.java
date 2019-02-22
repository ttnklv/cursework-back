package com.database;

import javax.persistence.*;

@Entity
@Table(name = "transaction", schema = "public", catalog = "postgres")
@IdClass(TransactionEntityPK.class)
public class TransactionEntity {
    private int idSender;
    private int idRecipient;
    private long sum;
    private StudioEntity studios;
    private AnalystEntity analysts;

    @Id
    @Column(name = "id_sender", nullable = false)
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Id
    @Column(name = "id_recipient", nullable = false)
    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Basic
    @Column(name = "sum", nullable = false)
    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (idSender != that.idSender) return false;
        if (idRecipient != that.idRecipient) return false;
        if (sum != that.sum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSender;
        result = 31 * result + idRecipient;
        result = 31 * result + (int) (sum ^ (sum >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_sender", referencedColumnName = "id_studio", nullable = false)
    public StudioEntity getStudios() {
        return studios;
    }

    public void setStudios(StudioEntity studioByIdSender) {
        this.studios = studioByIdSender;
    }

    @ManyToOne
    @JoinColumn(name = "id_recipient", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalysts() {
        return analysts;
    }

    public void setAnalysts(AnalystEntity analystByIdRecipient) {
        this.analysts = analystByIdRecipient;
    }
}
