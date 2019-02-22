package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ChatUserEntityPK implements Serializable {
    private int idUs;
    private int idChat;

    @Column(name = "id_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }

    @Column(name = "id_chat", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatUserEntityPK that = (ChatUserEntityPK) o;

        if (idUs != that.idUs) return false;
        if (idChat != that.idChat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUs;
        result = 31 * result + idChat;
        return result;
    }
}
