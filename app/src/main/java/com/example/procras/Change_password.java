package com.example.procras;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callWelcomeScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Welcome.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View,String>(findViewById(R.id.change_password_back_button),"transition_login_back");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Change_password.this,pairs);
        startActivity(intent,options.toBundle());
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Sign_In.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View,String>(findViewById(R.id.confirm_change_password_button),"transition_confirm_change_password");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Change_password.this,pairs);
        startActivity(intent,options.toBundle());
    }
}