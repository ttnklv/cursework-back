package botBase;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FollowerActorEntityPK implements Serializable {
    private int idCustomers;
    private int idActor;

    @Column(name = "id_customers", nullable = false)
    @Id
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Column(name = "id_actor", nullable = false)
    @Id
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowerActorEntityPK that = (FollowerActorEntityPK) o;

        if (idCustomers != that.idCustomers) return false;
        if (idActor != that.idActor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers;
        result = 31 * result + idActor;
        return result;
    }
}
