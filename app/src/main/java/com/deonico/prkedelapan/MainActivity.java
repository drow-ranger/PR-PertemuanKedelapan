package com.deonico.prkedelapan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner menu = findViewById(R.id.spMenu);
        final Button ok = findViewById(R.id.btnOK);

        String[] strMenu = {"Berita",
                "Pop",
                "None"};

        ArrayAdapter Adptrmenu = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                strMenu);

        menu.setAdapter(Adptrmenu);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newForm = new Intent(MainActivity.this,
                        ResultActivity.class);
                newForm.putExtra("menu",
                        menu.getSelectedItem().toString());
                startActivity(newForm);
            }
        });

    }
}
