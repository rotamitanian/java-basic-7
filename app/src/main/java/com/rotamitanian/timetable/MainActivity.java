package com.rotamitanian.timetable;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i = 1; i <= 100; i++ ) {
            timesTableContent.add(Integer.toString(i * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timesTablesSeekBar = findViewById(R.id.seekBar);
        timesTablesListView = findViewById(R.id.listNumber);

        int max = 30;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(max / 2);
        generateTimesTable(max / 2);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber = Math.max(progress, min);
                timesTablesSeekBar.setProgress(timesTableNumber);
                generateTimesTable(timesTableNumber);
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