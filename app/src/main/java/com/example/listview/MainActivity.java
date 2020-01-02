package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView Result;

    public void generateTable(int number) {
    ArrayList<String> timeTables = new ArrayList<String>();
    for(int i = 1; i <= 10; i++) {
        timeTables.add(Integer.toString(i * (number + 1)));
    }

    ArrayAdapter<String> tableAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTables);

    Result.setAdapter(tableAdapter);
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekbar = findViewById(R.id.seekBar);
        Result = findViewById(R.id.ResultTable);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("info", Integer.toString(progress + 1));
                generateTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
