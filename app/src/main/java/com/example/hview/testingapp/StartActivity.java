package com.example.hview.testingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {
    Button login, register;
    FirebaseUser firebaseUser;

    ProgressDialog pDialog = null;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //if use is null
        if (firebaseUser != null){
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
//        pDialog = new ProgressDialog(StartActivity.this);
//        pDialog.setMessage("loarding...");



        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pDialog.show();
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
//                pDialog.hide();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*pDialog.show();*/
                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
//                pDialog.hide();
            }
        });

    }
}
