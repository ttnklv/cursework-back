package botBase;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customers", schema = "public", catalog = "postgres")
public class CustomersEntity {
    private int id;
    private String name;
    private String login;
    private String profileImageUrl;
    private String emailHash;
    private String password;
    private String mobNumber;
    private boolean reputation;
    private Date lastAccess;
    private int levelAccess;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "login", nullable = false, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "profile_image_url", nullable = true, length = -1)
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Basic
    @Column(name = "email_hash", nullable = false, length = -1)
    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mob_number", nullable = false, length = 11)
    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Basic
    @Column(name = "reputation", nullable = false)
    public boolean isReputation() {
        return reputation;
    }

    public void setReputation(boolean reputation) {
        this.reputation = reputation;
    }

    @Basic
    @Column(name = "last_access", nullable = false)
    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Basic
    @Column(name = "level_access", nullable = false)
    public int getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(int levelAccess) {
        this.levelAccess = levelAccess;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (id != that.id) return false;
        if (reputation != that.reputation) return false;
        if (levelAccess != that.levelAccess) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (profileImageUrl != null ? !profileImageUrl.equals(that.profileImageUrl) : that.profileImageUrl != null)
            return false;
        if (emailHash != null ? !emailHash.equals(that.emailHash) : that.emailHash != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (mobNumber != null ? !mobNumber.equals(that.mobNumber) : that.mobNumber != null) return false;
        if (lastAccess != null ? !lastAccess.equals(that.lastAccess) : that.lastAccess != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (profileImageUrl != null ? profileImageUrl.hashCode() : 0);
        result = 31 * result + (emailHash != null ? emailHash.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mobNumber != null ? mobNumber.hashCode() : 0);
        result = 31 * result + (reputation ? 1 : 0);
        result = 31 * result + (lastAccess != null ? lastAccess.hashCode() : 0);
        result = 31 * result + levelAccess;
        return result;
    }
}
