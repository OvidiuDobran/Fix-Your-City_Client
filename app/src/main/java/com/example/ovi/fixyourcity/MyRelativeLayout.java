package com.example.ovi.fixyourcity;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by Ovi on 3/30/2018.
 */

public abstract class MyRelativeLayout extends RelativeLayout{
    public MyRelativeLayout(Context context) {
        super(context);
        createContent();
    }

    protected abstract void createContent();

}
