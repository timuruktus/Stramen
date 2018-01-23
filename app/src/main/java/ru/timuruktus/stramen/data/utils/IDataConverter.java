package ru.timuruktus.stramen.data.utils;

import java.util.Date;

public interface IDataConverter{

    float convertDpToPx(float dp);
    long dateToTimestamp(Date date);
}
