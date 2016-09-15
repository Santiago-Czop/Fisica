package com.example.administrador.fisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat);
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.bt1:
                Intent straight = new Intent(this, FlatStraightActivity.class);
                startActivity(straight);
                break;
            case R.id.bt2:
                Intent diagonal = new Intent(this, FlatDiagonalActivity.class);
                startActivity(diagonal);
                break;
            case R.id.bt3:
                Intent combined = new Intent(this, FlatCombinedActivity.class);
                startActivity(combined);
                break;
        }

    }
}
