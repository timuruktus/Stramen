package ru.timuruktus.stramen.presentation.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface IMainActivity extends MvpView{

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startIntroActivity();
}
