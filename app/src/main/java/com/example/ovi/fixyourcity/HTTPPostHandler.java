package com.example.ovi.fixyourcity;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ovi on 5/9/2018.
 */

public class HTTPPostHandler extends AsyncTask<String, Void, String> {

    public boolean userExists(User user) {
        String result = post("userExists", "Email=" + user.getEmail() + ", Pass="+user.getPassword());
        return result.toLowerCase().contains("true");
    }

    public void addNewUser(User user){
        post("addUser","Email="+user.getEmail()+", Password="+user.getPassword());
    }

    public User getUserByEmailAndPassword(String email, String password){
        String result=post("getUser","Email="+email+", Password="+password);
        return null;
    }

    public void addProblem(Problem problem){
        post("addProblem","Date="+problem.getDate()+", UserId="+problem.getUser().getId()+", Description="+problem.getDescription()+", Longitude="+problem.getLongitude()+", Latitude="+problem.getLatitude());
    }


    /*public void main(String[] args) {
        try {
            String body = post("http://192.168.43.233:8081/user/getUserName", "UserId=2");
            body=body.substring(body.indexOf("[")+3, body.indexOf("]")-2);
            body=body.replace("\"","");
            System.out.println(body);

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }*/

    public String post(String method, String data) {
        try {
            Log.e(method,data);
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

    protected void sendData(HttpURLConnection con, String data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
            Log.e("wr",data);
            wr.writeBytes(data);
            wr.flush();
            Log.e("wr",data);
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

    protected void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ex) {

        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
