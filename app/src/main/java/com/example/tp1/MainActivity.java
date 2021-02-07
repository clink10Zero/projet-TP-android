package com.example.tp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button validation;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.validation = (Button) findViewById(R.id.validation);

        this.validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle("confirmation");

                alertDialogBuilder.setMessage("confirmer votre action")
                        .setCancelable(true)
                        .setPositiveButton("oui", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context, SecondeActivity.class);

                                EditText t = (EditText) findViewById(R.id.nameEditText);
                                String message = t.getText().toString();
                                intent.putExtra("name", message);

                                t = (EditText) findViewById(R.id.surnameEditText);
                                message = t.getText().toString();
                                intent.putExtra("surname", message);

                                t = (EditText) findViewById(R.id.ageEditText);
                                message = t.getText().toString();
                                intent.putExtra("age", message);

                                t = (EditText) findViewById(R.id.skillEditText);
                                message = t.getText().toString();
                                intent.putExtra("skill", message);

                                t = (EditText) findViewById(R.id.phoneEditText);
                                message = t.getText().toString();
                                intent.putExtra("phone", message);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("non", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"non !", Toast.LENGTH_LONG).show();
                            }
                        });

                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            }
        });

        /*
        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        EditText name = new EditText(this);
        name.setHint(R.string.nom);
        mainLayout.addView(name);

        EditText surname = new EditText(this);
        surname.setHint(R.string.prenom);
        mainLayout.addView(surname);

        EditText age = new EditText(this);
        age.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
        age.setHint(R.string.age);
        mainLayout.addView(age);

        EditText skills = new EditText(this);
        skills.setHint(R.string.comptence);
        mainLayout.addView(skills);

        EditText phone = new EditText(this);
        phone.setInputType(InputType.TYPE_CLASS_PHONE);
        phone.setHint(R.string.tel);
        mainLayout.addView(phone);

        Button validateButton = new Button(this);
        validateButton.setText(R.string.validate_button);
        mainLayout.addView(validateButton);
        */
    }
}