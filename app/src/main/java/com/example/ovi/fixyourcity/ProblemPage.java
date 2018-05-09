package com.example.ovi.fixyourcity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Ovi on 3/31/2018.
 */


public class ProblemPage extends MyRelativeLayout implements Refreshable{

    private Button sendButton;
    private EditText description;

    //TODO This Text View is only used to demonstrate the functionality of the GPS tracker. To be removed.
    private TextView coordinatesText;

    public ProblemPage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        TextView descriptionText=new TextView(getContext());
        descriptionText.setText("Describe the problem:");
        descriptionText.setTextColor(Color.BLACK);
        descriptionText.setTextSize(24);
        descriptionText.setId(Utils.generateId());
        RelativeLayout.LayoutParams descriptionTextDetails = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        descriptionTextDetails.addRule(ALIGN_PARENT_TOP);
        descriptionTextDetails.setMargins(20, 20, 0, 30);
        addView(descriptionText,descriptionTextDetails);

        description = new EditText(getContext());
        description.setMinLines(2);
        description.setMaxLines(2);
        description.setVerticalScrollBarEnabled(true);
        description.setId(Utils.generateId());
        RelativeLayout.LayoutParams descriptionDetails = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        descriptionDetails.addRule(BELOW, descriptionText.getId());
        descriptionDetails.addRule(ALIGN_PARENT_LEFT);
        descriptionDetails.addRule(ALIGN_PARENT_RIGHT);
        descriptionDetails.setMargins(30, 30, 30, 0);
        addView(description, descriptionDetails);

        sendButton = new Button(getContext());
        sendButton.setText("Send");
        sendButton.setId(Utils.generateId());
        RelativeLayout.LayoutParams sendButtonDetails = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        sendButtonDetails.addRule(CENTER_HORIZONTAL);
        sendButtonDetails.addRule(ALIGN_PARENT_BOTTOM);
        sendButtonDetails.setMargins(0, 0, 0, 100);
        addView(sendButton, sendButtonDetails);


        coordinatesText=new TextView(getContext());
        coordinatesText.setId(Utils.generateId());
        RelativeLayout.LayoutParams coordinatesDetails=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        coordinatesDetails.addRule(CENTER_HORIZONTAL);
        coordinatesDetails.addRule(BELOW,description.getId());
        coordinatesDetails.setMargins(0,50,0,0);
        addView(coordinatesText,coordinatesDetails);
    }

    @Override
    protected void addBehaviours() {
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().requestLocation();
                getMainActivity().problem.setDescription(description.getText().toString());
                getMainActivity().makeText("Notification sent");
                getMainActivity().setContentView(getMainActivity().continuePage);
                //TODO here will be a call to a method that will sent the data to the database



            }
        });
    }

    @Override
    public void refresh() {
        description.setText("");
        getMainActivity().requestLocation();
        String longitude = getMainActivity().problem.getLongitude();
        String latitude = getMainActivity().problem.getLatitude();
        coordinatesText.setText("Your coordinates: long="+longitude+"; lat="+ latitude);
    }


}
