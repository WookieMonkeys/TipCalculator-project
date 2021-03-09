package com.example.tipcalculator_walter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amount_input;
    private EditText number_of_people;

    private TextView textView;

    private Button reset_button;
    private Button calculate_button;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);


        amount_input = findViewById(R.id.amount_input);

        number_of_people = findViewById(R.id.number_of_people);

        textView = findViewById(R.id.textView);

        reset_button = findViewById(R.id.reset_button);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount_input.setText("");
                number_of_people.setText("");
                radioGroup.check(R.id.radio_one);
//                String amount_string = amount_input.getText().toString();
//                String string = amount_input.getText().toString();
//
//                textView.setText(amount_string);

            }
        });


        calculate_button = findViewById(R.id.calculate_button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);


            }
        });


    }


}
