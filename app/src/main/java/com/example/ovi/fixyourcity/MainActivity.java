package com.example.ovi.fixyourcity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private StartPage startPage;
    private LoginPage loginPage;
    private SignupPage signupPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPage=new StartPage(this);
        loginPage = new LoginPage(this);
        signupPage = new SignupPage(this);

        setContentView(startPage);
        addBehaviours();
    }

    private void addBehaviours() {
        startPage.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(loginPage);
            }
        });

        startPage.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(signupPage);
            }
        });
    }

}
