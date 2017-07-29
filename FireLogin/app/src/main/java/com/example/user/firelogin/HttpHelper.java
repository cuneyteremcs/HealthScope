package com.example.user.firelogin;

/**
 * Created by USER on 26.7.2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import static android.content.Context.MODE_PRIVATE;

public class HttpHelper extends AppCompatActivity {

    /*

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("StringValue", "naberererer");
        editor.commit();
    }

    */


    public static Product GetProduct(String barcode) throws Exception {
        BufferedReader in = null;
        Gson gson = new Gson();
        String data = null;
        HttpClient httpclient = new DefaultHttpClient();

        HttpGet request = new HttpGet();
        URI website = new URI("http://192.168.200.90:99/api/products/"+barcode);
        request.setURI(website);
        HttpResponse response = httpclient.execute(request);
        in = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        String line = in.readLine();
        Product prod = gson.fromJson(line, Product.class);

        String proteins_100gValue=prod.nutriments.get("proteins_100g");
        String carbonhydrates_100gValue= prod.nutriments.get("carbohydrates_100g");
        String energy_100gValue=prod.nutriments.get("energy_100g");
        String sugars_100gValue= prod.nutriments.get("sugars_100g");
        String fat_100gValue=prod.nutriments.get("fat_100g");

        //proteins_100gValue="dasdasd";


        ;

        /*

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("StringValue", "naberererer");
        editor.commit();

        */

        if (prod != null)
            return prod;
        else
            return new Product();
    }

    /*

    public static User GetUserProfile(String username) throws Exception {
        BufferedReader in = null;
        Gson gson = new Gson();
        String data = null;
        HttpClient httpclient = new DefaultHttpClient();

        HttpGet request = new HttpGet();

        URI website = new URI("https://firelogin-135d7.firebaseio.com/"+username+".json");//"http://192.168.200.90:99/api/Users/"+username);
        request.setURI(website);
        HttpResponse response = httpclient.execute(request);
        in = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        String line = in.readLine();
        User user = gson.fromJson(line, User.class);


        if (user != null)
            return user;
        else
            return new User();
    }

    */

}
