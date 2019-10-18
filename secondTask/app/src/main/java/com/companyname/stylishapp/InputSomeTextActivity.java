package com.companyname.stylishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputSomeTextActivity extends AppCompatActivity {
    Button btn_input_ok;
    EditText input_mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_some_text);
        input_mood = findViewById(R.id.input_mood);
        btn_input_ok = findViewById(R.id.btn_input_ok);
        btn_input_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("mood", input_mood.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
