package ru.timuruktus.stramen.models.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ru.timuruktus.stramen.models.entities.BasicUser;
import rx.Observable;

@Dao
public interface BasicUserDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<BasicUser> people);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BasicUser user);

    @Delete
    void delete(BasicUser person);

    @Update
    int updateAll(List<BasicUser> users);

    @Update
    void update(BasicUser user);

    @Query("SELECT * FROM basic_user")
    Observable<List<BasicUser>> getAllPeople();
}
