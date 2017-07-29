package com.example.user.firelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by USER on 7.7.2017.
 */

public class BarcodeMainActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;
    static String resultCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_barcodemain);

        //Intent i= new Intent(BarcodeMainActivity.this, SuggestionActivity.class);
        //startActivity(i);

        scanCode(scannerView);
    }

    public void scanCode(View view) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());

        setContentView(scannerView);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler {
        @Override
        public void handleResult(final Result result) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        resultCode = result.getText();

                        Log.v("valueee", ""+resultCode);

                        /*
                        Product product = HttpHelper.GetProduct(resultCode); //resultCode
                        String value = product.GetProteinIn100g();

                        Log.v("valueee", ""+value);

                        */

                        scannerView.stopCamera();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

            Intent i = new Intent(BarcodeMainActivity.this, SuggestionActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

        public String GET(String url) {

            return "json";
            /*InputStream inputStream = null;
            String result = "";
            try {

                // create HttpClient
                HttpClient httpclient = new DefaultHttpClient();

                // make GET request to the given URL
                HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

                // receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // convert inputstream to string
                if(inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return result;*/
        }

        public Product GetProduct(String barcode) {
            String apiUrl = "http://localhost:61667/api/products/" + barcode;
            String jsonResult = GET(apiUrl);
            Gson gson = new Gson();
            return gson.fromJson(jsonResult, Product.class);

        }

    }
}
