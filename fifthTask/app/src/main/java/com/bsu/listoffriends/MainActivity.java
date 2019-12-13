package com.bsu.listoffriends;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import database.AppDatabase;
import database.User;
import database.UserDao;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private UserDao userDao;

    private EditText firstName;
    private EditText lastName;
    private TextView result;
    private EditText birthday;
    private Button searchBtn;
    private Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.firstName = findViewById(R.id.firstName);
        this.lastName = findViewById(R.id.lastName);
        this.result = findViewById(R.id.textView);
        this.birthday = findViewById(R.id.birthday);
        this.searchBtn = findViewById(R.id.searchBtn);
        this.addBtn = findViewById(R.id.addBtn);

        this.db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "users").allowMainThreadQueries().build();
        this.userDao = db.userDao();

        this.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(v);
            }
        });
        this.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser(v);
            }
        });

    }

    public void insertUser(View view) {
        User user = new User();
        user.setFirstName(this.firstName.getText().toString());
        user.setLastName(this.lastName.getText().toString());
        user.setDateOfBirth(this.birthday.getText().toString());
        userDao.insertAll(user);
    }

    public void select(View view) {
        String firstName = this.firstName.getText().toString();
        String lastName = this.lastName.getText().toString();
        result.setText((userDao.findByName(firstName, lastName)).toString());
    }

}
