package com.Gaurav.percentage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butcon;
    EditText etname, etan, etiot, etweb;
    TextView tvresult;
    String status="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butcon = findViewById(R.id.butcon);
        etname = findViewById(R.id.txtName);
        etan = findViewById(R.id.amarks);
        etiot = findViewById(R.id.iot);
        etweb = findViewById(R.id.web);
        tvresult = findViewById(R.id.result);
        //tvresult.append(" Name:      " + " Android:  " + " IOT:      " + " web:       " + "percentage " + "result" + "\n");
        butcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.butcon) {
            if (TextUtils.isEmpty(etname.getText().toString())) {
                etname.setError("Please enter name");
                return;
            } else if (TextUtils.isEmpty(etan.getText().toString())) {
                etname.setError("Please enter marks of Android");
                return;
            } else if (TextUtils.isEmpty(etiot.getText().toString())) {
                etname.setError("Please enter marks of IOT");
                return;
            } else if (TextUtils.isEmpty(etweb.getText().toString())) {
                etname.setError("Please enter marks of WEB");
                return;
            } else {
                tvresult.append(("Name: " +etname.getText().toString()) + " | Android: " + (etan.getText().toString()) + " | IOT: " + (etan.getText().toString()) + " | web: " + (etan.getText().toString()) +
                        " | percentage "+percentage()+ " | status "+status+"\n");
                Clear();
            }
        }

    }


    public double percentage() {

        double android = 0, iot = 0, web = 0;
        android = Double.parseDouble(etan.getText().toString());
        iot=Double.parseDouble(etan.getText().toString());
        web = Double.parseDouble(etan.getText().toString());
        double per = (android + iot + web) / 3;
        if ((android >= 40) && (iot >= 40) && (web >= 40)) {
            status = "Pass";
        } else {
            status = "fail";
        }

        return per;
    }

    public void Clear() {
        etname.setText("");
        etan.setText("");
        etiot.setText("");
        etweb.setText("");
    }
}
