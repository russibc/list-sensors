package com.example.listagem_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensorLight;
    private TextView mTvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvLight = findViewById((R.id.tvLight));
        mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

        List<Sensor> listSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorListTxt = new StringBuilder();
        for (Sensor s : listSensor) {
            sensorListTxt.append(s.getName()).append(System.getProperty("line.separator"));
        }
        mTvLight.setText(sensorListTxt);
    }

}