package ru.timuruktus.stramen.presentation.login;

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
import android.widget.TextView;

import com.appolica.flubber.Flubber;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;

public class LoginFragment extends MvpAppCompatFragment implements ILoginFragment, RestoreDialogListener{


//    @BindView(R.id.loginSign) LinearLayout loginSign;
    @BindView(R.id.emailField) EditText emailField;
    @BindView(R.id.logo) ImageView logo;
    @BindView(R.id.passwordField) EditText passwordField;
    @BindView(R.id.joinButton) Button joinButton;
    @BindView(R.id.registerButton) Button registerButton;
    @BindColor(R.color.greenAcceptColor) int colorJoinButton;
    @BindView(R.id.restorePassword) TextView restorePassword;
    @BindString(R.string.email_is_sent) String emailIsSent;
    @BindString(R.string.empty_email_field) String emptyEmailField;
    @BindString(R.string.empty_field) String emptyField;
    @BindString(R.string.wrong_login_data) String wrongLoginData;
    @BindString(R.string.internet_connection_error) String internetConnectionError;
    @BindString(R.string.wrong_email_field) String wrongEmailField;
    private Unbinder unbinder;
    private Context context;
    public static final String LOGIN_TAG = "LoginTag";
    @InjectPresenter
    public LoginPresenter loginPresenter;

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
        DialogFragment restoreDialog = new RestorePasswordDialog();
//        restoreDialog.setTargetFragment(this, 0);
        restoreDialog.show(getChildFragmentManager(), "Restore Dialog");
    }

    @Override
    public void showRestoreEmailHasBeenSent(){
        MyApp.INSTANCE.getRouter().showSystemMessage(emailIsSent);
    }

    @Override
    public void showEmailIsEmpty(){
        MyApp.INSTANCE.getRouter().showSystemMessage(emptyEmailField);
    }

    @Override
    public void showEmailIsWrong(){
        MyApp.INSTANCE.getRouter().showSystemMessage(wrongEmailField);
    }

    @Override
    public void showAppearAnimations(){
        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_RIGHT)
                .interpolator(Flubber.Curve.SPRING)
                .duration(1000)
                .autoStart(true)
                .createFor(logo);

    }

    @Override
    public void showWrongLoginData(){
        MyApp.INSTANCE.getRouter().showSystemMessage(wrongLoginData);
        passwordField.setText("");
    }

    @Override
    public void showInternetConnectionError(){
        MyApp.INSTANCE.getRouter().showSystemMessage(internetConnectionError);
    }

    @Override
    public void showEmailEmptyError(){
        emailField.setError(emptyField);
    }

    @Override
    public void showPasswordEmptyError(){
        passwordField.setError(emptyField);
    }

    @Override
    public void onPasswordRestoreRequested(String email){
        loginPresenter.onPasswordRestoreRequested(email);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
