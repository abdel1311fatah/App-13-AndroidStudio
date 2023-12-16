package com.example.app13_2023_24;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText adreça;
    private RadioButton blue;
    private RadioButton red;
    private RadioButton green;
    private RadioButton r14;
    private RadioButton r18;
    private RadioButton r22;
    private RadioButton r26;
    private RadioButton r32;
    private ConstraintLayout constraintLayout;
    private int colorPantalla = Color.WHITE;
    private int fontTexte = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constraintLayout);
        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextmailAddress);
        adreça = (EditText) findViewById(R.id.editTextAdreça);
        blue = (RadioButton) findViewById(R.id.rbBlue);
        red = (RadioButton) findViewById(R.id.rbRed);
        green = (RadioButton) findViewById(R.id.rbGreen);
        r14 = (RadioButton) findViewById(R.id.rb14);
        r18 = (RadioButton) findViewById(R.id.rb18);
        r22 = (RadioButton) findViewById(R.id.rb22);
        r26 = (RadioButton) findViewById(R.id.rb26);
        r32 = (RadioButton) findViewById(R.id.rb32);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void color(View view) {

        // https://www.htcmania.com/showthread.php?t=338533
        try {
            if (blue.isChecked()) {
                colorPantalla = Color.BLUE;
                constraintLayout.setBackgroundColor(colorPantalla);
            } else if (red.isChecked()) {
                colorPantalla = Color.RED;
                constraintLayout.setBackgroundColor(colorPantalla);
            } else if (green.isChecked()) {
                colorPantalla = Color.GREEN;
                constraintLayout.setBackgroundColor(colorPantalla);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    public void font(View view) {

        try {
            if (r14.isChecked()) {
                fontTexte = 14;
                name.setTextSize(fontTexte);
                email.setTextSize(fontTexte);
                adreça.setTextSize(fontTexte);
            } else if (r18.isChecked()) {
                fontTexte = 18;
                name.setTextSize(fontTexte);
                email.setTextSize(fontTexte);
                adreça.setTextSize(fontTexte);
            } else if (r22.isChecked()) {
                fontTexte = 22;
                name.setTextSize(fontTexte);
                email.setTextSize(fontTexte);
                adreça.setTextSize(fontTexte);
            } else if (r26.isChecked()) {
                fontTexte = 26;
                name.setTextSize(fontTexte);
                email.setTextSize(fontTexte);
                adreça.setTextSize(fontTexte);
            } else if (r32.isChecked()) {
                fontTexte = 32;
                name.setTextSize(fontTexte);
                email.setTextSize(fontTexte);
                adreça.setTextSize(fontTexte);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void save(View view){
        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String nom = name.getText().toString();
        String correu = email.getText().toString();
        String direccio = adreça.getText().toString();
        int colorines = colorPantalla;
        int font = fontTexte;
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nom);
        editor.putString("correu",correu);
        editor.putString("adreça", direccio);
        editor.putInt("colors", colorines);
        editor.putInt("font", font);
        editor.commit();
    }

    public void recover(View view){
        SharedPreferences preferences = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String nom = preferences.getString("user","");
        String correu = preferences.getString("correu","");
        String direccio = preferences.getString("adreça","");
        int color = preferences.getInt("colors",Color.WHITE);
        int font = preferences.getInt("font",12);
        name.setText(nom);
        email.setText(correu);
        adreça.setText(direccio);
        constraintLayout.setBackgroundColor(color);
        name.setTextSize(font);
        email.setTextSize(font);
        adreça.setTextSize(font);

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", nom);
        intent.putExtra("useremail", correu);
        intent.putExtra("useradress", direccio);
        intent.putExtra("usercolor", color);
        intent.putExtra("userfont", font);
        startActivity(intent);

    }

    public void exit(View view) {
        finish();
        System.exit(0);
        // https://stackoverflow.com/questions/6014028/closing-application-with-exit-button
    }
}