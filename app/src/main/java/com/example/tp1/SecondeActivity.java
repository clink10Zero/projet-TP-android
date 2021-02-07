package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondeActivity extends AppCompatActivity {

    final Context context = this;
    public String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);
        Intent intent = getIntent();

        String message = intent.getStringExtra("name");
        TextView t = (TextView) findViewById(R.id.nameTextView);
        t.setText(message);

        message = intent.getStringExtra("surname");
        t = (TextView) findViewById(R.id.surnameTextView);
        t.setText(message);

        message = intent.getStringExtra("age");
        t = (TextView) findViewById(R.id.ageTextView);
        t.setText(message);

        message = intent.getStringExtra("skill");
        t = (TextView) findViewById(R.id.skillTextView);
        t.setText(message);

        phone = intent.getStringExtra("phone");
        t = (TextView) findViewById(R.id.phoneTextView);
        t.setText(message);

        Button b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Activity3.class);

                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
    }
}