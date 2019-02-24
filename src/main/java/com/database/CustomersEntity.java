package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "customers", schema = "public", catalog = "postgres")
public class CustomersEntity {

    private Integer id;
    private String name;
    private String login;
    private String profileImageUrl;
    private String emailHash;
    private String password;
    private String mobNumber;
    private boolean reputation;
    private Date lastAccess;
    private int levelAccess;
    private byte[] img;
    private ActorEntity actors;
    private AnalystEntity analysts;
    private Collection<ChatEntity> chats;
    private Collection<ComplaintEntity> complaints;
    private Collection<FollowerActorEntity> followersActor;
    private Collection<FollowerAnalystEntity> followersAnalyst;
    private Collection<FollowerStudioEntity> followersStudio;
    private Collection<PostEntity> posts;
    private StudioEntity studio;
    private UserUsEntity userUs;
    private Collection<VerificationEntity> verifications;

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

    @Basic
    @Column(name = "img", nullable = true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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
        if (!Arrays.equals(img, that.img)) return false;

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
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }

    @OneToOne(mappedBy = "customerActor")
    public ActorEntity getActors() {
        return actors;
    }

    public void setActors(ActorEntity actorById) {
        this.actors = actorById;
    }

    @OneToOne(mappedBy = "customersAnalyst")
    public AnalystEntity getAnalysts() {
        return analysts;
    }

    public void setAnalysts(AnalystEntity analystById) {
        this.analysts = analystById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<ChatEntity> getChats() {
        return chats;
    }

    public void setChats(Collection<ChatEntity> chatsById) {
        this.chats = chatsById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<ComplaintEntity> getComplaints() {
        return complaints;
    }

    public void setComplaints(Collection<ComplaintEntity> complaintsById) {
        this.complaints = complaintsById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<FollowerActorEntity> getFollowersActor() {
        return followersActor;
    }

    public void setFollowersActor(Collection<FollowerActorEntity> followerActorsById) {
        this.followersActor = followerActorsById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<FollowerAnalystEntity> getFollowersAnalyst() {
        return followersAnalyst;
    }

    public void setFollowersAnalyst(Collection<FollowerAnalystEntity> followerAnalystsById) {
        this.followersAnalyst = followerAnalystsById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<FollowerStudioEntity> getFollowersStudio() {
        return followersStudio;
    }

    public void setFollowersStudio(Collection<FollowerStudioEntity> followerStudiosById) {
        this.followersStudio = followerStudiosById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(Collection<PostEntity> postsById) {
        this.posts = postsById;
    }

    @OneToOne(mappedBy = "customers")
    public StudioEntity getStudio() {
        return studio;
    }

    public void setStudio(StudioEntity studioById) {
        this.studio = studioById;
    }

    @OneToOne(mappedBy = "customers")
    public UserUsEntity getUserUs() {
        return userUs;
    }

    public void setUserUs(UserUsEntity userUsById) {
        this.userUs = userUsById;
    }

    @OneToMany(mappedBy = "customers")
    public Collection<VerificationEntity> getVerifications() {
        return verifications;
    }

    public void setVerifications(Collection<VerificationEntity> verificationsById) {
        this.verifications = verificationsById;
    }

}
