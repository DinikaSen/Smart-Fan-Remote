package com.example.dilshan.tabs_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        Spinner spin1 = (Spinner)findViewById(R.id.spinner);
        Spinner spin2 = (Spinner)findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner)findViewById(R.id.spinner3);
        ArrayList<String> speeds=new ArrayList<>();
        speeds.add("Off");
        speeds.add("Low");
        speeds.add("Medium");
        speeds.add("High");
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(AutoActivity.this,
                android.R.layout.simple_list_item_1,speeds);

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(myadapter);
        spin2.setAdapter(myadapter);
        spin3.setAdapter(myadapter);

        spin1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                firstmainpage.getArray()[2]="RANGECONTROL";
//                String selected = parent.getItemAtPosition(pos).toString();
//                firstmainpage.getArray()[6]=selected.toUpperCase();

                firstmainpage.dataChars[2]='2';
                String selected = parent.getItemAtPosition(pos).toString();
                if (selected == "Off"){
                    firstmainpage.dataChars[10]='0';
                } else if (selected == "Low"){
                    firstmainpage.dataChars[10]='1';
                }else if (selected == "Medium"){
                    firstmainpage.dataChars[10]='2';
                }else if (selected == "High"){
                    firstmainpage.dataChars[10]='3';
                }
                firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
            }

            public void onNothingSelected(AdapterView parent) {
                // Do nothing.
            }
        });
        spin2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                String selected = parent.getItemAtPosition(pos).toString();
//                firstmainpage.getArray()[7]=selected.toUpperCase();

                firstmainpage.dataChars[2]='2';
                String selected = parent.getItemAtPosition(pos).toString();
                if (selected == "Off"){
                    firstmainpage.dataChars[11]='0';
                } else if (selected == "Low"){
                    firstmainpage.dataChars[11]='1';
                }else if (selected == "Medium"){
                    firstmainpage.dataChars[11]='2';
                }else if (selected == "High"){
                    firstmainpage.dataChars[11]='3';
                }
                firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
            }

            public void onNothingSelected(AdapterView parent) {
                // Do nothing.
            }
        });
        spin3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                String selected = parent.getItemAtPosition(pos).toString();
//                firstmainpage.getArray()[8]=selected.toUpperCase();

                firstmainpage.dataChars[2]='2';
                String selected = parent.getItemAtPosition(pos).toString();
                if (selected == "Off"){
                    firstmainpage.dataChars[12]='0';
                } else if (selected == "Low"){
                    firstmainpage.dataChars[12]='1';
                }else if (selected == "Medium"){
                    firstmainpage.dataChars[12]='2';
                }else if (selected == "High"){
                    firstmainpage.dataChars[12]='3';
                }
                firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
            }

            public void onNothingSelected(AdapterView parent) {
                // Do nothing.
            }
        });
    }

    public void autoToManual(View view) {
        Intent i = new Intent(this, MainActivity.class);
        //firstmainpage.getArray()[1]="MANUAL";
        firstmainpage.dataChars[1]='1';
        firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
        startActivity(i);
        System.out.println("AutoToManual"+ firstmainpage.dataArray);
    }
    public void changeFanState(View view){
        if (firstmainpage.dataChars[0]=='0'){
            firstmainpage.dataChars[0]='1';
            firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
        }else{
            firstmainpage.dataChars[0]='1';
            firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
        }
        firstmainpage.sendData();
        Toast.makeText(getBaseContext(),"Fan state changed",Toast.LENGTH_LONG).show();
    }
    public void setBtn1Clicked(View view){
        firstmainpage.sendData();
        Toast.makeText(getBaseContext(),"Fan state changed",Toast.LENGTH_LONG).show();
        System.out.println("setFan  "+ firstmainpage.dataArray);
    }


}
