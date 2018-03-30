package com.example.ovi.fixyourcity;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ovi on 3/30/2018.
 */

class SignupPage extends MyRelativeLayout{
    protected Button signup;
    protected EditText email;
    protected EditText password1;
    protected EditText password2;

    public SignupPage(Context context){
        super(context);
    }

    @Override
    protected void createContent() {
        {
            signup=new Button(getContext());
            signup.setText("Log In");
            signup.setId(Utils.generateId());
            RelativeLayout.LayoutParams signupLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            signupLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
            signupLayoutParams.addRule(CENTER_HORIZONTAL);
            signupLayoutParams.setMargins(0,0,0,100);
            addView(signup,signupLayoutParams);

            password2=new EditText(getContext());
            password2.setText("Password");
            password2.setId(Utils.generateId());
            //password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            password2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            RelativeLayout.LayoutParams password2LayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            password2LayoutParams.addRule(ABOVE,signup.getId());
            password2LayoutParams.addRule(ALIGN_PARENT_LEFT);
            password2LayoutParams.addRule(ALIGN_PARENT_RIGHT);
            password2LayoutParams.addRule(CENTER_HORIZONTAL);
            password2LayoutParams.setMargins(80,0,80,50);
            addView(password2,password2LayoutParams);

            password1=new EditText(getContext());
            password1.setText("Password");
            password1.setId(Utils.generateId());
            password1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            RelativeLayout.LayoutParams password1LayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            password1LayoutParams.addRule(ABOVE,password2.getId());
            password1LayoutParams.addRule(ALIGN_PARENT_LEFT);
            password1LayoutParams.addRule(ALIGN_PARENT_RIGHT);
            password1LayoutParams.addRule(CENTER_HORIZONTAL);
            password1LayoutParams.setMargins(80,0,80,50);
            addView(password1,password1LayoutParams);

            email=new EditText(getContext());
            email.setText("Email");
            email.setId(Utils.generateId());
            email.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            RelativeLayout.LayoutParams emailLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            emailLayoutParams.addRule(ABOVE,password1.getId());
            emailLayoutParams.addRule(ALIGN_PARENT_LEFT);
            emailLayoutParams.addRule(ALIGN_PARENT_RIGHT);
            emailLayoutParams.addRule(CENTER_HORIZONTAL);
            emailLayoutParams.setMargins(80,0,80,50);
            addView(email,emailLayoutParams);

            TextView signupText=new TextView(getContext());
            signupText.setText("Sign Up");
            signupText.setTextSize(25);
            signupText.setTextColor(Color.BLACK);
            signupText.setId(Utils.generateId());
            RelativeLayout.LayoutParams signupTextLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            signupTextLayoutParams.addRule(ALIGN_PARENT_TOP);
            signupTextLayoutParams.addRule(CENTER_HORIZONTAL);
            signupTextLayoutParams.setMargins(0,0,0,30);
            addView(signupText,signupTextLayoutParams);
        }
    }


}
