package ru.timuruktus.stramen.presentation.login;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ILoginFragment extends MvpView{

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showRestorePasswordDialog();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showRestoreEmailHasBeenSent();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showEmailIsEmpty();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showEmailIsWrong();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAppearAnimations();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showWrongLoginData();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showInternetConnectionError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showEmailEmptyError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showPasswordEmptyError();


}
