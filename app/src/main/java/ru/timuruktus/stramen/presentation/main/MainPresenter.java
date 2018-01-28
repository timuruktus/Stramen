package ru.timuruktus.stramen.presentation.main;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.data.utils.ISettings;

import static ru.timuruktus.stramen.presentation.login.LoginFragment.LOGIN_TAG;

@InjectViewState
public class MainPresenter extends MvpPresenter<IMainActivity> implements IMainPresenter{

    @Inject
    ISettings settings;

    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
        MyApp.INSTANCE.getAppComponent().inject(this);
        if(settings.shouldShowIntro()){
            getViewState().startIntroActivity();
            return;
        }
        if(settings.isFirstOpen()){
            MyApp.INSTANCE.getRouter().newRootScreen(LOGIN_TAG);
        }else{
            MyApp.INSTANCE.getRouter().newRootScreen(LOGIN_TAG);
            //TODO
        }
    }
}
