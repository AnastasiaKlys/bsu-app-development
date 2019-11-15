package com.bsu.services_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputNum;
    private Button btn_ok;
    private TextView textScrollView;
    private TextView textStringView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputNum = findViewById(R.id.inputNum);
        this.btn_ok = findViewById(R.id.btn_ok);
        this.textScrollView = findViewById(R.id.textScrollView);
        this.textStringView = findViewById(R.id.textStringView);

        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, new IntentFilter("MainActivity"));


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainIntentService.class);
                intent.putExtra("number",Integer.valueOf(inputNum.getText().toString()));
                btn_ok.setEnabled(false);
                startService(intent);

            }
        });



    }
    BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int amountOfPrimeNumbers = intent.getIntExtra("amountOfPrimeNumbers", 0);
            String listOfPrimeNumbers = intent.getStringExtra("listOfPrimeNumbers");


            textScrollView.setText(listOfPrimeNumbers);
            textStringView.setText(Integer.toString(amountOfPrimeNumbers));
            btn_ok.setEnabled(true);
        }
    };
}
