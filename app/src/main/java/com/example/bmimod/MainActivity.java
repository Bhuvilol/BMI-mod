package com.example.bmimod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView txtresult;
        txtresult = findViewById(R.id.txtresult);

        EditText editweight , editheightft, editheightin;
        editweight = findViewById(R.id.editweight);
        editheightft = findViewById(R.id.editheightft);
        editheightin = findViewById(R.id.editheightin);

        Button btnCalculate;
        btnCalculate = findViewById(R.id.btnCalculate);

        LinearLayout llmain;
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editweight.getText().toString());
                int ft = Integer.parseInt(editheightft.getText().toString());
                int in = Integer.parseInt(editheightin.getText().toString());

                int totalin = (ft*12) + in;
                double totalm = (totalin*2.53)/100;

                double bmi = wt/(totalm*totalm);
                if (bmi>25){
                    txtresult.setText("You are Overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.orange));
                } else if (bmi<18){
                    txtresult.setText("You are Underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.yellow));
                } else {
                    txtresult.setText("You are Healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.green));
                }


//                txtresult.setText("BMI : "+bmi);

            }
        });




    }
}