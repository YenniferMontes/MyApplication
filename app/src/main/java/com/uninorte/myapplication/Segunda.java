package com.uninorte.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    String  Op;
    TextView Tx1, Tx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {




            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_segunda);
            Tx2 = findViewById(R.id.Tx2);
            Op = getIntent().getStringExtra("Operation");
            Tx2.setText(Op);

    }

}
