package com.example.supaj.beginnercontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    char decision = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Button buttonEnter = (Button) findViewById(R.id.enterBtn);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText num1 = (EditText) findViewById(R.id.num1);
                EditText num2 = (EditText) findViewById(R.id.num2);

                TextView resultText = (TextView) findViewById(R.id.resultText);

                double num1v = Double.parseDouble(num1.getText().toString());
                double num2v = Double.parseDouble(num2.getText().toString());

                double answer = 0;
                if(decision == 'a')
                    answer = num2v + num1v;
                else if(decision == 's')
                    answer = num2v - num1v;
                else if(decision == 'd')
                    answer = num2v / num1v;
                else if(decision == 'm')
                    answer = num2v * num1v;

                resultText.setText(answer + "");
            }
        });


    }


    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.add:
            if(checked)
                decision = 'a';
            break;
            case R.id.subtract:
            if(checked) {
                decision = 's';
                break;
            }
            case R.id.multiply:
                if(checked) {
                    decision = 'm';
                    break;
                }
            case R.id.divide:
                if(checked) {
                    decision = 'd';
                    break;
                }
        }

    }

}
