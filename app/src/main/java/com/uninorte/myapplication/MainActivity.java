package com.uninorte.myapplication;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] names,lastnames,roles,age,select,selectChange;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.Nombres);
        lastnames = getResources().getStringArray(R.array.Apellidos);
        roles = getResources().getStringArray(R.array.Posicion);
        age = getResources().getStringArray(R.array.Edad);
        select = getResources().getStringArray(R.array.Convocado);
        selectChange = select;
        System.out.println("First timer");

        lv = (ListView) findViewById(R.id.lv);
        CustomAdapter customAdapter = new CustomAdapter(this,names,lastnames,roles,select);
        lv.setAdapter(customAdapter);


    }

    public void onClickBtnEdit(View view) {
        Intent i = new Intent(this, EditActivity.class);
        i.putExtra("Position",(Integer) view.getTag());
        i.putExtra("SelectArray",selectChange);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String [] resultSelect = data.getStringArrayExtra("SelectArray");
                selectChange = resultSelect;
                System.out.println("Im Back!");
                CustomAdapter customAdapter = new CustomAdapter(this,names,lastnames,roles,selectChange);
                lv.setAdapter(customAdapter);
            }
        }
    }


}
