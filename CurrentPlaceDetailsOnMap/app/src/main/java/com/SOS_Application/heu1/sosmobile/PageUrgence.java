package com.SOS_Application.heu1.sosmobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.SOS_Application.R;
import com.SOS_Application.currentplacedetailsonmap.MapsActivityCurrentPlace;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        Intent PageConfirmationSignalement = new Intent(PageUrgence.this, PageConfirmationSignalement.class);
        startActivity(PageConfirmationSignalement);
    }


// à ajouter avec le code de la page d’affichage des défibrilateurs // sur la map
    public void onClickDefibrilateurs(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("positionDefri");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.e("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    for (DataSnapshot postSnapshot2: snapshot.getChildren()) {
                        String post = postSnapshot2.getValue(String.class);
                        Log.e("Get Data", post);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("The read failed: " ,databaseError.getMessage());
            }

        });

        Intent MapsActivityCurrentPlace = new Intent(PageUrgence.this, MapsActivityCurrentPlace.class);

        startActivity(MapsActivityCurrentPlace);


    }
}
