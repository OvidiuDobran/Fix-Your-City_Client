package com.example.ovi.fixyourcity;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by Ovi on 3/30/2018.
 */

public abstract class MyRelativeLayout extends RelativeLayout {
    private MainActivity mainActivity;

    public MyRelativeLayout(Context context) {
        super(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
        createContent();
        addBehaviours();
    }

    protected abstract void createContent();

    protected abstract void addBehaviours();

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
