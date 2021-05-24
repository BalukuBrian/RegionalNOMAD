package com.balbrilabs.regionalnomad.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.balbrilabs.regionalnomad.R;

public class Inventory extends AppCompatActivity {

    private Button save_inventory;
    private Button upload_inventory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);


        save_inventory = findViewById(R.id.save_inventory);
        upload_inventory = findViewById(R.id.upload_inventory);

        //saving
        save_inventory.setOnClickListener(v -> {

            Toast.makeText(Inventory.this, "Saving Data", Toast.LENGTH_SHORT).show();
        });


        //uploading
        upload_inventory.setOnClickListener(v -> {

            Toast.makeText(Inventory.this, "Uploading to the Head of Biomedical Department ", Toast.LENGTH_SHORT).show();
        });



    }
}
