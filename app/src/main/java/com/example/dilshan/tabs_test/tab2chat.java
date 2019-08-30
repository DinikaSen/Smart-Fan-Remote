package com.example.dilshan.tabs_test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.FrameMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.goodiebag.protractorview.ProtractorView;

/**
 * Created by dilshan on 10/3/17.
 */

public class tab2chat extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab2content, container, false);

        ProtractorView protractorView1 = (ProtractorView) rootView.findViewById(R.id.proview1);
        ProtractorView protractorView2 = (ProtractorView) rootView.findViewById(R.id.proview2);
        RadioGroup rg = (RadioGroup) rootView.findViewById(R.id.speedradio2);


        protractorView2.setOnProtractorViewChangeListener(new ProtractorView.OnProtractorViewChangeListener() {
            @Override
            public void onProgressChanged(ProtractorView pv, int progress, boolean b) {
                firstmainpage.dataChars[2]='1';
                TextView startangle = (TextView) rootView.findViewById(R.id.startangle);
                startangle.setText(String.valueOf(progress)+"°");
                if (String.valueOf(progress).length()==1){
                    firstmainpage.dataChars[3] = '0';
                    firstmainpage.dataChars[4] = '0';
                    firstmainpage.dataChars[5] = String.valueOf(progress).toCharArray()[0];
                } else if (String.valueOf(progress).length()==2){
                    firstmainpage.dataChars[3] = '0';
                    firstmainpage.dataChars[4] = String.valueOf(progress).toCharArray()[0];
                    firstmainpage.dataChars[5] = String.valueOf(progress).toCharArray()[1];
                } else{
                    firstmainpage.dataChars[3] = String.valueOf(progress).toCharArray()[0];
                    firstmainpage.dataChars[4] = String.valueOf(progress).toCharArray()[1];
                    firstmainpage.dataChars[5] = String.valueOf(progress).toCharArray()[2];
                }
                firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
            }

            @Override
            public void onStartTrackingTouch(ProtractorView pv) {

            }

            @Override
            public void onStopTrackingTouch(ProtractorView pv) {

            }
        });

        protractorView1.setOnProtractorViewChangeListener(new ProtractorView.OnProtractorViewChangeListener() {
            @Override
            public void onProgressChanged(ProtractorView pv, int progress, boolean b) {
                TextView endangle = (TextView) rootView.findViewById(R.id.endangle);
                endangle.setText(String.valueOf(progress)+"°");
                if (String.valueOf(progress).length()==1){
                    firstmainpage.dataChars[6] = '0';
                    firstmainpage.dataChars[7] = '0';
                    firstmainpage.dataChars[8] = String.valueOf(progress).toCharArray()[0];
                } else if (String.valueOf(progress).length()==2){
                    firstmainpage.dataChars[6] = '0';
                    firstmainpage.dataChars[7] = String.valueOf(progress).toCharArray()[0];
                    firstmainpage.dataChars[8] = String.valueOf(progress).toCharArray()[1];
                } else{
                    firstmainpage.dataChars[6] = String.valueOf(progress).toCharArray()[0];
                    firstmainpage.dataChars[7] = String.valueOf(progress).toCharArray()[1];
                    firstmainpage.dataChars[8] = String.valueOf(progress).toCharArray()[2];
                }
                firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
            }

            @Override
            public void onStartTrackingTouch(ProtractorView pv) {

            }

            @Override
            public void onStopTrackingTouch(ProtractorView pv) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView speed2 = (TextView) rootView.findViewById(R.id.speed2);
                switch(checkedId) {
                    case R.id.high:
                        speed2.setText("High");
                        firstmainpage.dataChars[9] = '3';
                        firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
                       // firstmainpage.getArray()[5]="HIGH";
                        break;
                    case R.id.medium:
                        speed2.setText("Medium");
                        firstmainpage.dataChars[9] = '2';
                        firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
                        break;
                    case R.id.low:
                        speed2.setText("Low");
                        firstmainpage.dataChars[9] = '1';
                        firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
                        break;
                    case R.id.off:
                        speed2.setText("Off");
                        firstmainpage.dataChars[9] = '0';
                        firstmainpage.dataArray = String.valueOf(firstmainpage.dataChars);
                        break;
                }
            }
        });

        return rootView;
    }

}
