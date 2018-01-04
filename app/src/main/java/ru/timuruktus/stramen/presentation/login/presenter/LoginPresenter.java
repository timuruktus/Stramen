package ru.timuruktus.stramen.presentation.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.timuruktus.stramen.presentation.login.view.ILoginFragment;
import ru.timuruktus.stramen.presentation.main.view.IMainActivity;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginFragment> implements ILoginPresenter{
}
