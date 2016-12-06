package com.example.ahmaadyunus.mycalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    int balance;
    String number;
    boolean income_focused=false;
    EditText income_ET, outcome_ET;
    TextView balance_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        income_ET = (EditText) findViewById(R.id.income_editText);
        outcome_ET = (EditText) findViewById(R.id.outcome_editText);
        income_ET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    income_focused = true;
                }
            }
        });
        outcome_ET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                if (!focused) {
                    income_focused= false;
                }
            }
        });
        FloatingActionButton fab_balance = (FloatingActionButton) findViewById(R.id.fab_balance);

        fab_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {

                   int in, out, bal;

                   in = Integer.parseInt(income_ET.getText().toString().trim());
                   out = Integer.parseInt(outcome_ET.getText().toString().trim());
                   bal = in - out;
                   displayBalance(bal);
               }catch(NumberFormatException nfe){
                   Toast.makeText(getApplicationContext(), R.string.warning , Toast.LENGTH_SHORT).show();
                }
            }
        });
        FloatingActionButton fab_reset = (FloatingActionButton) findViewById(R.id.fab_reset);
        fab_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                income_ET.setText("");
                outcome_ET.setText("");
                balance_TV.setText("Balance:");
            }
        });
        FloatingActionButton fab_delete = (FloatingActionButton) findViewById(R.id.fab_delete);
        fab_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (income_focused == false) {
                    int length = income_ET.getText().length();
                    if (length > 0) {
                        income_ET.getText().delete(length - 1, length);
                    }
                } else {
                    int length = outcome_ET.getText().length();
                    if (length > 0) {
                        outcome_ET.getText().delete(length-1,length
                        );
                    }
                }
            }
        });





    }


    public void press(View v) {
        switch (v.getId()) {
            case R.id.one_button:
                number = "1";
                break;
            case R.id.two_button:
                number = "2";
                break;
            case R.id.three_button:
                number = "3";
                break;
            case R.id.four_button:
                number = "4";
                break;
            case R.id.five_button:
                number = "5";
                break;
            case R.id.six_button:
                number = "6";
                break;
            case R.id.seven_button:
                number = "7";
                break;
            case R.id.eight_button:
                number = "8";
                break;
            case R.id.nine_button:
                number = "9";
                break;
            default:
                break;
        }
        if (income_focused == false) {
            income_ET.setText(income_ET.getText().toString() + number);
        } else {
            outcome_ET.setText(outcome_ET.getText().toString() + number);
        }
    }

    private void displayBalance (int balance){
        balance_TV = (TextView) findViewById(R.id.balance_textView);
        balance_TV.setText("Balance : "+balance);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }









}
