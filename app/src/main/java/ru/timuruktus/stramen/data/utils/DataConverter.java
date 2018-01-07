package ru.timuruktus.stramen.data.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DataConverter implements IDataConverter{

    Context context;
    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());

    public DataConverter(Context context){
        this.context = context;
    }


    public float convertDp2Px(float dp){
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, r.getDisplayMetrics());
        return px;
    }

    public long date2Timestamp(Date date){
        return date.getTime();
    }

    public Date string2Date(String string){
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
}
