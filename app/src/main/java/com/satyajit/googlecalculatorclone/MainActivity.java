package com.satyajit.googlecalculatorclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        Button num0=findViewById(R.id.num0);
        Button num1=findViewById(R.id.num1);
        Button num2=findViewById(R.id.num2);
        Button num3=findViewById(R.id.num3);
        Button num4=findViewById(R.id.num4);
        Button num5=findViewById(R.id.num5);
        Button num6=findViewById(R.id.num6);
        Button num7=findViewById(R.id.num7);
        Button num8=findViewById(R.id.num8);
        Button num9=findViewById(R.id.num9);
        TextView text=findViewById(R.id.textView);
        TableLayout t=findViewById(R.id.tableLayout);
        //


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


}