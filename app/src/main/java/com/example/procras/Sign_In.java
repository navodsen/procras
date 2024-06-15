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

public class Sign_In extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_scroll), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callWelcomeScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Welcome.class);

        // Ensure view is not null
        View transitionView = findViewById(R.id.login_back_button);
        if (transitionView != null) {
            Pair<View, String> pair = new Pair<>(transitionView, "transition_login_back");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
            startActivity(intent, options.toBundle());
        } else {
            // Fallback if the view is not found or null
            startActivity(intent);
        }
    }


    public void callDashboardScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Dashboard.class);

        // Find the view for the shared element transition
        View transitionView = findViewById(R.id.confirm_login_button);

        if (transitionView != null) {
            Pair<View, String> pair = new Pair<>(transitionView, "transition_confirm_login_button");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
            startActivity(intent, options.toBundle());
        } else {
            // Fallback if the view is not found or null
            startActivity(intent);
        }
    }

}