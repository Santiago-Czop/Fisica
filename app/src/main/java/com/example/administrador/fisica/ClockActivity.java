package com.example.administrador.fisica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.Calendar;

public class ClockActivity extends AppCompatActivity{

    TextView tv1;
    @Override
    public void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_clock);

        tv1 = (TextView)findViewById(R.id.tv1);
        Calendar c = Calendar.getInstance();
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(c.get(Calendar.MINUTE));
        if (Integer.parseInt(minute) < 10) {
            minute = "0" + minute;
        }
        tv1.setText(hour + ":" +  minute);
    }
}
