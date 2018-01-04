package ru.timuruktus.stramen.presentation.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;
import ru.timuruktus.stramen.presentation.login.view.LoginFragment;
import ru.timuruktus.stramen.presentation.main.presenter.MainPresenter;

import static ru.timuruktus.stramen.presentation.login.view.LoginFragment.LOGIN_TAG;

public class MainActivity extends MvpAppCompatActivity implements IMainActivity{


    @InjectPresenter
    MainPresenter presenter;

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),
            R.id.container){
        @Override
        protected Fragment createFragment(String fragmentTag, Object data){
            switch(fragmentTag){
                case(LOGIN_TAG):
                    return LoginFragment.getInstance();
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction){
            super.setupFragmentTransactionAnimation(command, currentFragment, nextFragment, fragmentTransaction);
//            fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }

        @Override
        protected void showSystemMessage(String message){
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit(){
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        MyApp.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause(){
        super.onPause();
        MyApp.INSTANCE.getNavigatorHolder().removeNavigator();
    }


}
