package ru.timuruktus.stramen.models.entities.project_levels;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sub_project")
public class SubProject implements ISubProject{

    @PrimaryKey
    @Expose
    @NonNull
    private String id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private int color;
    @Expose
    private String strategy;
    @Expose
    @SerializedName("project_id")
    private String projectId;

    public SubProject(){
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public String getStrategy(){
        return strategy;
    }

    public void setStrategy(String strategy){
        this.strategy = strategy;
    }

    public String getProjectId(){
        return projectId;
    }

    public void setProjectId(String projectId){
        this.projectId = projectId;
    }
}
