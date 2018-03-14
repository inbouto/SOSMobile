package com.SOS_Application.mapGoogle;

import android.content.Context;
import android.os.Vibrator;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.SOS_Application.R;
import com.SOS_Application.heu1.sosmobile.Accueil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class HandlerSOS implements Runnable{
    public static List<List<String>> listUrgence = new ArrayList<>();
    public static int referenceTel = 0;
    private Accueil acc = new Accueil();
    private Context context;
    public HandlerSOS(Context c){
        context = c;
    }
    @Override
    public void run() {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            while (true) {
                synchronized (this) {
                    wait(30 * 1000);
                    DatabaseReference myRef = database.getReference("sos");
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if (snapshot.getChildrenCount() > 0) {
                                Log.e("Count ", "" + snapshot.getChildrenCount());

                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    if (postSnapshot.child("trait").getValue(String.class).equals("0") &&
                                            !(postSnapshot.child("ref").getValue(String.class).equals(HandlerSOS.referenceTel))) {
                                        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                                        // Vibrate for 500 milliseconds
                                        v.vibrate(500);
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("The read failed: ", databaseError.getMessage());
                        }

                    });
                }
            }
        }catch(NullPointerException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public int getReferenceTel(){
        return this.referenceTel;
    }

    public void setReferenceTel(int n){
        this.referenceTel = n;
    }
}
