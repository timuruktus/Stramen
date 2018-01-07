package ru.timuruktus.stramen.presentation.login.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ILoginFragment extends MvpView{

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showRestorePasswordDialog();
}
