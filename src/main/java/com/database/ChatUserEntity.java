package com.database;

import javax.persistence.*;

@Entity
@Table(name = "chat_user", schema = "public", catalog = "postgres")
@IdClass(ChatUserEntityPK.class)
public class ChatUserEntity {
    private int idUs;
    private int idChat;
    private UserUsEntity users;
    private ChatEntity chats;

    @Id
    @Column(name = "id_us", nullable = false)
    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }

    @Id
    @Column(name = "id_chat", nullable = false)
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

        ChatUserEntity that = (ChatUserEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_us", referencedColumnName = "id_user_us", nullable = false)
    public UserUsEntity getUsers() {
        return users;
    }

    public void setUsers(UserUsEntity userUsByIdUs) {
        this.users = userUsByIdUs;
    }

    @ManyToOne
    @JoinColumn(name = "id_chat", referencedColumnName = "id", nullable = false)
    public ChatEntity getChats() {
        return chats;
    }

    public void setChats(ChatEntity chatByIdChat) {
        this.chats = chatByIdChat;
    }
}
