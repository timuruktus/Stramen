package ru.timuruktus.stramen.presentation.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.presentation.login.presenter.LoginPresenter;

public class LoginFragment extends MvpAppCompatFragment implements ILoginFragment, RestoreDialogListener{

    @InjectPresenter
    public LoginPresenter loginPresenter;
    @BindView(R.id.loginSign) LinearLayout loginSign;
    @BindView(R.id.emailField) EditText emailField;
    @BindView(R.id.logo) ImageView logo;
    @BindView(R.id.passwordField) EditText passwordField;
    @BindView(R.id.joinButton) Button joinButton;
    @BindView(R.id.registerButton) Button registerButton;
    @BindColor(R.color.colorJoinButton) int colorJoinButton;
    @BindView(R.id.restorePassword) TextView restorePassword;
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

    @OnClick({R.id.joinButton, R.id.registerButton, R.id.restorePassword})
    public void onViewClicked(View view){
        switch(view.getId()){
            case R.id.joinButton:
                loginPresenter.onJoinButtonClicked(emailField.getText().toString(), passwordField.getText().toString());
                break;
            case R.id.registerButton:
                loginPresenter.onRegisterButtonClicked();
                break;
            case R.id.restorePassword:
                loginPresenter.onRestorePasswordClicked();
                break;
        }
    }

    @Override
    public void showRestorePasswordDialog(){
        DialogFragment newFragment = new RestorePasswordDialog();
        newFragment.show(getFragmentManager(), "Restore Dialog");
    }

    @Override
    public void onEmailRestoreRequested(String email){
        loginPresenter.onEmailRestoreRequested(email);
    }
}
