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
import ru.timuruktus.stramen.models.entities.utilite_settings.IToDoList;
import ru.timuruktus.stramen.models.entities.utilite_settings.Timer;

@Entity(tableName = "card")
public class Card implements ICard{

    @PrimaryKey
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private int cardType;
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
    @TypeConverters(DataConverter.class)
    private Timer timer;
    @Expose
    private List<IMark> marks;
    @Expose
    @SerializedName("todo_list")
    private List<IToDoList> toDoList;
    @Expose
    @SerializedName("chat_id")
    private String chatId;
    @Expose
    @SerializedName("sub_project_id")
    private String subProjectId;

    public Card(){
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

    public Timer getTimer(){
        return timer;
    }

    public void setTimer(Timer timer){
        this.timer = timer;
    }

    public List<IMark> getMarks(){
        return marks;
    }

    public void setMarks(List<IMark> marks){
        this.marks = marks;
    }

    public List<IToDoList> getToDoList(){
        return toDoList;
    }

    public void setToDoList(List<IToDoList> toDoList){
        this.toDoList = toDoList;
    }

    public String getChatId(){
        return chatId;
    }

    public void setChatId(String chatId){
        this.chatId = chatId;
    }

    public String getSubProjectId(){
        return subProjectId;
    }

    public void setSubProjectId(String subProjectId){
        this.subProjectId = subProjectId;
    }
}
