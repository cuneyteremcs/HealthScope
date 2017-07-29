package com.example.user.firelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by USER on 7.7.2017.
 */

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference writeData1;
    DatabaseReference writeData2;
    DatabaseReference writeData3;
    DatabaseReference writeData4;
    DatabaseReference writeData5;
    DatabaseReference writeData6;
    DatabaseReference writeData7;
    DatabaseReference writeData8;
    DatabaseReference writeData9;
    DatabaseReference writeData10;
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
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    static boolean checked1;
    static boolean checked2;
    static boolean checked3;
    static boolean checked4;
    //for gender
    static boolean checked5;
    static boolean checked6;

    RadioButton radio1;
    RadioButton radio2;
    TextView textView1;
    TextView textView2;

    //SharedPreferences sharedPref, sharedPref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        radio1 = findViewById(R.id.female);
        radio2 = findViewById(R.id.male);

        Button buttonBack = findViewById(R.id.button1);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(ProfileActivity.this, MainMenu.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        readData1 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("nameAndSurname");
        readData1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                textView1 = findViewById(R.id.textView1);
                textView1.setText(value);
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
                textView2 = findViewById(R.id.textView2);
                textView2.setText(value);
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
                TextView textView3 = findViewById(R.id.textView3);
                textView3.setText(value);
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
                TextView textView4 = findViewById(R.id.textView4);
                textView4.setText(value);
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
                CheckBox checkBox1 = findViewById(R.id.checkBox1);
                if(checkStatus != null)
                    checkBox1.setChecked(checkStatus);
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
                CheckBox checkBox2 = findViewById(R.id.checkBox2);
                if(checkStatus != null)
                    checkBox2.setChecked(checkStatus);
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
                CheckBox checkBox3 = findViewById(R.id.checkBox3);
                if(checkStatus != null)
                    checkBox3.setChecked(checkStatus);
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
                CheckBox checkBox4 = findViewById(R.id.checkBox4);
                if(checkStatus != null)
                    checkBox4.setChecked(checkStatus);
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

                if(checkStatus != null)
                    radio1.setChecked(checkStatus);
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

                if(checkStatus != null)
                    radio2.setChecked(checkStatus);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        Button save = findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText1 = findViewById(R.id.editText1);
                writeData1 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("nameAndSurname");
                if(!editText1.getText().toString().equals("")) {
                    writeData1.setValue(editText1.getText().toString());
                }

                EditText editText2 = findViewById(R.id.editText2);
                writeData2 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("age");
                if(!editText2.getText().toString().equals(""))
                    writeData2.setValue(editText2.getText().toString());

                EditText editText3 = findViewById(R.id.editText3);
                writeData3 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("height");
                if(!editText3.getText().toString().equals(""))
                    writeData3.setValue(editText3.getText().toString());

                EditText editText4 = findViewById(R.id.editText4);
                writeData4 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("weight");
                if(!editText4.getText().toString().equals(""))
                    writeData4.setValue(editText4.getText().toString());

                CheckBox checkBox1 = findViewById(R.id.checkBox1);
                checkBox1.setOnClickListener(checkboxClickListener1);
                writeData5 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("diabetes");
                writeData5.setValue(checked1);

                CheckBox checkBox2 = findViewById(R.id.checkBox2);
                checkBox2.setOnClickListener(checkboxClickListener2);
                writeData6 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("heathdisease");
                writeData6.setValue(checked2);

                CheckBox checkBox3 = findViewById(R.id.checkBox3);
                checkBox3.setOnClickListener(checkboxClickListener3);
                writeData7 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("cholesterol");
                writeData7.setValue(checked3);

                CheckBox checkBox4 = findViewById(R.id.checkBox4);
                checkBox4.setOnClickListener(checkboxClickListener4);
                writeData8 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("diet");
                writeData8.setValue(checked4);

                radio1.setOnClickListener(radiobuttonClickListener5);
                writeData9 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("female");
                writeData9.setValue(checked5);

                radio2.setOnClickListener(radiobuttonClickListener5);
                writeData10 = FirebaseDatabase.getInstance().getReference(user.getUid()).child("male");
                writeData10.setValue(checked6);
            }
        });

        /*
        sharedPref = getSharedPreferences("key", 0);
        SharedPreferences.Editor sedt = sharedPref.edit();
        sedt.putString("name1", textView1.getText().toString());
        sedt.commit();

        */

    }

    @Override
    public void onBackPressed() {
        // Otherwise defer to system default behavior.
        super.onBackPressed();
    }

    View.OnClickListener checkboxClickListener1 = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            checked1 = ((CheckBox) view).isChecked();
        }
    };

    View.OnClickListener checkboxClickListener2 = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            checked2 = ((CheckBox) view).isChecked();
        }
    };

    View.OnClickListener checkboxClickListener3 = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            checked3 = ((CheckBox) view).isChecked();
        }
    };

    View.OnClickListener checkboxClickListener4 = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            checked4 = ((CheckBox) view).isChecked();
        }
    };

    android.view.View.OnClickListener radiobuttonClickListener5 = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            boolean checked = ((RadioButton) view).isChecked();

            switch(view.getId()) {
                case R.id.female:
                    if (checked) {
                        checked5 = true;
                        checked6 = false;
                        break;
                    }
                case R.id.male:
                    if (checked) {
                        checked6 = true;
                        checked5 = false;
                        break;
                    }
            }
        }
    };

}



