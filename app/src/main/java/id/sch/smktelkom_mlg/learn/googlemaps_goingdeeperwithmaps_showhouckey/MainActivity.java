package id.sch.smktelkom_mlg.learn.googlemaps_goingdeeperwithmaps_showhouckey;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition YOGYAKARTA = CameraPosition.builder()
            .target(new LatLng(-7.875385, 110.426209))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions Yogya;
    MarkerOptions Sleman;
    MarkerOptions Bantul;
    MarkerOptions GunungKidul;
    MarkerOptions KulonProgo;

    @Override
    public Resources getResources() {
        return super.getResources();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Yogya = new MarkerOptions()
                .position(new LatLng(-7.795580, 110.369490))
                .title("Yogyakarta City")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Sleman = new MarkerOptions()
                .position(new LatLng(-7.732521, 110.402376))
                .title("Sleman")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Bantul = new MarkerOptions()
                .position(new LatLng(-7.919017, 110.378544))
                .title("Bantul")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        GunungKidul = new MarkerOptions()
                .position(new LatLng(-8.030509, 110.616892))
                .title("Gunung Kidul")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        KulonProgo = new MarkerOptions()
                .position(new LatLng(-7.826680, 110.164085))
                .title("Kulon Progo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(Yogya);
        m_map.addMarker(Sleman);
        m_map.addMarker(Bantul);
        m_map.addMarker(GunungKidul);
        m_map.addMarker(KulonProgo);
        flyTo(YOGYAKARTA);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}