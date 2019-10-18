package com.companyname.stylishapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int PICK_MOOD_REQUEST = 1;
    Button button;
    TextView textViewMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMood = findViewById(R.id.textViewMood);
        button = findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InputSomeTextActivity.class);
                startActivityForResult(intent, PICK_MOOD_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_MOOD_REQUEST) {
            if (resultCode == RESULT_OK) {
                String mood = data.getStringExtra("mood");
                textViewMood.setText(mood);
            }
        }

    }
}
