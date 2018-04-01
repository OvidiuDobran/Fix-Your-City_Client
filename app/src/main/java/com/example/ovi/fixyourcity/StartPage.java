package com.example.ovi.fixyourcity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartPage extends MyRelativeLayout{
    protected Button loginButton;
    protected Button signupButton;

    public StartPage(Context context) {
        super(context);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void createContent() {
        setBackgroundImage();
        signupButton =new Button(getContext());
        signupButton.setText("Sign Up");
        signupButton.setId(Utils.generateId());
        RelativeLayout.LayoutParams signupLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        signupLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
        signupLayoutParams.addRule(CENTER_HORIZONTAL);
        signupLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        signupLayoutParams.addRule(ALIGN_PARENT_LEFT);
        signupLayoutParams.setMargins(120,0,120,100);
        addView(signupButton,signupLayoutParams);

        loginButton =new Button(getContext());
        loginButton.setText("Log In");
        loginButton.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        loginLayoutParams.addRule(ABOVE, signupButton.getId());
        loginLayoutParams.addRule(CENTER_HORIZONTAL);
        loginLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        loginLayoutParams.addRule(ALIGN_PARENT_LEFT);
        loginLayoutParams.setMargins(120,0,120,50);
        addView(loginButton,loginLayoutParams);

        TextView welcomeText=new TextView(getContext());
        welcomeText.setText("Welcome!\nReport the problems\nfrom your city!");
        welcomeText.setTextSize(25);
        welcomeText.setTextColor(Color.BLACK);
        welcomeText.setId(Utils.generateId());
        RelativeLayout.LayoutParams welcomeLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        welcomeLayoutParams.addRule(ALIGN_PARENT_TOP);
        welcomeLayoutParams.setMargins(30,30,0,20);
        addView(welcomeText,welcomeLayoutParams);

    }

    @Override
    protected void addBehaviours() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().setContentView(getMainActivity().loginPage);
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().setContentView(getMainActivity().signupPage);
            }
        });
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
