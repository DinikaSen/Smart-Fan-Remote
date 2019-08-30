package com.example.dilshan.tabs_test;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class firstmainpage extends AppCompatActivity {

    public static String dataArray;
    public static char[] dataChars;
    private static final int REQUEST_ENABLE_BT = 1;
    private static BluetoothAdapter btAdapter = null;
    private static BluetoothSocket btSocket = null;
    private static BluetoothDevice mmDevice;
    private static OutputStream outStream = null;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // private static String address = "00:00:00:00:00:00";

    public void goToManual(View view) {
        Intent i = new Intent(this, MainActivity.class);
        dataChars[1] = '1';
        dataArray = String.valueOf(dataChars);
        System.out.println("goToManual "+dataArray);
        startActivity(i);
    }

    public void goToAuto(View view) {
        Intent i = new Intent(this, AutoActivity.class);
        dataChars[1] = '2';
        dataArray = String.valueOf(dataChars);
        System.out.println("goToAuto "+(dataArray));
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        dataArray = "1000000000000";
        dataChars = dataArray.toCharArray();
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();
        if (btAdapter != null) {
            System.out.println("Bt adapter not null");
            if (btAdapter.isEnabled()) {
                System.out.println("Bt adapter enabled");
                Set<BluetoothDevice> bondedDevices = btAdapter.getBondedDevices();

                if (bondedDevices.size() > 0) {
                    for (BluetoothDevice dev : bondedDevices) {
                        if (dev.getName().equals("SLAVE1")) {
                            System.out.println("SLAVE DETECTED");
                            mmDevice = dev;
                            break;
                        }
                    }
                }
                    try {
                        System.out.println("In TRY");
                        btSocket = mmDevice.createRfcommSocketToServiceRecord(MY_UUID);
                        System.out.println("after .....");
                        btSocket.connect();
                        System.out.println("Bt socket connected");
                    } catch (IOException e) {
                        System.out.println("In catch");
                        e.printStackTrace();
                    }
                }
                System.out.println("Connected");
            } else {
                System.out.println("Bluetooth is disabled.");
            }

//        btSocket = device.createRfcommSocketToServiceRecord(uuids[0].getUuid());
//        socket.connect();
//        checkBTState();


        }

    public void changeFanState(View view){
//   dataChars[1] = '1';
       // dataArray = String.valueOf(dataChars);
        if (dataChars[0]=='1'){
            dataChars[0]='0';
            dataArray = String.valueOf(dataChars);
        }else{
            dataChars[0]='1';
            dataArray = String.valueOf(dataChars);
        }
        sendData();
        Toast.makeText(getBaseContext(),"Fan state changed",Toast.LENGTH_LONG).show();
        System.out.println("changeFanState "+(dataArray));
    }
    private void checkBTState() {
        if (btAdapter == null) {
            errorExit("Fatal Error", "Bluetooth Not supported. Aborting.");
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                // Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }

    private void errorExit(String title, String message) {
        Toast msg = Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_SHORT);
        msg.show();
        finish();
    }

    public static void sendData() {
        if (btSocket != null) {
            try {
                // Create the command that will be sent to arduino.
                //String value = Arrays.toString(dataArray);
                // String must be converted in its bytes to be sent on serial
                // communication
                //System.out.println("DATA SENT __________________________________: "+dataArray);
                btSocket.getOutputStream().write(dataArray.getBytes());
                System.out.println("DATA SENT __________________________________: "+dataArray);
            } catch (IOException e) {
            }
        } else {
            System.out.println("In ELse");
        }
    }

    public static String getArray(){
        return dataArray;
    }
}
