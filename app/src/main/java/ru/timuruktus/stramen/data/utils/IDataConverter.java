package ru.timuruktus.stramen.data.utils;

import java.util.Date;

public interface IDataConverter{

    float convertDp2Px(float dp);
    long date2Timestamp(Date date);
}
