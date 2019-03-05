package org.udls.masterweb.ce.gui.components.Doctores;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.task.TaskConsultarDoctores;

import java.util.HashMap;

public class MainDoctores extends AppCompatActivity {

    public static HashMap<String, Object> GLOBALS = new HashMap<>();
    ViewAdapterDoctor vpam;

    ViewPager viewPagerMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctores);
        if (Build.VERSION.SDK_INT >= 23)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.INTERNET}, 1);
        else
            inicializarComponentes();
        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
    private void inicializarComponentes()
    {
        GLOBALS.put("app", this);
        viewPagerMain = (ViewPager) findViewById((R.id.viewPagerMainDoctor));

        vpam = new ViewAdapterDoctor(getSupportFragmentManager());
        viewPagerMain.setAdapter(vpam);
        TaskConsultarDoctores tca = null;

            try
            {
                ListadoDoctores objListado = new ListadoDoctores();
                objListado.setIdDoctor(getIntent().getExtras().getInt("id"));
                tca = new TaskConsultarDoctores(getIntent().getExtras().getInt("id"));
                tca.execute();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                mostrarMensaje("Error al actualizar listado de centros médicos.", Snackbar.LENGTH_LONG);
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

    public ViewAdapterDoctor getViewPagerAdapter()
    {
        return vpam;
    }



}
