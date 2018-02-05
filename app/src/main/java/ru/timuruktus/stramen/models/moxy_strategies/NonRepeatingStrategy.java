package ru.timuruktus.stramen.models.moxy_strategies;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;

import java.util.List;

public class NonRepeatingStrategy implements StateStrategy{

    @Override
    public <View extends MvpView> void beforeApply(List<ViewCommand<View>> currentState, ViewCommand<View> incomingCommand){
        for(ViewCommand<View> command : currentState){
            if(command.getStrategyType().equals(incomingCommand.getStrategyType())){
                currentState.remove(command);
            }
        }

        currentState.add(incomingCommand);
    }

    @Override
    public <View extends MvpView> void afterApply(List<ViewCommand<View>> currentState, ViewCommand<View> incomingCommand){

    }
}
