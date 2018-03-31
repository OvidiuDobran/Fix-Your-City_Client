package com.example.ovi.fixyourcity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ovi on 3/30/2018.
 */

class SignupPage extends MyRelativeLayout {
    protected Button signupButton;
    protected EditText emailEditText;
    protected EditText password1EditText;
    protected EditText password2EditText;
    protected boolean emailEntered = false;
    protected boolean password1Entered = false;
    protected boolean password2Entered = false;

    public SignupPage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        {
            signupButton = new Button(getContext());
            signupButton.setText("Sign Up");
            signupButton.setId(Utils.generateId());
            RelativeLayout.LayoutParams signupLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            signupLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
            signupLayoutParams.addRule(CENTER_HORIZONTAL);
            signupLayoutParams.setMargins(0, 0, 0, 100);
            addView(signupButton, signupLayoutParams);

            password2EditText = new EditText(getContext());
            password2EditText.setText("Confirm Password");
            password2EditText.setId(Utils.generateId());
            //passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            password2EditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            RelativeLayout.LayoutParams password2LayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            password2LayoutParams.addRule(ABOVE, signupButton.getId());
            password2LayoutParams.addRule(ALIGN_PARENT_LEFT);
            password2LayoutParams.addRule(ALIGN_PARENT_RIGHT);
            password2LayoutParams.addRule(CENTER_HORIZONTAL);
            password2LayoutParams.setMargins(80, 0, 80, 50);
            addView(password2EditText, password2LayoutParams);

            password1EditText = new EditText(getContext());
            password1EditText.setText("Password");
            password1EditText.setId(Utils.generateId());
            password1EditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            RelativeLayout.LayoutParams password1LayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            password1LayoutParams.addRule(ABOVE, password2EditText.getId());
            password1LayoutParams.addRule(ALIGN_PARENT_LEFT);
            password1LayoutParams.addRule(ALIGN_PARENT_RIGHT);
            password1LayoutParams.addRule(CENTER_HORIZONTAL);
            password1LayoutParams.setMargins(80, 0, 80, 50);
            addView(password1EditText, password1LayoutParams);

            emailEditText = new EditText(getContext());
            emailEditText.setText("Email");
            emailEditText.setId(Utils.generateId());
            emailEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            RelativeLayout.LayoutParams emailLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            emailLayoutParams.addRule(ABOVE, password1EditText.getId());
            emailLayoutParams.addRule(ALIGN_PARENT_LEFT);
            emailLayoutParams.addRule(ALIGN_PARENT_RIGHT);
            emailLayoutParams.addRule(CENTER_HORIZONTAL);
            emailLayoutParams.setMargins(80, 0, 80, 50);
            addView(emailEditText, emailLayoutParams);

            TextView signupText = new TextView(getContext());
            signupText.setText("Sign Up");
            signupText.setTextSize(25);
            signupText.setTextColor(Color.BLACK);
            signupText.setId(Utils.generateId());
            RelativeLayout.LayoutParams signupTextLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            signupTextLayoutParams.addRule(ALIGN_PARENT_TOP);
            signupTextLayoutParams.addRule(CENTER_HORIZONTAL);
            signupTextLayoutParams.setMargins(0, 0, 0, 30);
            addView(signupText, signupTextLayoutParams);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
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
                            password1EditText.setText("");
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


        password1EditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                password1EditText.setText("");
                InputMethodManager imm = (InputMethodManager)
                        getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password1EditText,
                        InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        password1EditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            password2EditText.setText("");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        password1EditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                password1Entered = true;
            }
        });

        password2EditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                password2EditText.setText("");
                InputMethodManager imm = (InputMethodManager)
                        getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password2EditText,
                        InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        password2EditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                password2Entered = true;
            }
        });

        signupButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((emailEditText.getText().length() == 0) || (!emailEntered) ||
                        (password1EditText.getText().length() == 0) || (!password1Entered) ||
                        (password2EditText.getText().length() == 0) || (!password2Entered)) {
                    getMainActivity().dialogNotify("Email and password required", "You need to enter an email address and a password");
                } else if (!password2EditText.getText().toString().equals(password1EditText.getText().toString())) {
                    getMainActivity().dialogNotify("Confirm password", "The confirmed password does't match");
                } else {
                    getMainActivity().makeText("Account created");
                    getMainActivity().setContentView(getMainActivity().startPage);
                }


            }
        });


    }


}
