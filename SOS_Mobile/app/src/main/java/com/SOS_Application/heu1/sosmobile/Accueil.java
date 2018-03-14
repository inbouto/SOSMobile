package com.SOS_Application.heu1.sosmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import com.SOS_Application.R;
import com.SOS_Application.mapGoogle.HandlerSOS;

public class Accueil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos_accueil);
        new Thread(new HandlerSOS(this)).start();
    }

    private void inscription(View v) {

    }

    public void appelUrgenceActivity(View view) {
        Intent PageUrgence = new Intent(Accueil.this, PageUrgence.class);
        startActivity(PageUrgence);
    }

    public void connexion(View view){

    }


    public void vibrer(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(500); // for 500 ms
        }
    }
    public void notificationSOS(){

    }

}
