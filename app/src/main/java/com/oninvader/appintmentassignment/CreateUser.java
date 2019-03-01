package com.oninvader.appintmentassignment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Date;

public class CreateUser extends AppCompatActivity {

    private static final String TAG = "CreateUser";
    Button save_btn, set_date_btn;
    TextInputEditText firstname, lastname, address, phone, country, zip;
    String user_type;
    TextView birth_date;
    Spinner type;
    MyDate date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        save_btn = findViewById(R.id.save_user_btn);
        firstname =  findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone_number);
        birth_date = findViewById(R.id.birth_day_text);
        country = findViewById(R.id.country);
        zip = findViewById(R.id.zip);

        set_date_btn = findViewById(R.id.set_date_btn);
        type = findViewById(R.id.user_type);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user_type = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                user_type = "Friend";
            }


        });

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myAddressBook")
                .allowMainThreadQueries()
                .build();


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.userDao().addUser(new User(
                        firstname.getText().toString(),
                        lastname.getText().toString(),
                        phone.getText().toString(),
                        country.getText().toString(),
                        zip.getText().toString(),
                        address.getText().toString(),
                        birth_date.getText().toString(),
                        user_type
                ));
//                db.userDao().addUser(new User(
//                        firstname.getText().toString(),
//                        lastname.getText().toString(),
//                        phone.getText().toString(),
//                        country.getText().toString(),
//                        zip.getText().toString(),
//                        "somewhere",
//                        "unknown",
//                        "friend"
//                ));
                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });

        set_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            date = new MyDate(arg1, arg2, arg3);
            birth_date.setText(new StringBuilder().append("Birth Day: ").append(date.getDate()));
            set_date_btn.setText("Change date");
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, myDateListener, 2019, 02, 27);
    }
}
