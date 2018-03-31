package com.example.ovi.fixyourcity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected StartPage startPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected ProblemPage problemPage;
    protected View currentView;
    private LocationManager locationManager;
    protected User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPage = new StartPage(this);
        loginPage = new LoginPage(this);
        signupPage = new SignupPage(this);
        problemPage = new ProblemPage(this);
        user=new User();

        setContentView(startPage);

    }

    public void requestLocation(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        user.setLongitude(location.getLongitude());
        user.setLatitude(location.getLatitude());
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
