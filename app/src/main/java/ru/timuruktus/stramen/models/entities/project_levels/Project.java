package ru.timuruktus.stramen.models.entities.project_levels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "project")
public class Project implements IProject{

    @PrimaryKey
    @Expose
    @NonNull
    private String id;
    @Expose
    @SerializedName("type")
    private int projectType;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private int color;

    public Project(){
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getProjectType(){
        return projectType;
    }

    public void setProjectType(int projectType){
        this.projectType = projectType;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }
}
