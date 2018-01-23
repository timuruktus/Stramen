package ru.timuruktus.stramen.models.entities.project_levels;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.timuruktus.stramen.data.utils.DataConverter;
import ru.timuruktus.stramen.models.entities.utilite_settings.IMark;
import ru.timuruktus.stramen.models.entities.utilite_settings.Timer;

@Entity(tableName = "preview_card")
public class PreviewCard implements IPreviewCard{

    @PrimaryKey
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private int cardType;
    @Expose
    @TypeConverters(DataConverter.class)
    private Timer timer;
    @Nullable
    @Expose
    private String description;
    @Expose
    private int color;
    @Expose
    private String name;
    @Expose
    @SerializedName("is_active")
    private boolean isActive;
    @Expose
    private int priority;
    @Expose
    private List<IMark> marks;
    @SerializedName("sub_project_id")
    private String subProjectId;

    public PreviewCard(){
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getCardType(){
        return cardType;
    }

    public void setCardType(int cardType){
        this.cardType = cardType;
    }

    @Nullable
    public String getDescription(){
        return description;
    }

    public void setDescription(@Nullable String description){
        this.description = description;
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean active){
        isActive = active;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public List<IMark> getMarks(){
        return marks;
    }

    public void setMarks(List<IMark> marks){
        this.marks = marks;
    }

    public Timer getTimer(){
        return timer;
    }

    public void setTimer(Timer timer){
        this.timer = timer;
    }
}
