package com.swoopsoft.monsterrun;

import static android.hardware.Sensor.TYPE_STEP_COUNTER;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SensorActivity extends Activity implements SensorEventListener {

    public final SensorManager sensorManager;
    public final Sensor pedometer;

    public SensorActivity(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        pedometer = sensorManager.getDefaultSensor(TYPE_STEP_COUNTER);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    };

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}