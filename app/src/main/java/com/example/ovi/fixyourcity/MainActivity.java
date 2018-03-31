package com.example.ovi.fixyourcity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected StartPage startPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected String email;
    protected String password;
    protected ProblemPage problemPage;
    protected View currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPage = new StartPage(this);
        loginPage = new LoginPage(this);
        signupPage = new SignupPage(this);
        problemPage = new ProblemPage(this);

        setContentView(startPage);


    }

    public void makeText(String text) {
        Toast.makeText(MainActivity.this, text,
                Toast.LENGTH_SHORT).show();
    }

    public void dialogNotify(String title, String message) {
        //Put up the Yes/No message box
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    @Override
    public void onBackPressed() {
        if(getContentView()==loginPage || getContentView()==signupPage){
            setContentView(startPage);
        }else if (getContentView()==startPage){
            super.onBackPressed();
        }
    }

    @Override
    public void setContentView(View view){
        if (view instanceof MyRelativeLayout){
            currentView =view;
            super.setContentView(currentView);
        }
    }

    public View getContentView(){
        return currentView;
    }
}
