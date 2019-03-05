package org.udls.masterweb.ce.seg;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.model.Usuario;

import java.util.HashMap;

public class Perfil extends AppCompatActivity {
    public static HashMap<String, Object> GLOBALS = new HashMap<>();
    private EditText Nombre;
    private EditText Password;
    private EditText Telefono;
    private EditText Correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Nombre = (EditText)findViewById(R.id.idNombrePerfil);
        Password = (EditText)findViewById(R.id.iPassPerfil);
        Telefono = (EditText)findViewById(R.id.idTelefonoPerfil);
        Correo = (EditText)findViewById(R.id.idEmailPerfil);



        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
    public void PasarDatos(Usuario data) throws Exception
    {
        Nombre.setText(data.getNombre());
        Password.setText(data.getPassword());
        Telefono.setText(data.getTelefono());
        Correo.setText(data.getCorreo());
    }
    public void mostrarMensaje(String mensaje, int length)
    {
        Snackbar.make(findViewById(android.R.id.content), mensaje, length)
                .show();
    }
}
