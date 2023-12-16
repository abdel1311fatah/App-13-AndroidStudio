package com.example.app13_2023_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        constraintLayout = findViewById(R.id.constraintLayout);
        Intent intent = getIntent();
        TextView name = findViewById(R.id.userName);
        TextView email = findViewById(R.id.email);
        TextView adress = findViewById(R.id.userAdress);

        String nom = intent.getStringExtra("username");
        String correu = intent.getStringExtra("useremail");
        String adreça = intent.getStringExtra("useradress");
        int color = intent.getIntExtra("usercolor", Color.WHITE); // per defecte li fiquem blanc
        int font = intent.getIntExtra("userfont", 12);
        name.setText(nom);
        email.setText(correu);
        adress.setText(adreça);
        constraintLayout.setBackgroundColor(color);
        name.setTextSize(font);
        email.setTextSize(font);
        adress.setTextSize(font);
    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}