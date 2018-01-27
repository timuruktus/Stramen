package ru.timuruktus.stramen.presentation.registration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appolica.flubber.Flubber;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;

public class RegistrationFragment extends MvpAppCompatFragment implements IRegistrationFragment{



    @BindView(R.id.email) EditText email;
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password1) EditText password1;
    @BindView(R.id.password2) EditText password2;
    @BindView(R.id.registrationSign) ConstraintLayout registrationSign;
    @BindView(R.id.register) Button register;
    @BindView(R.id.back) Button back;
    @BindString(R.string.passwords_match_error) String passwordsMatchError;
    @BindString(R.string.mythical_error_happened) String mythicalError;
    @BindString(R.string.confirm_password) String confirmPassword;

    @BindString(R.string.internet_connection_error) String internetConnectionError;

    @BindString(R.string.empty_field) String emptyField;
    private Unbinder unbinder;
    private Context context;
    public static final String REGISTRATION_TAG = "Registration Tag";
    @InjectPresenter
    public RegistrationPresenter registrationPresenter;

    public static RegistrationFragment getInstance(){
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(
                R.layout.register_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = view.getContext();
        return view;
    }


    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.register, R.id.back})
    public void onViewClicked(View view){
        switch(view.getId()){
            case R.id.register:
                registrationPresenter.onRegisterButtonClicked(
                        email.getText().toString(),
                        username.getText().toString(),
                        password1.getText().toString(),
                        password2.getText().toString());
                break;
            case R.id.back:
                MyApp.INSTANCE.getRouter().exit();
                break;
        }
    }

    @Override
    public void showAppearAnimations(){
        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_UP)
                .interpolator(Flubber.Curve.BZR_SPRING)
                .force(0.5f)
                .damping(0.1f)
                .duration(500)
                .autoStart(true)
                .createFor(registrationSign);
    }

    @Override
    public void showPasswordsMatchError(){
//        MyApp.INSTANCE.getRouter().showSystemMessage(passwordsMatchError);
        password2.setError(passwordsMatchError);
    }

    @Override
    public void showEmailEmptyError(){
        email.setError(emptyField);
    }

    @Override
    public void showUsernameEmptyError(){
        username.setError(emptyField);
    }

    @Override
    public void showPassword1EmptyError(){
        password1.setError(emptyField);
    }

    @Override
    public void showPassword2EmptyError(){
        password2.setError(emptyField);
    }

    @Override
    public void showInternetConnectionError(){
        MyApp.INSTANCE.getRouter().showSystemMessage(internetConnectionError);
    }

    @Override
    public void showSomeError(){
        MyApp.INSTANCE.getRouter().showSystemMessage(mythicalError);
    }

    @Override
    public void showConfirmPasswordNotification(){
        MyApp.INSTANCE.getRouter().showSystemMessage(confirmPassword);
    }
}
