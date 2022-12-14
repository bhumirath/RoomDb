package com.android.roomdbinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.roomdbinjava.db.AppDatabase;
import com.android.roomdbinjava.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText firstNameInput =  findViewById(R.id.name);
        final EditText lastNameInput =  findViewById(R.id.price);
        Button saveButton =  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(firstNameInput.getText().toString(), Integer.parseInt(lastNameInput.getText().toString()));
            }
        });
    }

    private void saveNewUser(String firstName, int lastName) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.name = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);

        finish();

    }
}