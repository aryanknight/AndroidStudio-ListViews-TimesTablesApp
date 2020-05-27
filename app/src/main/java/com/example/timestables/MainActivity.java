package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;

    public void generate(int val) {

        ArrayList<String> array1 = new ArrayList<String>();
        for (int j = 1; j <= 10; j++) {
            array1.add(Integer.toString(j * val));
        }
        ArrayAdapter<String> table = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array1);
        list.setAdapter(table);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.listview);
        final SeekBar values=findViewById(R.id.seekBar);
        values.setProgress(10);
        values.setMax(25);
        generate(10);
        values.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =1;
                int val;
                if(progress<min){
                    values.setProgress(min);
                    val=min;
                }
                else{
                    val=progress;
                }

                generate(val);
                Log.i("SeekBar",Integer.toString(progress));
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
