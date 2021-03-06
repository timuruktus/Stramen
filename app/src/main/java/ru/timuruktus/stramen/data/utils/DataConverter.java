package ru.timuruktus.stramen.data.utils;

import android.arch.persistence.room.TypeConverter;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import ru.timuruktus.stramen.models.entities.project_levels.ICard;
import ru.timuruktus.stramen.models.entities.project_levels.IPreviewCard;
import ru.timuruktus.stramen.models.entities.project_levels.IProject;
import ru.timuruktus.stramen.models.entities.project_levels.ISubProject;
import ru.timuruktus.stramen.models.entities.utilite_settings.IMark;
import ru.timuruktus.stramen.models.entities.utilite_settings.IToDoList;
import ru.timuruktus.stramen.models.entities.utilite_settings.Timer;

public class DataConverter implements IDataConverter{

    private Context context;
    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());

    public DataConverter(Context context){
        this.context = context;
    }

    public DataConverter(){
    }

    public float convertDpToPx(float dp){
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, r.getDisplayMetrics());
        return px;
    }

    @TypeConverter
    public long dateToTimestamp(Date date){
        return date.getTime();
    }

    @TypeConverter
    public static Date timestampToDate(Long timestamp){
        if(timestamp == null){
            return null;
        }
        return new Date(timestamp);
    }

    @TypeConverter
    public Date stringToDate(String string){
        // "2018-01-06T18:35:29.996925Z" - example
        //"yyyy-MM-dd'T'HH:mm:ss.SSSZ" - pattern format

        Calendar calendar = new GregorianCalendar();
        Date date;
        try{
            date = formatter.parse(string);
        }catch(ParseException e){
            e.printStackTrace();
            return calendar.getTime();
        }
        return date;
    }

    @TypeConverter
    public String dateToString(Date date){
        return formatter.format(date);
    }

    @TypeConverter
    public Timer stringToTimer(String string){
        // "2018-01-06T18:35:29.996925Z" - example
        //"yyyy-MM-dd'T'HH:mm:ss.SSSZ" - pattern format

        Calendar calendar = new GregorianCalendar();
        Date date;
        Timer timer = new Timer();
        try{
            date = formatter.parse(string);
        }catch(ParseException e){
            e.printStackTrace();
            timer.setTimestamp(dateToTimestamp(calendar.getTime()));
            return timer;
        }
        timer.setTimestamp(dateToTimestamp(date));
        return timer;
    }

    @TypeConverter
    public String timerToString(Timer timer){
        // "2018-01-06T18:35:29.996925Z" - example
        //"yyyy-MM-dd'T'HH:mm:ss.SSSZ" - pattern format

        long timestamp = timer.getTimestamp();

        return dateToString(timestampToDate(timestamp));
    }

    @TypeConverter
    public String fromProjectListToString(List<IProject> projects){
        if(projects == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(projects, type);
        return json;
    }

    @TypeConverter
    public List<IProject> fromStringToProjectList(String projectsString){
        if(projectsString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<IProject> projectsList = gson.fromJson(projectsString, type);
        return projectsList;
    }

    @TypeConverter
    public String fromSubProjectListToString(List<ISubProject> projects){
        if(projects == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(projects, type);
        return json;
    }

    @TypeConverter
    public List<ISubProject> fromStringToSubProjectList(String subProjectString){
        if(subProjectString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<ISubProject> subProjectList = gson.fromJson(subProjectString, type);
        return subProjectList;
    }

    @TypeConverter
    public String fromCardsListToString(List<ICard> cards){
        if(cards == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(cards, type);
        return json;
    }

    @TypeConverter
    public List<ICard> fromStringToCardsList(String cardsString){
        if(cardsString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<ICard> cardsList = gson.fromJson(cardsString, type);
        return cardsList;
    }

    @TypeConverter
    public String fromPreviewCardsListToString(List<IPreviewCard> previewCards){
        if(previewCards == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(previewCards, type);
        return json;
    }

    @TypeConverter
    public List<IPreviewCard> fromStringToPreviewCardsList(String previewCardsString){
        if(previewCardsString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<IPreviewCard> previewCardsList = gson.fromJson(previewCardsString, type);
        return previewCardsList;
    }

    @TypeConverter
    public String fromMarksListToString(List<IMark> marks){
        if(marks == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(marks, type);
        return json;
    }

    @TypeConverter
    public List<IMark> fromStringToMarksList(String marksString){
        if(marksString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<IMark> marksList = gson.fromJson(marksString, type);
        return marksList;
    }

    @TypeConverter
    public String fromTodoListsToString(List<IToDoList> toDoLists){
        if(toDoLists == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        String json = gson.toJson(toDoLists, type);
        return json;
    }

    @TypeConverter
    public List<IToDoList> fromStringToTodoLists(String toDoListsString){
        if(toDoListsString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<IProject>>(){
        }.getType();
        List<IToDoList> todoLists = gson.fromJson(toDoListsString, type);
        return todoLists;
    }
}
