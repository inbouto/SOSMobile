package com.SOS_Application.heu1.sosmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.SOS_Application.R;
import com.SOS_Application.currentplacedetailsonmap.MapsActivityCurrentPlace;

public class Accueil extends AppCompatActivity {
    private final MapsActivityCurrentPlace map = new MapsActivityCurrentPlace();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos_accueil);
    }

    public void onClickUrgence(View v) {
        Intent PageUrgence = new Intent(this, PageUrgence.class);
        startActivity(PageUrgence);
    }
}
