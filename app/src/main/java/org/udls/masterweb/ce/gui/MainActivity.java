package org.udls.masterweb.ce.gui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.gui.components.CentrosMedicos.ViewPagerAdapterMain;
import org.udls.masterweb.ce.seg.LoginActivity;
import org.udls.masterweb.ce.seg.Perfil;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity  {

    public static HashMap<String, Object> GLOBALS = new HashMap<>();
    Toolbar tlbPrincipal;
    TabLayout tabLayout;
    ViewPager viewPagerMain;
    ViewPagerAdapterMain vpam;
    MenuItem mnuiBuscar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 23)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.INTERNET}, 1);
        else
            inicializarComponentes();
    }
    private void inicializarComponentes()
    {
        final MainActivity app = this;
        GLOBALS.put("app", this);
        tlbPrincipal = (Toolbar) findViewById(R.id.tlbPrincipal);
        viewPagerMain = (ViewPager) findViewById((R.id.viewPagerMain));
        vpam = new ViewPagerAdapterMain(getSupportFragmentManager());
        viewPagerMain.setAdapter(vpam);
        setSupportActionBar(tlbPrincipal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_perfil:
                Intent i = new Intent(MainActivity.this, Perfil.class);
                startActivity(i);
                return true;
            case R.id.action_cierre_sesion:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mostrarMensaje(String mensaje, int length)
    {
        Snackbar.make(findViewById(android.R.id.content), mensaje, length)
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults != null && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.i("info","Permission: "+permissions[0]+ "was "+grantResults[0]);
            try
            {
                inicializarComponentes();
            }
            catch (Exception ex)
            {
                mostrarMensaje(ex.toString(), Snackbar.LENGTH_LONG);
            }
        }
    }

    public ViewPagerAdapterMain getViewPagerAdapter()
    {
        return vpam;
    }

}

