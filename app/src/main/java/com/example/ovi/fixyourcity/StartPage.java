package com.example.ovi.fixyourcity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartPage extends MyRelativeLayout{
    protected Button login;
    protected Button signup;

    public StartPage(Context context) {
        super(context);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void createContent() {
        setBackgroundImage();
        signup=new Button(getContext());
        signup.setText("Sign Up");
        signup.setId(Utils.generateId());
        RelativeLayout.LayoutParams signupLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        signupLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
        signupLayoutParams.addRule(CENTER_HORIZONTAL);
        signupLayoutParams.setMargins(0,0,0,100);
        addView(signup,signupLayoutParams);

        login=new Button(getContext());
        login.setText("Log In");
        login.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        loginLayoutParams.addRule(ABOVE, signup.getId());
        loginLayoutParams.addRule(CENTER_HORIZONTAL);
        loginLayoutParams.setMargins(0,0,0,50);
        addView(login,loginLayoutParams);

        TextView welcome=new TextView(getContext());
        welcome.setText("Welcome!");
        welcome.setTextSize(25);
        welcome.setTextColor(Color.BLACK);
        welcome.setId(Utils.generateId());
        RelativeLayout.LayoutParams welcomeLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        welcomeLayoutParams.addRule(ALIGN_PARENT_TOP);
        welcomeLayoutParams.setMargins(30,30,0,20);
        addView(welcome,welcomeLayoutParams);

    }

    public void setBackgroundImage(){
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.background) );
        } else {
            this.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.background));
        }
    }

}
