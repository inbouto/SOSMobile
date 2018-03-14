package com.SOS_Application.heu1.sosmobile;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.SOS_Application.R;
import com.SOS_Application.mapGoogle.MapsActivitySos;


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

        LocationManager locationManager;
        locationManager = (LocationManager) PageUrgence.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                String lat = Double.toString(location.getLatitude());
                String lon = Double.toString(location.getLongitude());

                // /!\ JIMMY C'EST LA QU'IL FAUT ENVOYER LES INFOS AU SERVEUR /!\

                Toast.makeText(PageUrgence.this, "Votre position a bien été signalée", Toast.LENGTH_LONG).show();
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Erreur : permission non accordée", Toast.LENGTH_LONG).show();
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    // /!\ JIMMY C'EST DANS CETTE METHODE QU'IL FAUT QUE TU METTES LE NOM DE TA PAGE QUI AFFICHE LES DEFIBRILLATEURS SUR GOOGLE MAPS /!\
    public void onClickDefibrilateurs(View v) {
        Intent PageGPS = new Intent(PageUrgence.this, MapsActivitySos.class);
        startActivity(PageGPS);
    }
}

