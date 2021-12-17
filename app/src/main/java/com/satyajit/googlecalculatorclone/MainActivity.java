package com.satyajit.googlecalculatorclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Satyajit Ghosh
 * @since 15-12-2021
 * */
public class MainActivity extends AppCompatActivity {
    private String myResultStr="";
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button AC;
    private Button brackets;
    private Button percent;
    private Button div;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
       num0=findViewById(R.id.num0);
       num1=findViewById(R.id.num1);
       num2=findViewById(R.id.num2);
       num3=findViewById(R.id.num3);
       num4=findViewById(R.id.num4);
       num5=findViewById(R.id.num5);
       num6=findViewById(R.id.num6);
       num7=findViewById(R.id.num7);
       num8=findViewById(R.id.num8);
       num9=findViewById(R.id.num9);
       AC=findViewById(R.id.AC);
       percent=findViewById(R.id.percent);
       brackets=findViewById(R.id.brackets);
       div=findViewById(R.id.div);
       text=findViewById(R.id.textView);
       TableLayout t=findViewById(R.id.tableLayout);
        //


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public void myKeyPressedMethod(View view){
        Button b=(Button)view;

        switch (view.getId()){
            case R.id.div:
                myResultStr+="/";
                break;
            case R.id.mul:
                myResultStr+="*";
                break;
            case R.id.brackets:
                if(validParen(myResultStr)){
                    myResultStr+="(";
                }
                else{
                    if(myResultStr.contains("(")){

                    myResultStr+=")";
                    }
                    else{
                        myResultStr+="(";
                    }
                }
                break;
            default:
                myResultStr+= b.getText().toString();
        }

        text.setText(myResultStr);
    }
    public void backspaceMethod(View view){
        if(myResultStr.length()>=1){

        myResultStr=myResultStr.substring(0,myResultStr.length()-1);
        text.setText(myResultStr);
        }
    }
    public void clear(View view){
        myResultStr="";
        text.setText(myResultStr);
    }
    public void onEqualPress(View view){

        Expression e1=new Expression(myResultStr);
        text.setText(Double.toString(e1.calculate()));
    }

    public boolean validParen(String input) {

        if (input.isEmpty()) {
            return true;
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (current == '(' || current == '[' || current == '{') {
                    stack.push(current);
                } else {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    char peekChar = stack.peek();
                    if ((current == ')' && peekChar != '(')
                            || (current == '}' && peekChar != '{')
                            || (current == ']' && peekChar != '[')) {
                        return false;  // for a valid input, a close brackets must have an open brackets
                    } else {
                        stack.pop();
                    }
                }
            }
            return true;
        }
    }



}