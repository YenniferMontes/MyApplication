package com.uninorte.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class EditActivity extends AppCompatActivity {

    private String[] names,lastnames,roles,age;

    private TextView tvName,tvLastName,tvRole,tvAge;
    private ToggleButton btnToggle;
    private Button btnSave;
    private boolean status = false;
    private String[] select;
    private int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        j = i.getIntExtra("Position",0);
        select = i.getStringArrayExtra("SelectArray");

        tvName = (TextView) findViewById(R.id.tvName);
        tvLastName = (TextView) findViewById(R.id.tvLastName);
        tvRole = (TextView) findViewById(R.id.tvRole);
        tvAge = (TextView) findViewById(R.id.tvAge);

        btnToggle = (ToggleButton) findViewById(R.id.toggleBtn);

        btnSave = (Button) findViewById(R.id.btnSave);

        names = getResources().getStringArray(R.array.Nombres);
        lastnames = getResources().getStringArray(R.array.Apellidos);
        roles = getResources().getStringArray(R.array.Posicion);
        age = getResources().getStringArray(R.array.Edad);

        tvName.setText(tvName.getText().toString()+names[j]);
        tvLastName.setText(tvLastName.getText().toString()+lastnames[j]);
        tvRole.setText(tvRole.getText().toString()+roles[j]);
        tvAge.setText(tvAge.getText().toString()+age[j]);

        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    System.out.println("Estoy True");
                    status = true;
                    select[j] = "Convocado";
                }
                else
                {
                    System.out.println("Estoy False");
                    status = false;
                    select[j] = "No Convocado";
                }

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("SelectArray", select);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
