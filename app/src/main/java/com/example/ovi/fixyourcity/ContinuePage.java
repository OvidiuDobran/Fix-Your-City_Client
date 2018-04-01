package com.example.ovi.fixyourcity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ovi on 4/1/2018.
 */

public class ContinuePage extends MyRelativeLayout {
    private int buttonWidth=40;
    private TextView continueText;
    private Button exit;
    private Button sendAnother;

    public ContinuePage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        continueText = new TextView(getContext());
        continueText.setText("Thank you for notifying us about the problems in the city! You will receive an email with the status of the problem.");
        continueText.setTextColor(Color.BLACK);
        continueText.setTextSize(24);
        continueText.setId(Utils.generateId());
        RelativeLayout.LayoutParams continueTextDetails = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        continueTextDetails.addRule(ALIGN_PARENT_TOP);
        continueTextDetails.addRule(ALIGN_PARENT_RIGHT);
        continueTextDetails.addRule(ALIGN_PARENT_LEFT);
        continueTextDetails.setMargins(30,30,30,0);
        addView(continueText,continueTextDetails);


        exit = new Button(getContext());
        exit.setText("Exit");
        exit.setId(Utils.generateId());
        RelativeLayout.LayoutParams exitDetails = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        exitDetails.addRule(ALIGN_PARENT_BOTTOM);
        exitDetails.addRule(CENTER_HORIZONTAL);
        exitDetails.addRule(ALIGN_PARENT_RIGHT);
        exitDetails.addRule(ALIGN_PARENT_LEFT);
        exitDetails.setMargins(60,0,60,100);
        addView(exit,exitDetails);

        sendAnother = new Button(getContext());
        sendAnother.setText("Send Another");
        sendAnother.setId(Utils.generateId());
        RelativeLayout.LayoutParams sendDetails = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        sendDetails.addRule(ABOVE,exit.getId());
        sendDetails.addRule(CENTER_HORIZONTAL);
        sendDetails.addRule(ALIGN_PARENT_RIGHT);
        sendDetails.addRule(ALIGN_PARENT_LEFT);
        sendDetails.setMargins(60,0,60,50);
        addView(sendAnother,sendDetails);

    }

    @Override
    protected void addBehaviours() {
        sendAnother.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().setContentView(getMainActivity().problemPage);
            }
        });

        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
