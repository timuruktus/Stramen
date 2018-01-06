package ru.timuruktus.stramen.presentation.login.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.data.MyApp;

import static ru.timuruktus.stramen.presentation.main.view.MainActivity.DEFAULT_TAG;


public class RestorePasswordDialog extends DialogFragment{


    @BindView(R.id.dialogTitle) TextView dialogTitle;
    @BindView(R.id.emailField) EditText emailField;
    @BindView(R.id.okButton) Button okButton;
    @BindView(R.id.cancelButton) Button cancelButton;
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

    @OnClick({R.id.okButton, R.id.cancelButton})
    public void onViewClicked(View view){
        RestoreDialogListener listener;
        try{
            listener = (RestoreDialogListener) getActivity();
        }catch(ClassCastException ex){
            Log.e(DEFAULT_TAG, "RestorePasswordDialog wrong listener!");
            MyApp.INSTANCE.getRouter().showSystemMessage(errorOccurred);
            dismiss();
            return;
        }

        switch(view.getId()){
            case R.id.okButton:
                    listener.onEmailRestoreRequested(emailField.getText().toString());
                break;
            case R.id.cancelButton:
                dismiss();
                break;
        }
    }
}
