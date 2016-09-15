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
import android.widget.Toast;

import java.text.DecimalFormat;

public class FlatDiagonalActivity extends AppCompatActivity {

    TextView tva, tvb, tvc, tvd, tvx, tvy;
    EditText et1, et2, et3, et4;
    Button bt1;
    DecimalFormat df = new DecimalFormat("#.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagonal);

        et1 =(EditText)findViewById(R.id.et1);
        et2 =(EditText)findViewById(R.id.et2);
        et3 =(EditText)findViewById(R.id.et3);
        et4 =(EditText)findViewById(R.id.et4);
        tva =(TextView)findViewById(R.id.tva);
        tvb =(TextView)findViewById(R.id.tvb);
        tvc =(TextView)findViewById(R.id.tvc);
        tvd =(TextView)findViewById(R.id.tvd);
        tvx =(TextView)findViewById(R.id.tvx);
        tvy =(TextView)findViewById(R.id.tvy);
        bt1 =(Button)findViewById(R.id.bt1);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Diagonal");
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                String m1 = et1.getText().toString();
                if (m1.equals("")) {
                    et1.setText("0");
                    m1 = et1.getText().toString();
                }
                double m = Double.parseDouble(m1);
                String f1 = et2.getText().toString();
                if (f1.equals("")) {
                    et2.setText("0");
                    f1 = et2.getText().toString();
                }
                double f = Double.parseDouble(f1);
                String angle1 = et3.getText().toString();
                if (angle1.equals("")) {
                    et3.setText("0");
                    angle1 = et3.getText().toString();
                }
                double angle = Double.parseDouble(angle1);
                String mu1 = et4.getText().toString();
                if (mu1.equals("")) {
                    et4.setText("0");
                    mu1 = et4.getText().toString();
                }
                double mu = Double.parseDouble(mu1);

                double fx;
                double dx;
                double fy;
                double dy;
                double weight;
                double normal;
                double friction;
                double a;

                if (angle <= 90.0) {
                    dx = -1.0;
                    dy = -1.0;
                    fx = Math.cos(Math.toRadians(angle))*f;
                    fy = Math.sin(Math.toRadians(angle))*f;
                } else if (angle <= 180.0) {
                    dx = 1.0;
                    dy = -1.0;
                    angle -= 90.0;
                    fx = Math.sin(Math.toRadians(angle))*f;
                    fy = Math.cos(Math.toRadians(angle))*f;
                } else if (angle <= 270.0) {
                    dx = 1.0;
                    dy = 1.0;
                    angle -=  180.0;
                    fx = Math.cos(Math.toRadians(angle))*f;
                    fy = Math.sin(Math.toRadians(angle))*f;
                } else if (angle <= 360.0) {
                    dx = -1.0;
                    dy = 1.0;
                    angle -= 270.0;
                    fx = Math.sin(Math.toRadians(angle))*f;
                    fy = Math.cos(Math.toRadians(angle))*f;
                } else {
                    Toast.makeText(this, "El ángulo no es válido", Toast.LENGTH_LONG).show();
                    et3.setText("0");
                    return;
                }

                fx *= dx;
                tvx.setText(df.format(fx) + "N");

                fy *= dy;
                tvy.setText(df.format(fy) + "N");

                weight = m*-9.8;
                tva.setText(df.format(weight) + "N");

                normal = -(weight+fy);
                tvb.setText(df.format(normal) + "N");

                friction = mu*normal;
                tvc.setText(df.format(friction) + "N");

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
