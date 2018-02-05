package ru.timuruktus.stramen.presentation.projects;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.timuruktus.stramen.models.entities.project_levels.IProject;
import ru.timuruktus.stramen.models.moxy_strategies.NonRepeatingStrategy;

public interface IProjectsFragment extends MvpView{

    @StateStrategyType(NonRepeatingStrategy.class)
    void showEmptyPlaceholder();

    @StateStrategyType(NonRepeatingStrategy.class)
    void showErrorPlaceholder();

    @StateStrategyType(NonRepeatingStrategy.class)
    void showProjects(List<IProject> projects);
}
