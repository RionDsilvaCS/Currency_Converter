package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


// Code to Convert Currencies

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView result,dollar,yen,euro;
    RadioGroup radioG;
    Button convertButton;
    RadioButton optionButton;
    Double Amt=0.0,rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mapping input out & option group
        input = findViewById(R.id.inputb);
        result = findViewById(R.id.Result);
        radioG = findViewById(R.id.radioG);

        // Button to trigger convert the currency
        convertButton = findViewById(R.id.ConvertB);

        // Currency signs
        dollar = findViewById(R.id.dollar);
        yen = findViewById(R.id.yen);
        euro = findViewById(R.id.euro);

        // Currency sign to  invisible
        dollar.setVisibility(View.INVISIBLE);
        yen.setVisibility(View.INVISIBLE);
        euro.setVisibility(View.INVISIBLE);

        // to check whether the convert button is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to check which option is click and get its id
                int id = radioG.getCheckedRadioButtonId();
                // mapping the id to get the radio button
                optionButton =  findViewById(id);

                // fetching the value given by user
                rs = Double.parseDouble(input.getText().toString());

                // checking for the radio button by its id and name
                if(optionButton.getText().toString().equals("USD")){

                    // Calculating the amount
                    Amt=rs/80;

                    // setting the visibility of the signs
                    dollar.setVisibility(View.VISIBLE);
                    yen.setVisibility(View.INVISIBLE);
                    euro.setVisibility(View.INVISIBLE);
                }

                if(optionButton.getText().toString().equals("EURO")){
                    Amt=rs/90;
                    euro.setVisibility(View.VISIBLE);
                    dollar.setVisibility(View.INVISIBLE);
                    yen.setVisibility(View.INVISIBLE);
                }

                if(optionButton.getText().toString().equals("YEN")){
                    Amt= rs/0.62;
                    yen.setVisibility(View.VISIBLE);
                    dollar.setVisibility(View.INVISIBLE);
                    euro.setVisibility(View.INVISIBLE);
                }

                // converting the double value to float
                Float Amount = Amt.floatValue();

                // setting the amount to TextView
                result.setText(String.valueOf(Amount));
            }
        });
    }
}