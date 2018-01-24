package ru.timuruktus.stramen.presentation.login.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.business.users.UserInteractor;
import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.presentation.login.view.ILoginFragment;
import ru.timuruktus.stramen.presentation.main.view.IMainActivity;

import static ru.timuruktus.stramen.presentation.main.view.MainActivity.DEFAULT_TAG;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginFragment> implements ILoginPresenter{

    @Inject
    IUserInteractor userInteractor;


    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
        MyApp.INSTANCE.plusUserComponent().inject(this);
    }

    public void onJoinButtonClicked(String email, String password){
        userInteractor.loginUser(email, password).subscribe(new Observer<CurrentUser>(){
            @Override
            public void onSubscribe(Disposable d){

            }

            @Override
            public void onNext(CurrentUser currentUser){

            }

            @Override
            public void onError(Throwable e){
                e.printStackTrace();
                Log.d(DEFAULT_TAG, e.getMessage());
            }

            @Override
            public void onComplete(){
                //TODO Open new screen
                MyApp.INSTANCE.getRouter().showSystemMessage("Done!");
            }
        });
    }

    public void onRegisterButtonClicked(){

    }

    public void onRestorePasswordClicked(){
        getViewState().showRestorePasswordDialog();
    }

    public void onPasswordRestoreRequested(String email){
        if(email.isEmpty()){
            getViewState().showEmailIsEmpty();
        }
        getViewState().showRestoreEmailHasBeenSent();
        //TODO
    }

    public void onDestroy(){
        MyApp.INSTANCE.clearUserComponent();
    }
}
