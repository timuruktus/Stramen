package ru.timuruktus.stramen.models.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "current_user")
public class CurrentUser extends BasicUser implements IUser{

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    @PrimaryKey
    private String email;

    @SerializedName("registration_date")
    @Expose
    private String registrationDate;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("jw_token")
    @Expose(serialize = false)
    private String jwToken;

    public CurrentUser(){
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getJwToken() {
        return jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken = jwToken;
    }

}
