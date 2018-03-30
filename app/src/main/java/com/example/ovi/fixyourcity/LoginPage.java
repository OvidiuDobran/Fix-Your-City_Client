package com.example.ovi.fixyourcity;

import android.content.Context;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ovi on 3/29/2018.
 */

class LoginPage extends MyRelativeLayout {
    protected Button login;
    protected EditText email;
    protected EditText password;

    public LoginPage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        login=new Button(getContext());
        login.setText("Log In");
        login.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        loginLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
        loginLayoutParams.addRule(CENTER_HORIZONTAL);
        loginLayoutParams.setMargins(0,0,0,100);
        addView(login,loginLayoutParams);

        password=new EditText(getContext());
        password.setText("Email");
        password.setId(Utils.generateId());
        //password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        RelativeLayout.LayoutParams passwordLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        passwordLayoutParams.addRule(ABOVE,login.getId());
        passwordLayoutParams.addRule(CENTER_HORIZONTAL);
        passwordLayoutParams.setMargins(0,0,0,50);
        addView(password,passwordLayoutParams);

        email=new EditText(getContext());
        //email.setText("Password");
        email.setId(Utils.generateId());
        email.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        RelativeLayout.LayoutParams emailLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        emailLayoutParams.addRule(ABOVE,password.getId());
        emailLayoutParams.addRule(CENTER_HORIZONTAL);
        emailLayoutParams.setMargins(0,0,0,50);
        addView(email,emailLayoutParams);

        TextView loginText=new TextView(getContext());
        loginText.setText("Log In");
        loginText.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginTextLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        loginTextLayoutParams.addRule(ALIGN_PARENT_TOP);
        emailLayoutParams.addRule(CENTER_HORIZONTAL);
        loginTextLayoutParams.setMargins(0,0,0,30);
        addView(loginText,loginTextLayoutParams);
    }

}
