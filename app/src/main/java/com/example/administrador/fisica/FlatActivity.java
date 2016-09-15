package com.example.administrador.fisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class FlatActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    TextView tva, tvb, tvc, tvd;
    Button bt1;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        et1 =(EditText)findViewById(R.id.et1);
        et2 =(EditText)findViewById(R.id.et2);
        et3 =(EditText)findViewById(R.id.et3);
        et4 =(EditText)findViewById(R.id.et4);
        tva =(TextView)findViewById(R.id.tva);
        tvb =(TextView)findViewById(R.id.tvb);
        tvc =(TextView)findViewById(R.id.tvc);
        tvd =(TextView)findViewById(R.id.tvd);
        bt1 =(Button)findViewById(R.id.bt1);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Básico");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_clock:
                Intent i = new Intent(this, ClockActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.bt1:
                String m1 = et1.getText().toString();
                if (m1.equals("")) {
                    et1.setText("0");
                    m1 = et1.getText().toString();
                }
                double m = Double.parseDouble(m1);
                String fy1 = et2.getText().toString();
                if (fy1.equals("")) {
                    et2.setText("0");
                    fy1 = et2.getText().toString();
                }
                double fy = Double.parseDouble(fy1);
                String fx1 = et3.getText().toString();
                if (fx1.equals("")) {
                    et3.setText("0");
                    fx1 = et3.getText().toString();

                }
                double fx = Double.parseDouble(fx1);
                String mu1 = et4.getText().toString();
                if (mu1.equals("")) {
                    et4.setText("0");
                    mu1 = et4.getText().toString();
                }
                double mu = Double.parseDouble(mu1);

                double weight = m*-9.8;
                tva.setText(df.format(weight) + "N");


                double normal = -(weight+fy);
                tvb.setText(df.format(normal) + "N");

                double friction = mu*normal;
                tvc.setText(df.format(friction) + "N");

                double a;
                if (Math.abs(friction) >= Math.abs(fx)) {
                    a = 0.0;
                } else {
                    a = (Math.signum(fx) * (Math.abs(fx) - friction)) / m;
                }
                tvd.setText(df.format(a));
                break;
            default:
                break;


        }

    }
}