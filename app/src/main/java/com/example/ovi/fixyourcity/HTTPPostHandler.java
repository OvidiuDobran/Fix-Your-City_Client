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
import java.util.concurrent.ExecutionException;

/**
 * Created by Ovi on 5/9/2018.
 */

public class HTTPPostHandler extends AsyncTask<String, Void, String> {

    private String result;

    public boolean userExists(User user) {
        /*execute("userExists", "Data=Email=" + user.getEmail() + ";Password="+user.getPassword());
        Log.e("result=",result==null?"null":result);
        return result.toLowerCase().contains("true");*/
        if(result==null){
            try {
                result=execute("userExists", "Data=Email=" + user.getEmail() + ";Password="+user.getPassword()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return result.toLowerCase().contains("true");
        }else{
            return result.toLowerCase().contains("true");
        }


    }

    public void addNewUser(User user){
        Log.e("email:"+user.getEmail(),"password"+user.getPassword());
        execute("addUser","Data="+"Email="+user.getEmail()+";Password="+user.getPassword());
    }

    public User getUserByEmailAndPassword(String email, String password){
        Log.e("1","err");
        if(result==null){
            try {
                Log.e("2","err");
                result=execute("getUser","Data=Email="+email+";Password="+password).get();
                Log.e("3","err");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String [] results = result.substring(result.indexOf("{")).split(",");
            Log.e("err",results[0].substring(results[0].indexOf("Id")+4).trim());
            int id=Integer.parseInt(results[0].substring(results[0].indexOf("Id")+4).trim());
            return new User(id,email,password);
        }else{
            String [] results = result.substring(result.indexOf("{")).split(",");
            int id=Integer.parseInt(results[0].substring(results[0].indexOf(":")).trim());
            return new User(id,email,password);
        }
    }

    public void addProblem(Problem problem){
        execute("addProblem","Data=Date="+problem.getDate()+";UserId="+problem.getUser().getId()+";Description="+problem.getDescription()+";Longitude="+problem.getLongitude()+";Latitude="+problem.getLatitude());
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
        Log.e("content:",list.toString());

        Log.e("4","err");
        post(params[0],list);
        Log.e("5","err");


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
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setReadTimeout(2*1000);
            con.setDoOutput(true);


            Log.e("6","err");

            this.sendData(con, data);
            Log.e("7","err");

            result=this.read(con.getInputStream());
            Log.e("result",result);

            return result;
        } catch (IOException e) {
            return null;
        }
    }

    protected void sendData(HttpURLConnection con, List<String> data) throws IOException {
        DataOutputStream wr = null;
        try {
            Log.e("9","err");
            wr = new DataOutputStream(//
                     con.getOutputStream());
            Log.e("10","err");
            for(String s:data){
                wr.writeBytes(s);
            }
            Log.e("11","err");
            wr.flush();
            Log.e("12","err");
            wr.close();
        } catch (IOException exception) {
            exception.printStackTrace();
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



