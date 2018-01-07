package ru.timuruktus.stramen.models.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.timuruktus.stramen.models.users.BasicUser;
import ru.timuruktus.stramen.models.users.IUser;
import rx.Observable;

@Dao
public interface BasicUserDAO{

    @Insert
    void insertAll(BasicUser... people);

    @Delete
    void delete(BasicUser person);

    @Query("SELECT * FROM basicuser")
    Observable<List<BasicUser>> getAllPeople();
}
