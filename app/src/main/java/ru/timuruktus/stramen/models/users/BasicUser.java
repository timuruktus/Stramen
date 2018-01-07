package ru.timuruktus.stramen.models.users;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
public class BasicUser implements IUser{

    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar")
    @Expose
    private String avatar;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
