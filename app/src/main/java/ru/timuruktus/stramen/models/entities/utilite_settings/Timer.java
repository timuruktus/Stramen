package ru.timuruktus.stramen.models.entities.utilite_settings;

public class Timer implements ITimer{

    private long timestamp;

    public Timer(long timestamp){
        this.timestamp = timestamp;
    }

    public Timer(){
    }

    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }
}
