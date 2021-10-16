package com.example.mortgageapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //Declaring variables for the userinput save
    double mortgage, interest, amm;

    //The declarations of the text fields to save the user input in
    TextView mortgage_Input;
    TextView interest_Input;
    TextView ammortization_Input;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the variables from XML ids to read user input and manipulate for all edit text fields
        mortgage_Input = findViewById(R.id.mortgageInput);
        interest_Input = findViewById(R.id.interestInput);
        ammortization_Input = findViewById(R.id.ammInput);

    }

    public void onClickListner(View view)
    {
        //For displaying final mortgage from ID
        TextView showAnswer = findViewById(R.id.finalAnswer);

        mortgage = Double.parseDouble(mortgage_Input.getText().toString());
        interest = Double.parseDouble(interest_Input.getText().toString());
        amm = Double.parseDouble(ammortization_Input.getText().toString());

        //Just a test method to make sure input is read correct
//        showToast(String.valueOf(amm));
//        showToast(String.valueOf(mortgage));
//        showToast(String.valueOf(interest));
//        showToast(String.valueOf(pay));

        //casting input as double from user input for equation
        double monthlyRate = (interest / 100) / 12;
        double totalMonths = amm;
        double result = ((mortgage * monthlyRate) / (1 - Math.pow(1+ monthlyRate, -totalMonths)));

        //Displaying the final output
        String x = String.format("$%.2f", result);
        showAnswer.setText(x);
    }

    //Used for test method
//    public void showToast(String text)
//    {
//        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//    }
}