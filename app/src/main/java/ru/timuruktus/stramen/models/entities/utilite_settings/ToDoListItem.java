package ru.timuruktus.stramen.models.entities.utilite_settings;

public class ToDoListItem implements IToDoListItem{

    private String description;
    private boolean marked;

    public ToDoListItem(){
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isMarked(){
        return marked;
    }

    public void setMarked(boolean marked){
        this.marked = marked;
    }
}
