package com.example.dilshan.tabs_test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by dilshan on 10/3/17.
 */

public class tab3online extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3content, container, false);
        Spinner spin1 = (Spinner)rootView.findViewById(R.id.spinner);
        Spinner spin2 = (Spinner)rootView.findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner)rootView.findViewById(R.id.spinner3);


        ArrayList<String>speeds=new ArrayList<>();
        speeds.add("Off");
        speeds.add("Low");
        speeds.add("Medium");
        speeds.add("High");
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,speeds);

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(myadapter);
        spin2.setAdapter(myadapter);
        spin3.setAdapter(myadapter);

        spin1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
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
        return rootView;
    }

}

