package ru.timuruktus.stramen.presentation.intro;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import agency.tango.materialintroscreen.SlideFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;

import static ru.timuruktus.stramen.presentation.main.MainActivity.TESTING_TAG;


public class IntroFragment extends SlideFragment{

    public static final String ICON_BUNDLE = "Icon";
    public static final String TITLE_BUNDLE = "Title";
    public static final String DESCRIPTION_BUNDLE = "Description";
    public static final String COLOR_BUNDLE = "Color";
    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.description) TextView description;
    Unbinder unbinder;

    @DrawableRes
    private int iconId;
    @ColorRes
    private int backgroundColor;
    private String titleText;
    private String descriptionText;

    public static IntroFragment getInstance(@DrawableRes int iconId, String title,
                                            String description, @ColorRes int backgroundColor){
        Bundle bundle = new Bundle();
        bundle.putInt(ICON_BUNDLE, iconId);
        bundle.putInt(COLOR_BUNDLE, backgroundColor);
        bundle.putString(TITLE_BUNDLE, title);
        bundle.putString(DESCRIPTION_BUNDLE, description);
        IntroFragment fragment = new IntroFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setButton(String buttonText){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle == null){
            return;
        }
        iconId = bundle.getInt(ICON_BUNDLE);
        titleText = bundle.getString(TITLE_BUNDLE);
        descriptionText = bundle.getString(DESCRIPTION_BUNDLE);
        backgroundColor = bundle.getInt(COLOR_BUNDLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.intro_slide, container, false);
        unbinder = ButterKnife.bind(this, view);
        icon.setImageResource(iconId);
        title.setText(titleText);
        description.setText(descriptionText);

//        setOffset(-0.5f);
        return view;
    }

    @Override
    public int backgroundColor(){
        return backgroundColor;
    }

    @Override
    public int buttonsColor(){
        return super.buttonsColor();
    }

    @Override
    public boolean canMoveFurther(){
        return super.canMoveFurther();
    }

    @Override
    public String cantMoveFurtherErrorMessage(){
        return super.cantMoveFurtherErrorMessage();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }
}
