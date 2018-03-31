package com.example.ovi.fixyourcity;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ovi on 3/29/2018.
 */

class LoginPage extends MyRelativeLayout {
    protected Button loginButton;
    protected EditText emailEditText;
    protected EditText passwordEditText;
    protected boolean emailEntered = false;
    protected boolean passwordEntered = false;

    public LoginPage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        loginButton = new Button(getContext());
        loginButton.setText("Log In");
        loginButton.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        loginLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
        loginLayoutParams.addRule(CENTER_HORIZONTAL);
        loginLayoutParams.setMargins(0, 0, 0, 100);
        addView(loginButton, loginLayoutParams);

        passwordEditText = new EditText(getContext());
        passwordEditText.setText("Password");
        passwordEditText.setId(Utils.generateId());
        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        RelativeLayout.LayoutParams passwordLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordLayoutParams.addRule(ABOVE, loginButton.getId());
        passwordLayoutParams.addRule(ALIGN_PARENT_LEFT);
        passwordLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        passwordLayoutParams.addRule(CENTER_HORIZONTAL);
        passwordLayoutParams.setMargins(80, 0, 80, 50);
        addView(passwordEditText, passwordLayoutParams);

        emailEditText = new EditText(getContext());
        emailEditText.setText("Email");
        emailEditText.setId(Utils.generateId());
        emailEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        RelativeLayout.LayoutParams emailLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        emailLayoutParams.addRule(ABOVE, passwordEditText.getId());
        emailLayoutParams.addRule(ALIGN_PARENT_LEFT);
        emailLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        emailLayoutParams.addRule(CENTER_HORIZONTAL);
        emailLayoutParams.setMargins(80, 0, 80, 50);
        addView(emailEditText, emailLayoutParams);

        TextView loginText = new TextView(getContext());
        loginText.setText("Log In");
        loginText.setTextSize(25);
        loginText.setTextColor(Color.BLACK);
        loginText.setId(Utils.generateId());
        RelativeLayout.LayoutParams loginTextLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        loginTextLayoutParams.addRule(ALIGN_PARENT_TOP);
        loginTextLayoutParams.addRule(ALIGN_PARENT_LEFT);
        loginTextLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        loginTextLayoutParams.addRule(CENTER_HORIZONTAL);
        loginTextLayoutParams.setMargins(80, 0, 80, 30);
        addView(loginText, loginTextLayoutParams);
    }

    @Override
    protected void addBehaviours() {
        emailEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                emailEditText.setText("");
                InputMethodManager imm = (InputMethodManager)
                        getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(emailEditText,
                        InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        emailEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            passwordEditText.setText("");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        emailEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                emailEntered = true;
            }
        });


        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                passwordEditText.setText("");
                InputMethodManager imm = (InputMethodManager)
                        getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(passwordEditText,
                        InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        passwordEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                passwordEntered = true;
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((emailEditText.getText().length() == 0) || (!emailEntered) ||
                        (passwordEditText.getText().length() == 0) || (!passwordEntered)) {
                    getMainActivity().dialogNotify("Email and password required", "You need to enter an email address and a password");
                }  else {
                    getMainActivity().makeText("Logged In");
                    getMainActivity().user.setEmail(emailEditText.getText().toString());
                    getMainActivity().user.setPassword(passwordEditText.getText().toString());
                    getMainActivity().setContentView(getMainActivity().problemPage);
                }


            }
        });

    }

}
