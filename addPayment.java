package com.floridia.maurizio.myemptypocket;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.time.LocalDateTime;

public class addPayment extends AppCompatActivity {

    DatabaseReference db;
    FirebaseAuth mAuth;

    EditText location;
    EditText price;
    Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        location = findViewById(R.id.placeAddPayment);
        price = findViewById(R.id.priceAddPayment);
        upload = findViewById(R.id.buttonAddPayment);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPyament();
                finish();
            }
        });

    }

    public void uploadPyament(){

        if(location.getText() != null && price.getText() != null) {
            String loc = location.getText().toString();
            Float p = Float.parseFloat(price.getText().toString());

            Payment payment = new Payment(loc, p);

            mAuth = FirebaseAuth.getInstance();
            LocalDateTime timeStamp = java.time.LocalDateTime.now();
            String timestampPayment = Integer.toString(timeStamp.getHour())+":"+Integer.toString(timeStamp.getMinute()) + ":" + Integer.toString(timeStamp.getSecond());

            db = FirebaseDatabase.getInstance().getReference("users/" + mAuth.getUid() + "/payments/"
                    + Integer.toString(timeStamp.getYear())+ "/"
                    + timeStamp.getMonth().toString().toLowerCase() + "/"
                    + Integer.toString(timeStamp.getDayOfMonth()).toLowerCase() + "/"
                    + timestampPayment);
            db.setValue(payment);
        }else{
            //Snackbar.make(findViewById(R.id.), "You have to insert data.", Snackbar.LENGTH_SHORT).show();
            Log.d("ErrorParameters", "Something was wrong");
        }
    }
}
