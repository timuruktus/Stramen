package ru.timuruktus.stramen.models.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "current_user")
public class CurrentUser extends BasicUser implements IUser{

    @Expose
    private String url;

    @Expose
    private String email;

    @SerializedName("registration_date")
    @Expose
    private String registrationDate;

    @SerializedName("jw_token")
    @Expose(serialize = false)
    private String jwToken;

    public CurrentUser(){
    }

    public CurrentUser(String url, String id, String username, String email, String registrationDate, String avatar, String jwToken){
        this.url = url;
        this.email = email;
        this.registrationDate = registrationDate;
        this.jwToken = jwToken;
    }

    @Override
    public String toString(){
        return super.toString() + " CurrentUser{" +
                "url='" + url + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", jwToken='" + jwToken + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getJwToken() {
        return jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken = jwToken;
    }

}
