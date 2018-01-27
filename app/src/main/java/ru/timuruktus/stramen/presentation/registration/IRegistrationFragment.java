package ru.timuruktus.stramen.presentation.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface IRegistrationFragment extends MvpView{


    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAppearAnimations();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showPasswordsMatchError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showEmailEmptyError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showUsernameEmptyError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showPassword1EmptyError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showPassword2EmptyError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showInternetConnectionError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showSomeError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showConfirmPasswordNotification();
}
