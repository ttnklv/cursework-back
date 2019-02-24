package com.database;

import javax.persistence.*;

@Entity
@Table(name = "complaint", schema = "public", catalog = "postgres")
public class ComplaintEntity {
    private Integer idCustomers;
    private int id;
    private String body;
    private String answer;
    private CustomersEntity customers;
    private boolean checker;

    @Basic
    @Column(name = "id_customers", nullable = true, insertable = false, updatable = false)
    public Integer getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(Integer idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "answer", nullable = true, length = -1)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

//    @Basic
//    @Column(name = "checker", nullable = false)
//    public int getChecker() {
//        return checker;
//    }
//
//    public void setBody(int checker) {
//        this.checker = checker;
//    }
//
//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplaintEntity that = (ComplaintEntity) o;

        if (id != that.id) return false;
        if (idCustomers != null ? !idCustomers.equals(that.idCustomers) : that.idCustomers != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers != null ? idCustomers.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_customers", referencedColumnName = "id")
    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customersByIdCustomers) {
        this.customers = customersByIdCustomers;
    }

    @Basic
    @Column(name = "checker", nullable = false)
    public boolean getChecker() {
        return checker;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }
}
