package com.example.ovi.fixyourcity;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ovi on 5/9/2018.
 */

public class HTTPPostHandler extends AsyncTask<String, Void, String> {

    private String result;

    public boolean userExists(User user) {
        execute("userExists", "Email=" + user.getEmail() + ", Pass="+user.getPassword());
        return result.toLowerCase().contains("true");
    }

    public void addNewUser(User user){
        execute("addUser","Data="+"Email="+user.getEmail()+";Password="+user.getPassword());
    }

    public User getUserByEmailAndPassword(String email, String password){
        execute("getUser","Email="+email+", Password="+password);
        return null;
    }

    public void addProblem(Problem problem){
        execute("addProblem","Date="+problem.getDate(),"UserId="+problem.getUser().getId()+", Description="+problem.getDescription()+", Longitude="+problem.getLongitude()+", Latitude="+problem.getLatitude());
    }




    protected void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ex) {

        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        List <String>list=new ArrayList<String>();
        for (int i=1;i<params.length;i++){
            list.add(params[i]);
        }

        result=post(params[0],list);

        return result;




    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }

    public String post(String method, List<String> data) {
        try {
            String postUrl = "http://192.168.43.233:8081/user/"+method;
            URL url = new URL(postUrl);
            Log.e("URL","after new URL()");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            Log.e("con",con.toString());

            con.setDoOutput(true);

            Log.e("con",con.toString());

            this.sendData(con, data);

            return this.read(con.getInputStream());
        } catch (IOException e) {
            return null;
        }
    }

    protected void sendData(HttpURLConnection con, List<String> data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(//
                     con.getOutputStream());
            for(String s:data){
                wr.writeBytes(s);
            }
            wr.flush();
            wr.close();
        } catch (IOException exception) {
            throw exception;
        } finally {
            this.closeQuietly(wr);
        }
    }

    private String read(InputStream is) throws IOException {
        BufferedReader in = null;
        String inputLine;
        StringBuilder body;
        try {
            in = new BufferedReader(new InputStreamReader(is));

            body = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();

            return body.toString();
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.closeQuietly(in);
        }
    }
}



