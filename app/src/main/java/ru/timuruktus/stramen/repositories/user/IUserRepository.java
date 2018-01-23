package ru.timuruktus.stramen.repositories.user;

import java.util.List;

import io.reactivex.Observable;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.models.entities.IUser;

public interface IUserRepository{

    Observable<CurrentUser> getCurrentUser();

    Observable<List<IUser>> getAllCachedUsers();
    void clearAllCachedUsers();

    void clearUser(int id);
    void updateUser(IUser user);
    void replaceUser(IUser newUser, IUser oldUser);
    void saveCurrentUser(CurrentUser currentUser);

    Observable<List<IUser>> getAllUsersFromProject(String projectId);
    Observable<List<IUser>> getAllUsersFromSubProject(String subProjectId);
    Observable<List<IUser>> getAllUsersFromTask(String taskId);


}
