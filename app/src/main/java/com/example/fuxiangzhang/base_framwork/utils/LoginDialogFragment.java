package com.example.fuxiangzhang.base_framwork.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.fuxiangzhang.base_framwork.R;

/**
 * Created by Fuxiang.Zhang on 2017/9/1.
 */

public class LoginDialogFragment extends DialogFragment {

    private EditText usename;
    private EditText password;

    public interface LoginInputLister{
        void  onLoginInputComplete(String username,String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater mInflater=getActivity().getLayoutInflater();
        View mView=mInflater.inflate(R.layout.dialog_define,null);
        usename= (EditText) mView.findViewById(R.id.et_name);
        password= (EditText) mView.findViewById(R.id.et_password);
        return new AlertDialog.Builder(getActivity()).setView(mView)
                .setPositiveButton("Sign", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface mDialogInterface, int mI) {
                        LoginInputLister listener = (LoginInputLister) getActivity();
                        listener.onLoginInputComplete(usename.getText().toString(),password.getText().toString());
                    }
                }).setNegativeButton("Cancel",null)
                .create();

    }


}
