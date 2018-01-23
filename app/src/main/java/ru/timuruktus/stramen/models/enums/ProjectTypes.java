package ru.timuruktus.stramen.models.enums;

import com.google.gson.annotations.SerializedName;

public class ProjectTypes{

    @SerializedName("free")
    public static final int FREE = 0;

    @SerializedName("startup")
    public static final int STARTUP = 1;

    @SerializedName("normal")
    public static final int NORMAL = 2;

    @SerializedName("pro")
    public static final int PRO = 3;

    @SerializedName("premium")
    public static final int PREMIUM = 4;

}
