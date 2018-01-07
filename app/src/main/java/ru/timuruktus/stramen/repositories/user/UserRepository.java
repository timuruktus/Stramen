package ru.timuruktus.stramen.repositories.user;

import java.util.List;

import io.reactivex.Observable;
import ru.timuruktus.stramen.models.users.CurrentUser;
import ru.timuruktus.stramen.models.users.IUser;

public class UserRepository implements IUserRepository{


    @Override
    public Observable<CurrentUser> getCurrentUser(){
        return null;
    }

    @Override
    public Observable<List<IUser>> getAllCachedUsers(){
        return null;
    }

    @Override
    public void clearAllCachedUsers(){

    }

    @Override
    public void clearUser(int id){

    }

    @Override
    public void updateUser(IUser user){

    }

    @Override
    public void replaceUser(IUser newUser, IUser oldUser){

    }

    @Override
    public void saveCurrentUser(CurrentUser currentUser){

    }

    @Override
    public Observable<List<IUser>> getAllUsersFromProject(String projectId){
        return null;
    }

    @Override
    public Observable<List<IUser>> getAllUsersFromSubProject(String subProjectId){
        return null;
    }

    @Override
    public Observable<List<IUser>> getAllUsersFromTask(String taskId){
        return null;
    }
}
