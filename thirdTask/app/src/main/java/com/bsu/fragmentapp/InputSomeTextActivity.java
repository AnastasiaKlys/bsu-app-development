package com.bsu.fragmentapp;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputSomeTextActivity extends AppCompatActivity {
    Button btn_ok;
    EditText input_mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_some_text);
        input_mood = findViewById(R.id.input_mood);
        btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("mood", input_mood.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.exit:
                ExitDialog exitDialog = new ExitDialog();
                exitDialog.show(getSupportFragmentManager(), "ExitDialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
