package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder currentNumber = new StringBuilder();
    private String operator = "";
    private double calculationResult ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.text_display);
        Button clearButton = findViewById(R.id.button_C);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });

        // Set onClickListeners for number buttons
        Button[] numberButtons = new Button[10];
        int[] numberButtonIds = {
                 R.id.button_0, R.id.button_1 , R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,R.id.button_8,R.id.button_9
        };

        for(int i=0;i<10;i++) {
            numberButtons[i] = findViewById(numberButtonIds[i]);
            int finalI = i;
            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //    String buttonText = numberButtons[finalI].getText().toString();
                   // resultTextView.setText(buttonText);
                    updateNumber(finalI);
                }
            });
        }

        //set onclickListener for Operator buttons
        Button button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                operator="+";
            }
        });
        Button button_minus =findViewById(R.id.button_minus);
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                operator="-";
            }
        });

        Button button_multi = findViewById(R.id.button_multi);
        button_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                operator="*";
            }
        });

        Button button_divide = findViewById(R.id.button_divide);
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                operator="/";
            }
        });

        Button button_percent = findViewById(R.id.button_percent);
        button_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                operator="%";
            }
        });

        // set onclickListener for Equal button
        Button button_equal = findViewById(R.id.button_equal);
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
                //operator="";
                calculateResult();
            }
        });

        // set onclickListener for Backspace button
        Button backspace = findViewById(R.id.backspace);
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
            }
        });

        // set onclicklistener for dot symbol
        Button decimal = findViewById(R.id.button_dot);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    String buttonText = numberButtons[finalI].getText().toString();

               String decimaldot = decimal.getText().toString();
               currentNumber.append(decimaldot);
               resultTextView.setText(currentNumber);
            }
        });

    }
    private void updateNumber(int number){
        currentNumber.append(number);
        resultTextView.setText(currentNumber.toString());
    }

    private void backspace(){

        if((currentNumber.length()>0) ){
            currentNumber.delete(currentNumber.length()-1,currentNumber.length());
            resultTextView.setText(currentNumber.toString());
        }
    }

    private  void performCalculation(){
        if (currentNumber.length() > 0) {
            double number = Double.parseDouble(currentNumber.toString());
            if (operator.equals("+")) {
                calculationResult += number;
            } else if (operator.equals("-")) {
                calculationResult -= number;
            } else if (operator.equals("*")) {
                calculationResult *= number;
            } else if (operator.equals("/")) {
                calculationResult /= number;
            }else if(operator.equals("%")){
                calculationResult =calculationResult*(number/100);
            } else {
                calculationResult = number;
            }
            currentNumber.setLength(0);
        }
        resultTextView.setText(String.valueOf(calculationResult));
    }

    private void calculateResult() {
        if (currentNumber.length() > 0) {
            double number = Double.parseDouble(currentNumber.toString());
            if (operator.equals("+")) {
                calculationResult += number;
            } else if (operator.equals("-")) {
                calculationResult -= number;
            } else if (operator.equals("*")) {
                calculationResult *= number;
            } else if (operator.equals("/")) {
                calculationResult /= number;
            }else if(operator.equals("%")){
                calculationResult  =calculationResult*(number/100);
            }
            currentNumber.setLength(0);
        }
        resultTextView.setText(String.valueOf(calculationResult));
    }
    //When clear button was clicked
    private void clearCalculator () {
        calculationResult = 0.0;
        currentNumber.setLength(0);
        operator = "";
        resultTextView.setText(" ");
    }

}
