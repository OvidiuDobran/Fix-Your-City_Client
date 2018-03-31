package com.example.ovi.fixyourcity;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Ovi on 3/31/2018.
 */


public class ProblemPage extends MyRelativeLayout {

    private TextView textView;

    public ProblemPage(Context context) {
        super(context);
    }

    @Override
    protected void createContent() {
        textView=new TextView(getContext());
        addView(textView);
    }

    @Override
    protected void addBehaviours() {

    }

    public TextView getTextView() {
        return textView;
    }

}
