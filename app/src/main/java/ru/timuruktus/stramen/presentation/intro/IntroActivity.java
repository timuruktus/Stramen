package ru.timuruktus.stramen.presentation.intro;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import javax.inject.Inject;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.data.utils.ISettings;
import ru.timuruktus.stramen.presentation.main.MainActivity;

public class IntroActivity extends MaterialIntroActivity{

    private String chatTitle;
    private String chatAdvantages;
    private String taskTitle;
    private String taskAdvantages;
    private String businessTitle;
    private String businessAdvantages;
    private String welcome;
    @Inject ISettings settings;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.INSTANCE.getAppComponent().inject(this);
        initAllResources();
        addAllSlides();
    }

    private void initAllResources(){
        Resources res = getResources();
        chatTitle = res.getString(R.string.chat_title);
        chatAdvantages = res.getString(R.string.chat_advantages);
        taskTitle = res.getString(R.string.task_title);
        taskAdvantages = res.getString(R.string.task_advantages);
        businessTitle = res.getString(R.string.business_title);
        businessAdvantages = res.getString(R.string.business_advantages);
        welcome = res.getString(R.string.welcome);
    }

    public void addAllSlides(){
        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.slide1)
                        .image(R.drawable.ic_chat)
                        .title(chatTitle)
                        .description(chatAdvantages)
                        .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.slide2)
                .image(R.drawable.ic_checklist)
                .title(taskTitle)
                .description(taskAdvantages)
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.slide3)
                .image(R.drawable.ic_business_grow)
                .title(businessTitle)
                .description(businessAdvantages)
                .build(),
                new MessageButtonBehaviour(v -> {
                    Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                    startActivity(intent);
                    settings.setShouldShowIntro(false);
                }, welcome));


    }
}
