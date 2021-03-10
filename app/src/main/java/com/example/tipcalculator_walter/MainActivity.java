package com.example.tipcalculator_walter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
    private EditText customTip;

    private TextView Header;

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
        customTip = findViewById(R.id.custom_field);

        Header = findViewById(R.id.Header);

        reset_button = findViewById(R.id.reset_button);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount_input.setText("");
                number_of_people.setText("");
                customTip.setText("");
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

                boolean validInput = true;
                double tip = 1;

                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                //Toast.makeText(getApplicationContext(), String.valueOf(tip), Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_LONG).show();
                if(radioButton.getText().toString().equals("Custom")){
                    if(customTip.getText().toString().length() != 0){
                        if(Double.valueOf(customTip.getText().toString()) > 0){
                            tip = Double.valueOf(customTip.getText().toString());
                        } else{
                            validInput = false;
                            Toast.makeText(getApplicationContext(), "Really?? no tip??", Toast.LENGTH_LONG).show();
                        }
                    } else{
                        validInput = false;
                        Toast.makeText(getApplicationContext(), "Enter a custom tip?", Toast.LENGTH_LONG).show();

                    }
                }else{
                    tip = Double.valueOf(radioButton.getText().toString());
                }

                if(amount_input.getText().toString().length() == 0){
                    validInput = false;
                    Toast.makeText(getApplicationContext(), "How much is the bill?", Toast.LENGTH_LONG).show();
                }

                if(number_of_people.getText().toString().length() == 0){
                    validInput = false;
                    Toast.makeText(getApplicationContext(), "How many people are paying?", Toast.LENGTH_LONG).show();
                }





                if(validInput){
                    Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                    String s = "test";
                    i.putExtra("test", s);

                    i.putExtra("amount_input", Double.valueOf(amount_input.getText().toString()));
                    i.putExtra("number_of_people", Integer.valueOf(number_of_people.getText().toString()));

                    i.putExtra("tip", tip);

                    startActivity(i);
                }


            }
        });


    }
}
