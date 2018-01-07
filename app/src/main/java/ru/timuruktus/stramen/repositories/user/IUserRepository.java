package ru.timuruktus.stramen.repositories.user;

import java.util.List;

import io.reactivex.Observable;
import ru.timuruktus.stramen.models.users.BasicUser;
import ru.timuruktus.stramen.models.users.CurrentUser;
import ru.timuruktus.stramen.models.users.IUser;

public interface IUserRepository{

    Observable<CurrentUser> getCurrentUser();

    Observable<List<IUser>> getAllCachedUsers();
    void clearAllCachedUsers();

    void clearUser(int id);
    void updateUser(IUser user);
    void replaceUser(IUser newUser, IUser oldUser);

    Observable<List<IUser>> getAllUsersFromProject(String projectId);
    Observable<List<IUser>> getAllUsersFromSubProject(String subProjectId);
    Observable<List<IUser>> getAllUsersFromTask(String taskId);


}
