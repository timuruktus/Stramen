package ru.timuruktus.stramen.models.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.timuruktus.stramen.data.utils.DataConverter;
import ru.timuruktus.stramen.models.entities.project_levels.IPreviewCard;
import ru.timuruktus.stramen.models.entities.project_levels.IProject;
import ru.timuruktus.stramen.models.entities.project_levels.ISubProject;


@Entity(tableName = "basic_user")
public class BasicUser implements IUser{

    @SerializedName("id")
    @Expose
    @PrimaryKey
    private String id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("post")
    @Expose
    private String post;

    @TypeConverters(DataConverter.class)
    @Expose(serialize = false)
    private List<IProject> projects;

    @TypeConverters(DataConverter.class)
    @Expose(serialize = false)
    private List<ISubProject> subProjects;

    @TypeConverters(DataConverter.class)
    @Expose(serialize = false)
    private List<IPreviewCard> cards;

    public BasicUser(){
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

    public void setUsername(String username){
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getPost(){
        return post;
    }

    public void setPost(String post){
        this.post = post;
    }

    public List<IProject> getProjects(){
        return projects;
    }

    public void setProjects(List<IProject> projects){
        this.projects = projects;
    }

    public List<ISubProject> getSubProjects(){
        return subProjects;
    }

    public void setSubProjects(List<ISubProject> subProjects){
        this.subProjects = subProjects;
    }

    public List<IPreviewCard> getCards(){
        return cards;
    }

    public void setCards(List<IPreviewCard> cards){
        this.cards = cards;
    }

}
