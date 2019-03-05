package org.udls.masterweb.ce.gui.components.CentrosMedicos;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CoreRutas.DirectionFinder;
import org.udls.masterweb.ce.core.CoreRutas.DirectionFinderListener;
import org.udls.masterweb.ce.model.Route;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContenedorMapa extends AppCompatActivity implements OnMapReadyCallback, DirectionFinderListener   {

//    Button btnLocalizar;
//    SupportMapFragment fragmentMap;
//    private GoogleMap googleMap;
//    double Longitud;
//    double Latitud;
//    private Circle circle;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_contenedor_mapa);
//        revisarPermisos();
//        //BÓTON ATRAS
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//    }
//
//
//    private void inicializar()
//    {
//        btnLocalizar = (Button) findViewById(R.id.btnFindPath);
//        btnLocalizar.setEnabled(false);
//        btnLocalizar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar snackbar = Snackbar.make(view, "Trazando ruta ..", Snackbar.LENGTH_LONG);
//
//                //ACTION
//                snackbar.setActionTextColor(getResources().getColor(R.color.VVIVO));
//                View snackBarView = snackbar.getView();
//                //BACKGROUND
//                snackBarView.setBackgroundColor(getResources().getColor(R.color.VERDE));
//                //MESSAGE
//                TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
//                tv.setTextColor(getResources().getColor(R.color.NEGRO));
//
//                snackbar.show();
//                trazarRuta();
//            }
//        });
//
//        //Obtenemos el Fragment que despliega el Mapa:
//        fragmentMap = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//
//        //Aquí realizamos la inicialización que deseemos una vez que obtenemos el mapa:
//        fragmentMap.getMapAsync(new OnMapReadyCallback() {
//
//            @Override
//            public void onMapReady(GoogleMap _googleMap) {
//                googleMap = _googleMap;
//                ubicarCentroMedico();
//                btnLocalizar.setEnabled(true);
//            }
//        });
//    }
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return false;
//    }
//
//    public  void revisarPermisos() {
//        if (Build.VERSION.SDK_INT >= 23)
//        {
//            if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED &&
//                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
//                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
//            {
//                Log.i("info","Permisos necesarios concedidos.");
//                inicializar();
//            } else {
//
//                Log.i("info","Permisos necesarios por conceder.");
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//            }
//        }
//        else
//        { //permission is automatically granted on sdk<23 upon installation
//            Log.i("info","Permission is granted");
//            inicializar();
//        }
//
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(grantResults != null && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
//            Log.i("info","Permission: "+permissions[0]+ "was "+grantResults[0]);
//            try
//            {
//                inicializar();
//            }
//            catch (Exception ex)
//            {
//
//            }
//        }
//    }
//
//    private void ubicarCentroMedico()
//    {
//        LocationManager locationManager = (LocationManager) this.getSystemService(getApplicationContext().LOCATION_SERVICE);
//        try
//        {
//            //Drawable drwImagen = null;
//            //drwImagen = CodificadorImagenes.decodificar(getIntent().getExtras().getString("Imagen"));
//            Bitmap icon = BitmapFactory.decodeResource(getResources(),
//                    R.drawable.iconmap);
//            Longitud = getIntent().getExtras().getDouble("Longitud");
//            Latitud = getIntent().getExtras().getDouble("Latitud");
//            LatLng coordenadas = new LatLng(Latitud, Longitud);
//
//            CameraUpdate centro = CameraUpdateFactory.newLatLng(coordenadas);
//            CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);
//
//            MarkerOptions marcadorDestino= new MarkerOptions();
//            marcadorDestino.position(coordenadas);
//            marcadorDestino.title(getIntent().getExtras().getString("Nombre"));
//            marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(icon));
//
//            googleMap.addMarker(marcadorDestino);
//            googleMap.moveCamera(centro);
//
//            googleMap.animateCamera(zoom);
//            googleMap.setMyLocationEnabled(true);
//            circle = googleMap.addCircle(new CircleOptions()
//                    .center(new LatLng(Latitud, Longitud))
//                    .radius(20)
//                    .strokeWidth(2)
//                    .strokeColor(Color.GREEN)
//                    .fillColor(Color.argb(128, 255, 0, 0))
//                    .clickable(true));
//        }
//        catch (SecurityException ex)
//        {
//            ex.printStackTrace();
//        }
//    }
//
//    private void trazarRuta()
//    {
//
//        LocationManager locationManager = (LocationManager) this.getSystemService(getApplicationContext().LOCATION_SERVICE);
//      Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//  try
//        {
//            Bitmap icon = BitmapFactory.decodeResource(getResources(),
//                    R.drawable.iconmap);
//
//            Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            Longitud = getIntent().getExtras().getDouble("Longitud");
//            Latitud = getIntent().getExtras().getDouble("Latitud");
//
//            LatLng ORIGEN = new LatLng(l.getLatitude(), l.getLongitude());
//            LatLng DESTINO = new LatLng(Latitud, Longitud);
//
//            LatLng coordenadas = new LatLng(Latitud, Longitud);
//            CameraUpdate centro = CameraUpdateFactory.newLatLng(coordenadas);
//            CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
//
//            //MARCADOR ORIGEN
//            googleMap.addMarker(new MarkerOptions().position(new  LatLng(l.getLatitude(), l.getLongitude())));
//            //MARCADOR DESTINO
//            MarkerOptions marcadorDestino= new MarkerOptions();
//            marcadorDestino.position(ORIGEN);
//            marcadorDestino.title("Yo!");
//            marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(icon));
//
//            googleMap.addMarker(marcadorDestino);
//            googleMap.moveCamera(centro);
//            googleMap.animateCamera(zoom);
//            circle = googleMap.addCircle(new CircleOptions()
//                    .center(new LatLng(l.getLatitude(), l.getLongitude()))
//                    .radius(20)
//                    .strokeWidth(2)
//                    .strokeColor(Color.YELLOW)
//                    .fillColor(Color.argb(128, 255, 0, 0))
//                    .clickable(true));
//            LatLng madrid = new LatLng(40.417325, -3.683081);
//
//            CameraPosition camPos = new CameraPosition.Builder()
//                    .target(ORIGEN)
//                    .zoom(19)         //Establecemos el zoom en 19
//                    .bearing(45)      //Establecemos la orientación con el noreste arriba
//                    .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
//                    .build();
//
//            CameraUpdate camUpd3 =
//                    CameraUpdateFactory.newCameraPosition(camPos);
//
//            googleMap.animateCamera(camUpd3);
//
//        }
//        catch (SecurityException ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    private GoogleMap mMap;
    private Button btnFindPath;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    private double Longitud;
    private double Latitud;
    private Circle circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }
    @Override
     public boolean onSupportNavigateUp() {
          onBackPressed();
           return false;
    }
    private void sendRequest() {
        String DireccionOrigen = "";
        String DireccionDestino = "";
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                Log.i("info","Permisos necesarios concedidos.");
            } else {

                Log.i("info","Permisos necesarios por conceder.");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        LocationManager locationManager = (LocationManager) this.getSystemService(getApplicationContext().LOCATION_SERVICE);
        Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        try
        {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> list = geocoder.getFromLocation(l.getLatitude(), l.getLongitude(), 1);
            if (!list.isEmpty()) {
                Address address = list.get(0);
                DireccionOrigen = address.getAddressLine(0);
            }
             DireccionDestino = getIntent().getExtras().getString("Direccion");
        }
        catch (Exception e)
        {
            Log.i("info", e.getMessage());
        }

        try {
            new DirectionFinder(this, DireccionOrigen, DireccionDestino).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bitmap icon = BitmapFactory.decodeResource(getResources(),  R.drawable.iconmap);
        Longitud = getIntent().getExtras().getDouble("Longitud");
        Latitud = getIntent().getExtras().getDouble("Latitud");

        LatLng coordenadas = new LatLng(Latitud, Longitud);
        CameraUpdate centro = CameraUpdateFactory.newLatLng(coordenadas);
        CameraUpdate zoom =CameraUpdateFactory.zoomTo(17);

        MarkerOptions marcadorDestino= new MarkerOptions();
        marcadorDestino.position(coordenadas);
        marcadorDestino.title(getIntent().getExtras().getString("Nombre"));
        marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(icon));

        mMap.addMarker(marcadorDestino);
        mMap.moveCamera(centro);
        mMap.animateCamera(zoom);
        circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(Latitud, Longitud))
                .radius(35)
                .strokeWidth(5)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(100, 250, 150)));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        mMap.setMyLocationEnabled(true);
    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Por favor espere.",
                "Buscando ruta..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                Log.i("info","Permisos necesarios concedidos.");
            } else {

                Log.i("info","Permisos necesarios por conceder.");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        LocationManager locationManager = (LocationManager) this.getSystemService(getApplicationContext().LOCATION_SERVICE);
        Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        mMap.clear();
        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);
            circle = mMap.addCircle(new CircleOptions()
                    .center(new LatLng(Latitud, Longitud))
                    .radius(35)
                    .strokeWidth(5)
                    .strokeColor(Color.GREEN)
                    .fillColor(Color.rgb(100, 250, 150)));
            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmap))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmap))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            LatLng ORIGEN = new LatLng(l.getLatitude(), l.getLongitude());
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(ORIGEN)
                    .zoom(19)         //Establecemos el zoom en 19
                    .bearing(25)      //Establecemos la orientación con el noreste arriba
                    .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                    .build();

            CameraUpdate camUpd3 =
                    CameraUpdateFactory.newCameraPosition(camPos);

            mMap.animateCamera(camUpd3);
            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.YELLOW).
                    width(20);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }

}
