package com.balbrilabs.regionalnomad.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.balbrilabs.regionalnomad.R;

public class MainActivity extends AppCompatActivity {

    private Button login_button_login;
    private EditText id_login;
    private EditText incharge_login;
    private EditText health_facility_login;
    private EditText hospital_login;
    private EditText regional_referral_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button_login = findViewById(R.id.login_button_login);
        id_login = findViewById(R.id.id_login);
        incharge_login = findViewById(R.id.incharge_login);
        health_facility_login = findViewById(R.id.health_facility_login);
        hospital_login = findViewById(R.id.hospital_login);
        regional_referral_login = findViewById(R.id.regional_referral_login);


        login_button_login.setOnClickListener(v -> {

            String idLogin = this.id_login.getText().toString().trim();
            String inchargeLogin = this.incharge_login.getText().toString().trim();
            String healthFacilityLogin = this.health_facility_login.getText().toString().trim();
            String hospitalLogin = this.hospital_login.getText().toString().trim();
            String regionalReferralLogin = this.regional_referral_login.getText().toString().trim();

            if(TextUtils.isEmpty(idLogin)){
                this.id_login.setError("ID Field Required..");
                return;
            }

            if(TextUtils.isEmpty(inchargeLogin)){
                this.incharge_login.setError("Name of Incharge Field Required..");
                return;
            }

            if(TextUtils.isEmpty(healthFacilityLogin)){
                this.health_facility_login.setError("Name of health Facility is Required..");
                return;
            }

            if(TextUtils.isEmpty(hospitalLogin)){
                this.hospital_login.setError("Name of Hospital is Required..");
                return;
            }

            if(TextUtils.isEmpty(regionalReferralLogin)){
                this.regional_referral_login.setError("Name of regional Referral is Required..");
                return;
            }

            Toast.makeText(MainActivity.this, "Log In Button clicked", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), Inventory.class);
            startActivity(intent);
            finish();



        });

    }


}