package com.SOS_Application.heu1.sosmobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.SOS_Application.R;
import com.SOS_Application.currentplacedetailsonmap.MapsActivityCurrentPlace;

public class PageUrgence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos_page_urgence);
    }

    public void onClickAppel(View v) {
        String tel = "15";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + tel));
        startActivity(callIntent);
    }

    public void onClickSignal(View v) {
        Intent PageConfirmationSignalement = new Intent(this, PageConfirmationSignalement.class);
        startActivity(PageConfirmationSignalement);
    }

    public void onClickDefibrilateurs(View v) {
        Intent MapsActivityCurrentPlace = new Intent(this, MapsActivityCurrentPlace.class);
        startActivity(MapsActivityCurrentPlace);
    }
}
