package ru.timuruktus.stramen.presentation.reusable;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.presentation.reusable.IRecyclerFragment;

/**
 * This class is shouldn't be used outside the fragment.
 * It is for inner use only!
 */
@Deprecated
public class RecyclerFragment extends MvpAppCompatFragment implements IRecyclerFragment{

    private Unbinder unbinder;
    private Context context;
    public static final String RECYCLER_TAG = "Recycler Tag";
    @InjectPresenter
    public RecyclerPresenter recyclerPresenter;

    public static RecyclerFragment getInstance(){
        return new RecyclerFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(
                R.layout.recycler_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = view.getContext();
        return view;
    }



}
