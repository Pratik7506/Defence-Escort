package com.example.defenceescortmain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EligibilityCriteria extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner1;

    private EditText ageValue;

    private String qualification;
    private String force;

    private Button checkEligible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility_criteria);

        spinner = findViewById(R.id.spinner);

        ageValue = findViewById(R.id.eligiblity_age);

        checkEligible = findViewById(R.id.checkButton);// check button



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.qualification_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////                Toast.makeText(EligibilityCriteria.this,spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
//                  qualification = spinner.getSelectedItem().toString();
//                  String age = ageValue.getText().toString().trim();
//                  if (!age.isEmpty()){
//                      showResult(qualification, Float.parseFloat(age));// it called every time the selection is changed
//                  }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.force_array, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////                Toast.makeText(EligibilityCriteria.this,spinner1.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
//                force = spinner1.getSelectedItem().toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        checkEligible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qualification = spinner.getSelectedItem().toString();
                int force = spinner1.getSelectedItemPosition();

                //Toast.makeText(EligibilityCriteria.this,,Toast.LENGTH_SHORT).show();


                if (ageValue.getText().toString().isEmpty()){

                    Toast.makeText(EligibilityCriteria.this,"Age cannot be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                float age = Float.parseFloat(ageValue.getText().toString());
                showResult(qualification, age, force);

            }
        });



    }

    // age values correct kar lena or toast me sahi value daal dena

    public void showResult(String qualification, float age, int force){


        switch (force){
            case 0:
                if (qualification.equals("12th Pass") && age > 16.5 && age < 19.5 ){
                    Toast.makeText(EligibilityCriteria.this,"You can go for NDA", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EligibilityCriteria.this,"You are not eligible for anything jaa soja", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                Toast.makeText(EligibilityCriteria.this,"Indian Air force", Toast.LENGTH_SHORT).show();

            case 2:
                if (qualification.equals("Engineering // BTech // B.E") && age > 19 && age < 24 ){
                    Toast.makeText(EligibilityCriteria.this,"You can go for INET", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EligibilityCriteria.this,"You are not eligible for anything jaa soja", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(EligibilityCriteria.this,"You are not eligible for anything jaa soja", Toast.LENGTH_SHORT).show();
                break;



        }


    }
}