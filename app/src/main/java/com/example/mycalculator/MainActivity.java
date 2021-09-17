package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnClear;
    Button btnDevide;
    Button btnMultiply;
    Button btnAdd;
    Button btnSubstract;
    Button btnEquals;
    Button btnParanthese;
    Button btnPowerOf;
    Button btnPoint;
    TextView workingTextview;
    TextView resultTextView;
    boolean leftBracket = true;
    String regexString = "(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])";
    LinkedList<Double> number = new LinkedList<>();
    LinkedList<String> operator = new LinkedList<>();
    DecimalFormat decimalFormatter = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private  void initComponent() {
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnDevide = (Button) findViewById(R.id.btnDevide);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubstract = (Button) findViewById(R.id.btnSubstract);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnParanthese = (Button) findViewById(R.id.btnParanthese);
        btnPowerOf = (Button) findViewById(R.id.btnPowerOf);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        workingTextview = (TextView) findViewById(R.id.workingTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }


    public void calculation(String text) {
        String[] split = text.split(regexString);
        double result;

        try {
            checkFirstSplit(split);
            addSplitToList(split);
            result = number.poll();

            while (!operator.isEmpty()) {
                double pollNumber = number.poll();
                switch (operator.poll()) {
                    case "*":
                        result *= pollNumber;
                        break;
                    case "/":
                        result /= pollNumber;
                        break;
                    case "+":
                        result += pollNumber;
                        break;
                    case "-":
                        result -= pollNumber;
                        break;
                    case "^":
                        result = Math.pow(result, pollNumber);
                        break;
                }
            }

            String resultString = decimalFormatter.format(result);
            resultTextView.setText("= " + resultString);
        } catch(Exception e) {
            workingTextview.setText("");
        }
    }

    private void checkFirstSplit(String[] split) {
        if (split[0].equals("-")) {
            split[1] = "-" + split[1];
            split[0] = "";
        } else if (split[0].equals("+")) {
            split[1] = "+" + split[1];
            split[0] = "";
        }
    }

    private void addSplitToList(String[] split) {

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {

            } else if (isOperator(split[i])) {
                operator.add(split[i]);
            } else {
                number.add(Double.parseDouble(split[i]));
            }
        }
    }

    public boolean isOperator(String operator) {
        if(operator.equals("+") || operator.equals("-") || operator.equals("/") ||
                operator.equals("*")  || operator.equals("^")) {
            return true;
        }
        return false;
    }

    public void clearOnClick(View view) {
        workingTextview.setText("");
        resultTextView.setText("");
        leftBracket = true;
    }


    public void parantheseOnClick(View view) {
        if(leftBracket) {
            String text = workingTextview.getText().toString();
            workingTextview.setText(text + "(");
            leftBracket = false;
        } else {
            String text = workingTextview.getText().toString();
            workingTextview.setText(text + ")");
            leftBracket = true;
        }
    }



    public void divideOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "/");
    }

    public void sevenOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "7");
    }

    public void eightOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "8");
    }


    public void nineOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "9");
    }

    public void multiplyOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "*");
    }


    public void fourOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "4");
    }

    public void fiveOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "5");
    }


    public void sixOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "6");
    }

    public void substractOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "-");
    }

    public void oneOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "1");
    }

    public void twoOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "2");
    }

    public void threeOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "3");
    }

    public void addOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "+");
    }

    public void pointOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + ".");
    }

    public void zeroOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "0");
    }

    public void exponentOnClick(View view) {
        String text = workingTextview.getText().toString();
        workingTextview.setText(text + "^");
    }

    public void equalsOnClick(View view) {
        String text = workingTextview.getText().toString();
        calculation(text);
    }
}