package com.bsu.fragmentapp;

//import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;


public class MainActivity extends FragmentActivity {

    static final int PICK_MOOD_REQUEST = 1;
    Button button;
    TextView textViewMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.button = findViewById(R.id.btn_ok);
        this.button.setOnClickListener(new View.OnClickListener() {
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
                this.textViewMood = findViewById(R.id.textViewMood);
                this.textViewMood.setText(mood);
                EditText input_mood = findViewById(R.id.input_mood);
                input_mood.setVisibility(View.GONE);
            }
        }

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

