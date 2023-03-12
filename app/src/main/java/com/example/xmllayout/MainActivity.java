package com.example.xmllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText txtCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.RbGroup);
        Button btn = findViewById(R.id.btnCalculate);
        RadioButton rbOk = findViewById(R.id.rdoOk);
        txtCost = findViewById(R.id.txtCostOfService);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double costOfService;
                double tipAmount;
                double tipPercentage;

                if(txtCost.getText().equals("")){
                    txtCost.setError("Enter cost of service");
                }

                int checkedId = rg.getCheckedRadioButtonId();
                if(checkedId<0){
                    rbOk.setError("Select service type");
                    return;
                }
                try {
                    costOfService = Integer.getInteger(String.valueOf(txtCost.getText()));
                }catch(Exception ex){
                    txtCost.setError("Invalid cost of Service");
                    return;
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.rdoAmazing:
                        Toast.makeText(MainActivity.this, "Amazing clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoGood:
                        Toast.makeText(MainActivity.this, "Good clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoOk:
                        Toast.makeText(MainActivity.this, "Ok clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}