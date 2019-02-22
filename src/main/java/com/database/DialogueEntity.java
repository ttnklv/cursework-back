package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dialogue", schema = "public", catalog = "postgres")
public class DialogueEntity {
    private Integer id;
    private Integer idStudio;
    private Integer idAnalyst;
    private StudioEntity studios;
    private AnalystEntity analysts;
    private Collection<MessageEntity> messages;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_studio", nullable = true, insertable = false, updatable = false)
    public Integer getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Integer idStudio) {
        this.idStudio = idStudio;
    }

    @Basic
    @Column(name = "id_analyst", nullable = true, insertable = false, updatable = false)
    public Integer getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(Integer idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DialogueEntity that = (DialogueEntity) o;

        if (id != that.id) return false;
        if (idStudio != null ? !idStudio.equals(that.idStudio) : that.idStudio != null) return false;
        if (idAnalyst != null ? !idAnalyst.equals(that.idAnalyst) : that.idAnalyst != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idStudio != null ? idStudio.hashCode() : 0);
        result = 31 * result + (idAnalyst != null ? idAnalyst.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_studio", referencedColumnName = "id_studio")
    public StudioEntity getStudios() {
        return studios;
    }

    public void setStudios(StudioEntity studioByIdStudio) {
        this.studios = studioByIdStudio;
    }

    @ManyToOne
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst")
    public AnalystEntity getAnalysts() {
        return analysts;
    }

    public void setAnalysts(AnalystEntity analystByIdAnalyst) {
        this.analysts = analystByIdAnalyst;
    }

    @OneToMany(mappedBy = "dialogues")
    public Collection<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageEntity> messagesById) {
        this.messages = messagesById;
    }
}
