package com.example.ovi.fixyourcity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    protected StartPage startPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected String email;
    protected String password;
    protected ProblemPage problemPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPage = new StartPage(this);
        loginPage = new LoginPage(this);
        signupPage = new SignupPage(this);
        problemPage = new ProblemPage(this);

        setContentView(startPage);
    }


}
