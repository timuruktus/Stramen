package ru.timuruktus.stramen.presentation.login;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.net.ConnectException;

import javax.inject.Inject;

import butterknife.BindString;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.models.entities.CurrentUser;

import static ru.timuruktus.stramen.presentation.main.MainActivity.DEFAULT_TAG;
import static ru.timuruktus.stramen.presentation.main.MainActivity.TESTING_TAG;
import static ru.timuruktus.stramen.presentation.registration.RegistrationFragment.REGISTRATION_TAG;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginFragment> implements ILoginPresenter{

    @Inject
    IUserInteractor userInteractor;


    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
        MyApp.INSTANCE.plusUserComponent().inject(this);
        getViewState().showAppearAnimations();
    }

    public void onJoinButtonClicked(String email, String password){

        if(!allFieldsAreFilled(email, password)){
            return;
        }

        userInteractor.loginUser(email, password).subscribe(new Observer<CurrentUser>(){
            @Override
            public void onSubscribe(Disposable d){}

            @Override
            public void onNext(CurrentUser currentUser){
                Log.d(TESTING_TAG, currentUser.toString());
            }

            @Override
            public void onError(Throwable e){
                e.printStackTrace();
                if(e instanceof ConnectException){
                    getViewState().showInternetConnectionError();
                }else{
                    getViewState().showWrongLoginData();
                }
            }


            @Override
            public void onComplete(){
                //TODO Open new screen
                MyApp.INSTANCE.getRouter().showSystemMessage("Done!");
            }
        });
    }

    public void onRegisterButtonClicked(){
        MyApp.INSTANCE.getRouter().navigateTo(REGISTRATION_TAG);
    }

    public void onRestorePasswordClicked(){
        getViewState().showRestorePasswordDialog();
    }

    public void onPasswordRestoreRequested(String email){
        if(email.isEmpty()){
            getViewState().showEmailIsEmpty();
            return;
        }
        getViewState().showRestoreEmailHasBeenSent();
        userInteractor.resetPassword(email);
    }

    public void onDestroy(){
        MyApp.INSTANCE.clearUserComponent();
    }

    private boolean allFieldsAreFilled(String email, String password){
        boolean fieldsFilled = true;
        if(email.isEmpty()){
            getViewState().showEmailEmptyError();
            fieldsFilled = false;
        }

        if(password.isEmpty()){
            getViewState().showPasswordEmptyError();
            fieldsFilled = false;
        }

        return fieldsFilled;
    }
}
