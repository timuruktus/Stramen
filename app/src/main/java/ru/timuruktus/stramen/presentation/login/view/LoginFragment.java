package ru.timuruktus.stramen.presentation.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.presentation.login.presenter.LoginPresenter;

public class LoginFragment extends MvpAppCompatFragment implements ILoginFragment{

    @InjectPresenter
    public LoginPresenter loginPresenter;
    private Unbinder unbinder;
    private Context context;
    public static final String LOGIN_TAG = "LoginTag";

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(
                R.layout.login_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = view.getContext();
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }
}
