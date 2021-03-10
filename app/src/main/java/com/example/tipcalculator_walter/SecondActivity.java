package com.example.tipcalculator_walter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button returnButton;
    private TextView tipView;
    private TextView totalView;
    private TextView perPersonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        tipView = findViewById(R.id.Tip);
        totalView = findViewById(R.id.total);
        perPersonView = findViewById(R.id.totalperperson);

        Intent i = getIntent();
        Double amount_input = i.getExtras().getDouble("amount_input");
        Integer number_of_people = i.getExtras().getInt("number_of_people");
        Double tip = i.getExtras().getDouble("tip");


        Double tipCalculated = (tip / 100)* amount_input;
        tipView.setText(tipView.getText() + " " + String.valueOf(tipCalculated));

        Double total = tipCalculated + amount_input;

        totalView.setText(totalView.getText() + " " + String.valueOf(total));

        perPersonView.setText(perPersonView.getText() + " " + String.valueOf(total/number_of_people));




        returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}




//                    i.putExtra("amount_input", Double.valueOf(amount_input.getText().toString()));
//                    i.putExtra("number_of_people", Integer.valueOf(number_of_people.getText().toString()));
//
//                    i.putExtra("tip", tip);