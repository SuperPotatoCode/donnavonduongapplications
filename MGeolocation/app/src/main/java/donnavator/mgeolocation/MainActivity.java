package donnavator.mgeolocation;

import android.content.Context;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

        TextView textLat;
        TextView textLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLat = (TextView) findViewById(R.id.textLat);
        textLong = (TextView) findViewById(R.id.textLong);

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location lastLocation;
        lastLocation = LocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(lastLocation != null)
        {
            textLat.setText(Double.toString(lastLocation.getLatitude()));
            textLong.setText(Double.toString(lastLocation.getLongitude()));
        }

        LocationListener ll = new myLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);

    }
        class myLocationListener implements LocationListener{

            @Override
            public void onLocationChanged(Location location) {
                if(location != null)
                {
                    double pLong = location.getLongitude();
                    double pLat = location.getLatitude();

                    textLat.setText(Double.toString(pLat));
                    textLong.setText(Double.toString(pLong));
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
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
}
