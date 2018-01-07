package ru.timuruktus.stramen.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.timuruktus.stramen.models.dao.BasicUserDAO;
import ru.timuruktus.stramen.models.users.BasicUser;

@Database(entities = {BasicUser.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract BasicUserDAO getPersonDao();
}
