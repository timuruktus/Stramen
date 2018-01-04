package ru.timuruktus.stramen.data.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class Settings implements ISettings{

    private static final String APP_PREFERENCES = "mySettings";
    private static final String FIRST_OPEN = "firstOpen";

    private SharedPreferences settings;

    public Settings(Context context){
        if(settings == null){
            settings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        }
    }


    @Override
    public boolean isFirstOpen() {
        return getBooleanValue(FIRST_OPEN, true);
    }

    @Override
    public void setFirstOpen(boolean firstSign) {
        writeBooleanValue(FIRST_OPEN, firstSign);
    }

    /**
     * UNDER THIS LINE- 1-LVL METHODS
     * 1-lvl methods is used to write and read data from SharedReference.
     */

    private void writeStringValue(String path, String value){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(path, value);
        editor.apply();
    }

    private void writeLongValue(String path, long value){
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(path, value);
        editor.apply();
    }

    private void writeBooleanValue(String path, boolean value){
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(path, value);
        editor.apply();
    }

    private String getStringValue(String path){
        return getStringValue(path, "");
    }

    private String getStringValue(String path, String defaultValue){
        return settings.getString(path, defaultValue);
    }

    private long getLongValue(String path){
        return getLongValue(path, 0);
    }

    private long getLongValue(String path, long defaultValue){
        return settings.getLong(path, defaultValue);
    }

    private boolean getBooleanValue(String path){
        return getBooleanValue(path, false);
    }

    private boolean getBooleanValue(String path, boolean defaultValue){
        return settings.getBoolean(path, defaultValue);
    }
}
