package com.uninorte.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{

    private Context context;
    private String[] names,lastnames,roles,selects;


    public CustomAdapter (Context context, String[] names, String[] lastnames, String[] roles, String[] selects){
        this.context = context;
        this.names = names;
        this.lastnames = lastnames;
        this.roles = roles;
        this.selects = selects;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    public Object getSwitchItem(int i, int caseSW) {
        // Si es 1 es names, si es 2 es lastnames, si es 3 es role
        switch (caseSW) {
            case 1:
                return names[i];
            case 2:
                return lastnames[i];
            case 3:
                return roles[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String name = names[i];
        String lastname = lastnames[i];
        String role = roles[i];
        String select = selects[i];

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row,null);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvLastName = (TextView) view.findViewById(R.id.tvLastName);
        TextView tvRole = (TextView) view.findViewById(R.id.tvRole);
        TextView tvSelected = (TextView) view.findViewById(R.id.tvSelected);

        Button btnEdit = (Button) view.findViewById(R.id.btnEdit);

        btnEdit.setFocusable(false);
        btnEdit.setFocusableInTouchMode(false);
        btnEdit.setTag(Integer.valueOf(i));

        tvName.setText(name);
        tvLastName.setText(lastname);
        tvRole.setText(role);
        tvSelected.setText(select);


        return view;
    }
}
