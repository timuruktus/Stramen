package ru.timuruktus.stramen.presentation.login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;

import static ru.timuruktus.stramen.presentation.main.MainActivity.DEFAULT_TAG;


public class RestorePasswordDialog extends DialogFragment{


    @BindView(R.id.dialogTitle) TextView dialogTitle;
    @BindView(R.id.emailField) EditText emailField;
    @BindView(R.id.accept) TextView accept;
    @BindView(R.id.cancel) TextView cancel;
    @BindView(R.id.dialogGoodLuck) TextView dialogGoodLuck;
    @BindString(R.string.error_occurred) String errorOccurred;
    Unbinder unbinder;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.restore_password_dialog, null);
        builder.setView(view);
        unbinder = ButterKnife.bind(this, view);
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.accept, R.id.cancel})
    public void onViewClicked(View view){
        RestoreDialogListener listener;
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//        getTargetFragment()
        try{
            if(getParentFragment() == null){
                listener = (RestoreDialogListener) getActivity();
            }else{
                listener = (RestoreDialogListener) getParentFragment();
            }
        }catch(ClassCastException ex){
            Log.e(DEFAULT_TAG, "RestorePasswordDialog wrong listener!");
            MyApp.INSTANCE.getRouter().showSystemMessage(errorOccurred);
            dismiss();
            return;
        }

        switch(view.getId()){
            case R.id.accept:
                listener.onPasswordRestoreRequested(emailField.getText().toString());
                dismiss();
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }
}
