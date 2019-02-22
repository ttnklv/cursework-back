package com.database;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "message", schema = "public", catalog = "postgres")
public class MessageEntity {
    private Integer id;
    private Integer idStudio;
    private Integer idAnalyst;
    private String body;
    private Date createDate;
    private Integer idDialogue;
    private StudioEntity studios;
    private AnalystEntity analysts;
    private DialogueEntity dialogues;

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

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "id_dialogue", nullable = true, insertable = false, updatable = false)
    public Integer getIdDialogue() {
        return idDialogue;
    }

    public void setIdDialogue(Integer idDialogue) {
        this.idDialogue = idDialogue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (idStudio != null ? !idStudio.equals(that.idStudio) : that.idStudio != null) return false;
        if (idAnalyst != null ? !idAnalyst.equals(that.idAnalyst) : that.idAnalyst != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (idDialogue != null ? !idDialogue.equals(that.idDialogue) : that.idDialogue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idStudio != null ? idStudio.hashCode() : 0);
        result = 31 * result + (idAnalyst != null ? idAnalyst.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (idDialogue != null ? idDialogue.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "id_dialogue", referencedColumnName = "id")
    public DialogueEntity getDialogues() {
        return dialogues;
    }

    public void setDialogues(DialogueEntity dialogueByIdDialogue) {
        this.dialogues = dialogueByIdDialogue;
    }
}
