package ru.timuruktus.stramen.presentation.registration;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.net.ConnectException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.models.entities.CurrentUser;

import static ru.timuruktus.stramen.presentation.main.MainActivity.DEFAULT_TAG;
import static ru.timuruktus.stramen.presentation.main.MainActivity.TESTING_TAG;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<IRegistrationFragment>{

    @Inject
    IUserInteractor userInteractor;

    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
        MyApp.INSTANCE.plusUserComponent().inject(this);
        getViewState().showAppearAnimations();
    }

    public void onRegisterButtonClicked(String email, String username,
                                        String password1, String password2){
        if(!password1.equals(password2)){
            getViewState().showPasswordsMatchError();
            return;
        }

        if(!allFieldsAreFilled(email, username, password1, password2)){
            return;
        }

        userInteractor.registerUser(email, username, password1).subscribe(new Observer<CurrentUser>(){
            @Override
            public void onSubscribe(Disposable d){

            }

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
                    getViewState().showSomeError();
                }
            }

            @Override
            public void onComplete(){
                MyApp.INSTANCE.getRouter().showSystemMessage("DONE!!!");
            }
        });



    }

    private boolean allFieldsAreFilled(String email, String username,
                                       String password1, String password2){
        boolean fieldsFilled = true;
        if(email.isEmpty()){
            getViewState().showEmailEmptyError();
            fieldsFilled = false;
        }

        if(username.isEmpty()){
            getViewState().showUsernameEmptyError();
            fieldsFilled = false;
        }

        if(password1.isEmpty()){
            getViewState().showPassword1EmptyError();
            fieldsFilled = false;
        }

        if(password2.isEmpty()){
            getViewState().showPassword2EmptyError();
            fieldsFilled = false;
        }

        return fieldsFilled;
    }
}
