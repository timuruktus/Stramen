package ru.timuruktus.stramen.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.timuruktus.stramen.models.dao.BasicUserDAO;
import ru.timuruktus.stramen.models.entities.BasicUser;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.models.entities.project_levels.Card;
import ru.timuruktus.stramen.models.entities.project_levels.PreviewCard;
import ru.timuruktus.stramen.models.entities.project_levels.Project;
import ru.timuruktus.stramen.models.entities.project_levels.SubProject;

@Database(entities = {BasicUser.class, CurrentUser.class, Card.class, PreviewCard.class,
        Project.class, SubProject.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract BasicUserDAO getBasicUserDao();
}
