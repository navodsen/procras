package com.example.procras;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_scroll), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void callLoginScreen(View view) {
        // Ensure you're using the correct context and activity references
        Intent intent = new Intent(getApplicationContext(), Sign_In.class);

        // Set up the shared element transition
        Pair<View, String> pairs = new Pair<>(view, "transition_login");

        // Create activity options for the transition
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);

        // Start the activity with the transition options
        startActivity(intent, options.toBundle());
    }

    public void callSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Sign_up.class);

        // Use the clicked view for the shared element transition
        Pair<View, String> pair = new Pair<>(view, "transition_signup");

        // Create activity options for the transition
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);

        // Start the activity with the transition options
        startActivity(intent, options.toBundle());
    }


}