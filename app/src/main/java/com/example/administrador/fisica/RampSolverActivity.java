package com.example.administrador.fisica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class RampSolverActivity extends AppCompatActivity {

    EditText etA, etB, etC, et1Y, et1X, et2Y, et2X, et3Y, et3X, et4F, et4A, et5F, et5A, et6F, et6A;
    TextView tva, tvb, tvc, tvd, tvx, tvy, tvpx, tvpy;
    Button bt1;
    DecimalFormat df = new DecimalFormat("#.##");
    LinearLayout xychart, dchart, l1, l2, l3, l4, l5, l6;
    String zero = "0";
    String empty = "";
    Double pendiente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramp_solver);

        Intent intent = getIntent();
        pendiente = intent.getExtras().getDouble("rampStyle");

        etA = (EditText)findViewById(R.id.etA);
        etB = (EditText)findViewById(R.id.etB);
        etC = (EditText)findViewById(R.id.etC);

        et1Y =(EditText)findViewById(R.id.et1Y);
        et1X =(EditText)findViewById(R.id.et1X);

        et2Y =(EditText)findViewById(R.id.et2Y);
        et2X =(EditText)findViewById(R.id.et2X);

        et3Y =(EditText)findViewById(R.id.et3Y);
        et3X =(EditText)findViewById(R.id.et3X);

        et4F =(EditText)findViewById(R.id.et4F);
        et4A =(EditText)findViewById(R.id.et4A);

        et5F =(EditText)findViewById(R.id.et5F);
        et5A =(EditText)findViewById(R.id.et5A);

        et6F =(EditText)findViewById(R.id.et6F);
        et6A =(EditText)findViewById(R.id.et6A);

        tva =(TextView)findViewById(R.id.tva);
        tvb =(TextView)findViewById(R.id.tvb);
        tvc =(TextView)findViewById(R.id.tvc);
        tvd =(TextView)findViewById(R.id.tvd);
        tvx =(TextView)findViewById(R.id.tvx);
        tvy =(TextView)findViewById(R.id.tvy);
        tvpx =(TextView)findViewById(R.id.tvpx);
        tvpy =(TextView)findViewById(R.id.tvpy);

        bt1 =(Button)findViewById(R.id.bt1);

        xychart =(LinearLayout)findViewById(R.id.xychart);
        l1 =(LinearLayout)findViewById(R.id.l1);
        l2 =(LinearLayout)findViewById(R.id.l2);
        l3 =(LinearLayout)findViewById(R.id.l3);

        dchart =(LinearLayout)findViewById(R.id.dchart);
        l4 =(LinearLayout)findViewById(R.id.l4);
        l5 =(LinearLayout)findViewById(R.id.l5);
        l6 =(LinearLayout)findViewById(R.id.l6);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Rampa");
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                String m1 = etA.getText().toString();
                if (m1.equals("")) {
                    etA.setText(zero);
                    m1 = etA.getText().toString();
                }
                double m = Double.parseDouble(m1);

                String angle1 = etB.getText().toString();
                if (angle1.equals("")) {
                    etB.setText(zero);
                    Toast.makeText(this, "Invalid Ramp Angle", Toast.LENGTH_LONG).show();
                    return;
                }
                double preAngle = Double.parseDouble(angle1);
                double angle = 90.0 - preAngle;
                String mu1 = etC.getText().toString();
                if (mu1.equals("")) {
                    etB.setText(zero);
                    mu1 = etB.getText().toString();
                }
                double mu = Double.parseDouble(mu1);

                String pfy1 = et1Y.getText().toString();
                if (pfy1.equals("")) {
                    et1Y.setText(zero);
                    pfy1 = et1Y.getText().toString();
                }
                double fy1 = Double.parseDouble(pfy1);

                String pfy2 = et2Y.getText().toString();
                if (pfy2.equals("")) {
                    et2Y.setText(zero);
                    pfy2 = et2Y.getText().toString();
                }
                double fy2 = Double.parseDouble(pfy2);

                String pfy3 = et3Y.getText().toString();
                if (pfy3.equals("")) {
                    et3Y.setText(zero);
                    pfy3 = et3Y.getText().toString();
                }
                double fy3 = Double.parseDouble(pfy3);

                String pfx1 = et1X.getText().toString();
                if (pfx1.equals("")) {
                    et1X.setText(zero);
                    pfx1 = et1X.getText().toString();
                }
                double fx1 = Double.parseDouble(pfx1);

                String pfx2 = et2X.getText().toString();
                if (pfx2.equals("")) {
                    et2X.setText(zero);
                    pfx2 = et2X.getText().toString();

                }
                double fx2 = Double.parseDouble(pfx2);

                String pfx3 = et3X.getText().toString();
                if (pfx3.equals("")) {
                    et3X.setText(zero);
                    pfx3 = et3X.getText().toString();

                }
                double fx3 = Double.parseDouble(pfx3);

                String pf4 = et4F.getText().toString();
                if (pf4.equals("")) {
                    et4F.setText(zero);
                    pf4 = et4F.getText().toString();
                }
                double f4 = Double.parseDouble(pf4);

                String pa4 = et4A.getText().toString();
                if (pa4.equals("")) {
                    et4A.setText(zero);
                    pa4 = et4A.getText().toString();
                }
                double a4 = Double.parseDouble(pa4);

                String pf5 = et5F.getText().toString();
                if (pf5.equals("")) {
                    et5F.setText(zero);
                    pf5 = et5F.getText().toString();
                }
                double f5 = Double.parseDouble(pf5);

                String pa5 = et5A.getText().toString();
                if (pa5.equals("")) {
                    et5A.setText(zero);
                    pa5 = et5A.getText().toString();
                }
                double a5 = Double.parseDouble(pa5);

                String pf6 = et6F.getText().toString();
                if (pf6.equals("")) {
                    et6F.setText(zero);
                    pf6 = et6F.getText().toString();
                }
                double f6 = Double.parseDouble(pf6);

                String pa6 = et6A.getText().toString();
                if (pa6.equals("")) {
                    et6A.setText(zero);
                    pa6 = et6A.getText().toString();
                }
                double a6 = Double.parseDouble(pa6);

                double fx4 = 0.0;
                double fy4 = 0.0;
                double fx5 = 0.0;
                double fy5 = 0.0;
                double fx6 = 0.0;
                double fy6 = 0.0;

                if (a4 <= 90.0) {
                    fx4 = -(Math.cos(Math.toRadians(a4)) * f4);
                    fy4 = -(Math.sin(Math.toRadians(a4)) * f4);
                } else if (a4 <= 180.0) {
                    fx4 = Math.sin(Math.toRadians(a4 - 90.0)) * f4;
                    fy4 = -(Math.cos(Math.toRadians(a4 - 90.0)) * f4);
                } else if (a4 <= 270.0) {
                    fx4 = Math.cos(Math.toRadians(a4 - 180.0)) * f4;
                    fy4 = Math.sin(Math.toRadians(a4 - 180.0)) * f4;
                } else if (a4 <= 360.0) {
                    fx4 = -(Math.sin(Math.toRadians(a4-270.0)) * f4);
                    fy4 = Math.cos(Math.toRadians(a4 - 270.0)) * f4;
                } else {
                    Toast.makeText(this, "Invalid First Angle", Toast.LENGTH_LONG).show();
                    return;
                }

                if (a5 <= 90.0) {
                    fx5 = -(Math.cos(Math.toRadians(a5)) * f5);
                    fy5 = -(Math.sin(Math.toRadians(a5)) * f5);
                } else if (a5 <= 180.0) {
                    fx5 = Math.sin(Math.toRadians(a5 - 90.0)) * f5;
                    fy5 = -(Math.cos(Math.toRadians(a5 - 90.0)) * f5);
                } else if (a5 <= 270.0) {
                    fx5 = Math.cos(Math.toRadians(a5 - 180.0)) * f5;
                    fy5 = Math.sin(Math.toRadians(a5 - 180.0)) * f5;
                } else if (a5 <= 360.0) {
                    fx5 = -(Math.sin(Math.toRadians(a5-270.0)) * f5);
                    fy5 = Math.cos(Math.toRadians(a5 - 270.0)) * f5;
                } else {
                    Toast.makeText(this, "Invalid Second Angle", Toast.LENGTH_LONG).show();
                    return;
                }

                if (a6 <= 90.0) {
                    fx6 = -(Math.cos(Math.toRadians(a6)) * f6);
                    fy6 = -(Math.sin(Math.toRadians(a6)) * f6);
                } else if (a4 <= 180.0) {
                    fx6 = Math.sin(Math.toRadians(a6 - 90.0)) * f6;
                    fy6 = -(Math.cos(Math.toRadians(a6 - 90.0)) * f6);
                } else if (a4 <= 270.0) {
                    fx6 = Math.cos(Math.toRadians(a6 - 180.0)) * f6;
                    fy6 = Math.sin(Math.toRadians(a6 - 180.0)) * f6;
                } else if (a4 <= 360.0) {
                    fx6 = -(Math.sin(Math.toRadians(a6-270.0)) * f6);
                    fy6 = Math.cos(Math.toRadians(a6 - 270.0)) * f6;
                } else {
                    Toast.makeText(this, "Invalid Third Angle", Toast.LENGTH_LONG).show();
                    return;
                }

                double weight = m*-9.8;
                tva.setText(df.format(weight) + "N");

                double weightX = (Math.cos(Math.toRadians(angle)) * -weight) * pendiente;
                tvpx.setText(df.format(weightX) + "N");

                double weightY = (Math.sin(Math.toRadians(angle)) * weight);
                tvpy.setText(df.format(weightY) + "N");

                double fx = fx1 + fx2 + fx3 + fx4 + fx5 + fx6;
                tvx.setText(df.format(fx) + "N");

                double fy = fy1 + fy2 + fy3 + fy4 + fy5 + fy6;
                tvy.setText(df.format(fy) + "N");

                double normal = -(weightY+fy);
                tvb.setText(df.format(normal) + "N");

                double friction = mu*normal;
                tvc.setText(df.format(friction) + "N");

                double fpx = fx + weightX;

                double a;
                if (Math.abs(friction) >= Math.abs(fpx)) {
                    a = 0.0;
                } else {
                    a = (Math.signum(fpx) * (Math.abs(fpx) - friction)) / m;
                }
                tvd.setText(df.format(a));
                break;
            case R.id.yplus:
                xychart.setVisibility(View.VISIBLE);
                if(et1Y.getVisibility() == View.GONE) {
                    l1.setVisibility(View.VISIBLE);
                    et1Y.setVisibility(View.VISIBLE);
                    et1Y.setText(empty);
                } else if (et2Y.getVisibility() == View.GONE) {
                    l2.setVisibility(View.VISIBLE);
                    et2Y.setVisibility(View.VISIBLE);
                    et2Y.setText(empty);
                } else {
                    l3.setVisibility(View.VISIBLE);
                    et3Y.setVisibility(View.VISIBLE);
                    et3Y.setText(empty);
                }
                break;
            case R.id.xplus:
                xychart.setVisibility(View.VISIBLE);
                if(et1X.getVisibility() == View.GONE) {
                    l1.setVisibility(View.VISIBLE);
                    et1X.setVisibility(View.VISIBLE);
                    et1X.setText(empty);
                } else if (et2X.getVisibility() == View.GONE) {
                    l2.setVisibility(View.VISIBLE);
                    et2X.setVisibility(View.VISIBLE);
                    et2X.setText(empty);
                } else {
                    l3.setVisibility(View.VISIBLE);
                    et3X.setVisibility(View.VISIBLE);
                    et3X.setText(empty);
                }
                break;
            case R.id.dplus:
                dchart.setVisibility(View.VISIBLE);
                if(l4.getVisibility() == View.GONE) {
                    l4.setVisibility(View.VISIBLE);
                    et4F.setVisibility(View.VISIBLE);
                    et4F.setText(empty);
                    et4A.setVisibility(View.VISIBLE);
                    et4A.setText(empty);
                } else if (l5.getVisibility() == View.GONE) {
                    l5.setVisibility(View.VISIBLE);
                    et5F.setVisibility(View.VISIBLE);
                    et5F.setText(empty);
                    et5A.setVisibility(View.VISIBLE);
                    et5A.setText(empty);
                } else {
                    l6.setVisibility(View.VISIBLE);
                    et6F.setVisibility(View.VISIBLE);
                    et6F.setText(empty);
                    et6A.setVisibility(View.VISIBLE);
                    et6A.setText(empty);
                }
                break;
            case R.id.yminus:
                if (et3Y.getVisibility() == View.VISIBLE) {
                    et3Y.setVisibility(View.GONE);
                    et3Y.setText(empty);
                    l3Gone();
                } else if (et2Y.getVisibility() == View.VISIBLE) {
                    et2Y.setVisibility(View.GONE);
                    et2Y.setText(empty);
                    l2Gone();
                } else {
                    et1Y.setVisibility(View.GONE);
                    et1Y.setText(empty);
                    l1Gone();
                }
                xychartGone();
                break;
            case R.id.xminus:
                if (et3X.getVisibility() == View.VISIBLE) {
                    et3X.setVisibility(View.GONE);
                    et3X.setText(empty);
                    l3Gone();
                } else if (et2X.getVisibility() == View.VISIBLE) {
                    et2X.setVisibility(View.GONE);
                    et2X.setText(empty);
                    l2Gone();
                } else {
                    et1X.setVisibility(View.GONE);
                    et1X.setText(empty);
                    l1Gone();
                }
                xychartGone();
                break;
            case R.id.dminus:
                if (l6.getVisibility() == View.VISIBLE) {
                    et6F.setVisibility(View.GONE);
                    et6F.setText(empty);
                    et6A.setVisibility(View.GONE);
                    et6A.setText(empty);
                    l6Gone();
                } else if (l5.getVisibility() == View.VISIBLE) {
                    et5F.setVisibility(View.GONE);
                    et5F.setText(empty);
                    et5A.setVisibility(View.GONE);
                    et5A.setText(empty);
                    l5Gone();
                } else {
                    et4F.setVisibility(View.GONE);
                    et4F.setText(empty);
                    et4A.setVisibility(View.GONE);
                    et4A.setText(empty);
                    l4Gone();
                }
                dchartGone();
            default:
                break;
        }
    }

    public boolean l1Gone() {
        if (et1Y.getVisibility() == View.GONE && et1X.getVisibility() == View.GONE) {
            l1.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public boolean l2Gone() {
        if (et2Y.getVisibility() == View.GONE && et2X.getVisibility() == View.GONE) {
            l2.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public boolean l3Gone() {
        if (et3Y.getVisibility() == View.GONE && et3X.getVisibility() == View.GONE) {
            l3.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public boolean l4Gone() {
        if (et4F.getVisibility() == View.GONE && et4A.getVisibility() == View.GONE) {
            l4.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public boolean l5Gone() {
        if (et5F.getVisibility() == View.GONE && et5A.getVisibility() == View.GONE) {
            l5.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public boolean l6Gone() {
        if (et6F.getVisibility() == View.GONE && et6A.getVisibility() == View.GONE) {
            l6.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public void xychartGone () {
        if (l1Gone() && l2Gone() && l3Gone()) {
            xychart.setVisibility(View.GONE);
        }
    }
    public void dchartGone() {
        if (l4Gone() && l5Gone() && l6Gone()) {
            dchart.setVisibility(View.GONE);
        }
    }

}