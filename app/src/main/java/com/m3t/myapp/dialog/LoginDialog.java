package com.m3t.myapp.dialog;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;

import com.m3t.myapp.R;

/**
 * Created by namvp58uet on 27/05/2016.
 */
public class LoginDialog extends AppCompatDialog {
    public LoginDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_login);
    }
}
