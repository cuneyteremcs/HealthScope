package com.example.user.firelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 7.7.2017.
 */

public class SuggestionActivity extends BarcodeMainActivity {

    static boolean woman = false, man = false;
    static boolean diabetes = false, hearthdisease = false, cholesterol = false, diet = false;
    static int age = 0;
    static double energy_100g = 0, proteins_100g = 0, fat_100g = 0, carbohydrates_100g = 0, sugars_100g = 0;
    static double height = 0.0, weight = 0.0;
    int energy = 0, proteins = 0, fat = 0, carbonhydrates = 0, sugars = 0;

    static TextView textView1;
    static TextView textView2;
    static TextView textView3;
    static TextView textView4;
    static TextView textView5;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference readData1;
    DatabaseReference readData2;
    DatabaseReference readData3;
    DatabaseReference readData4;
    DatabaseReference readData5boolean1;
    DatabaseReference readData6boolean2;
    DatabaseReference readData7boolean3;
    DatabaseReference readData8boolean4;
    DatabaseReference readData9boolean1;
    DatabaseReference readData10boolean2;
    RadioButton radio1;
    RadioButton radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        textView1 = findViewById(R.id.textEdit1);
        textView2 = findViewById(R.id.textEdit2);
        textView3 = findViewById(R.id.textEdit3);
        textView4 = findViewById(R.id.textEdit4);
        textView5 = findViewById(R.id.textEdit5);

        /*
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String savedString = sharedPref.getString("StringValue", "none");

        textView3 = findViewById(R.id.textEdit3);
        textView3.setText(savedString);

        */


        readData1 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("nameAndSurname");
        readData1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData2 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("age");
        readData2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                age = Integer.parseInt(value);
                Log.v("data age", ""+ age);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData3 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("height");
        readData3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                height = Double.parseDouble(value);
                Log.v("data height", ""+ height);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData4 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("weight");
        readData4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                weight = Double.parseDouble(value);
                Log.v("data weight", ""+ weight);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData5boolean1 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("diabetes");
        readData5boolean1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();
                //checkBox1 = findViewById(R.id.checkBox1);
                if(checkStatus != null) {
                    diabetes = checkStatus;
                    Log.v("data diabetes", ""+ diabetes);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData6boolean2 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("heathdisease");
        readData6boolean2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();
                //CheckBox checkBox2 = findViewById(R.id.checkBox2);
                if(checkStatus != null) {
                    hearthdisease = checkStatus;
                    Log.v("data hearthdisease", ""+ hearthdisease);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData7boolean3 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("cholesterol");
        readData7boolean3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();
                //CheckBox checkBox3 = findViewById(R.id.checkBox3);
                if(checkStatus != null) {
                    cholesterol = checkStatus;
                    Log.v("data cholesterol", ""+ cholesterol);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData8boolean4 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("diet");
        readData8boolean4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();
                //CheckBox checkBox4 = findViewById(R.id.checkBox4);
                if(checkStatus != null) {
                    diet = checkStatus;
                    Log.v("data diet", ""+ diet);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData9boolean1 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("female");
        readData9boolean1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();

                if(checkStatus != null) {
                    woman = checkStatus;
                    Log.v("data woman", ""+ woman);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        readData10boolean2 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("male");
        readData10boolean2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Boolean checkStatus = (Boolean) dataSnapshot.getValue();

                if(checkStatus != null) {
                    man = checkStatus;
                    Log.v("data man", ""+ man);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        /*

        SharedPreferences sp = getSharedPreferences("key", 0);
        String tValue = sp.getString("name1","");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        subeAdi = sharedPref.getString("name1", "Not Available");

        */

        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SuggestionActivity.this, BarcodeMainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SuggestionActivity.this, MainMenu.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = resultCode;
                    Product product = HttpHelper.GetProduct(result); //resultCode
                    String value = product.GetProteinIn100g();
                    proteins_100g = Double.parseDouble(value);
                    Log.v("data proteins_100g", ""+proteins_100g);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = resultCode;
                    Product product = HttpHelper.GetProduct(result); //resultCode
                    String value = product.GetCarbonhydrateIn100g();
                    carbohydrates_100g = Double.parseDouble(value);
                    Log.v("data carbohydrates_100g", ""+carbohydrates_100g);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = resultCode;
                    Product product = HttpHelper.GetProduct(result); //resultCode
                    String value = product.GetEnergyIn100g();
                    energy_100g = Double.parseDouble(value);
                    Log.v("data energy_100g", ""+energy_100g);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = resultCode;
                    Product product = HttpHelper.GetProduct(result); //resultCode
                    String value = product.GetFatIn100g();
                    fat_100g = Double.parseDouble(value);
                    Log.v("data fat_100g", ""+fat_100g);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = resultCode;
                    Product product = HttpHelper.GetProduct(result); //resultCode
                    String value = product.GetSugarsIn100g();
                    sugars_100g = Double.parseDouble(value);
                    Log.v("data sugars_100g", ""+sugars_100g);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread5.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(age < 18 || age >= 80) {

                } else if (age >= 18 && age < 32) {

                } else if (age >= 32 && age < 55) {
                    energy += 1;
                    proteins += 1;
                    fat += 1;
                    carbonhydrates += 1;
                    sugars += 1;
                } else {
                    energy += 2;
                    proteins += 2;
                    fat += 2;
                    carbonhydrates += 2;
                    sugars += 2;
                }


                if (weight / (height * height) < 20.0) {
                    energy -= 1;
                    proteins -= 1;
                    fat -= 1;
                    carbonhydrates -= 1;
                    sugars -= 1;
                } else if (weight / (height * height) > 30.0) {
                    energy += 1;
                    proteins += 1;
                    fat += 1;
                    carbonhydrates += 1;
                    sugars += 1;
                }


                if (diabetes) {
                    carbonhydrates += 2;
                    sugars += 2;
                }
                if (hearthdisease) {
                    fat += 2;
                    carbonhydrates += 2;
                }
                if (cholesterol) {
                    fat += 2;
                }
                if (diet) {
                    if (!(weight / (height * height) < 20.0))
                        fat += 2;
                    sugars += 2;
                }

                energy += energy_100g / 420;
                proteins += (proteins_100g * 100 / 80) / 10;
                fat += (fat_100g * 100 / 80) / 10;
                carbonhydrates += carbohydrates_100g / 20;
                sugars += sugars_100g / 10;

                if(woman == true) {
                    energy += 1;
                    proteins += 1;
                    fat += 1;
                    carbonhydrates += 1;
                    sugars += 1;
                }

                Log.v("last message", "degerler: " + energy + " " + proteins + " " + fat + " " + carbonhydrates + " " + sugars + " ");

                textView1.setText(""+energy);
                textView2.setText(""+proteins);
                textView3.setText(""+fat);
                textView4.setText(""+carbonhydrates);
                textView5.setText(""+sugars);

            }
        }, 4000);
    }

    public static void regulator(int age) {

    }
}

