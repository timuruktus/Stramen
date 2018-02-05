package ru.timuruktus.stramen.presentation.projects;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.models.entities.project_levels.IProject;


public class ProjectsFragment extends MvpAppCompatFragment implements IProjectsFragment{


    private Unbinder unbinder;
    private Context context;
    public static final String PROJECTS_TAG = "ProjectsTag";
    @InjectPresenter
    public ProjectPresenter projectPresenter;

    public static ProjectsFragment getInstance(){
        return new ProjectsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(
                R.layout.projects_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = view.getContext();
        return view;
    }

    @Override
    public void showEmptyPlaceholder(){

    }

    @Override
    public void showErrorPlaceholder(){

    }

    @Override
    public void showProjects(List<IProject> projects){

    }
}
