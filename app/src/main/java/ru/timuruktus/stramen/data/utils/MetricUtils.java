package ru.timuruktus.stramen.data.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class MetricUtils implements IMetricUtils{

    Context context;

    public MetricUtils(Context context){
        this.context = context;
    }


    public float convertDp2Px(float dp){
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, r.getDisplayMetrics());
        return px;
    }
}
