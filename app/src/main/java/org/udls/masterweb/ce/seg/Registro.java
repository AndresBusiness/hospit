package org.udls.masterweb.ce.seg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CodificadorImagenes;
import org.udls.masterweb.ce.model.Usuario;
import org.udls.masterweb.ce.task.TaskGuardarUsuario;

import java.util.HashMap;

public class Registro extends AppCompatActivity {
    TextView Nombre;
    TextView Telefono;
    TextView Correo;
    TextView Password;
    ImageView imgUsuario;
    Button guardar;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    public static HashMap<String, Object> GLOBALS = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Nombre = (TextView)findViewById(R.id.idNombreRegistro);
        Telefono =  (TextView)findViewById(R.id.idNumeroRegistro);
        Correo = (TextView)findViewById(R.id.idCorreoRegistro);
        Password = (TextView)findViewById(R.id.idPasswordRegistro);
        imgUsuario = (ImageView)findViewById(R.id.IdimagenRegistro);

        guardar = (Button)findViewById(R.id.idBtnRegistrar);
        guardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                guardarAlumno();
            }
        });

        imgUsuario.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seleccionarImagen();
            }
        });



        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void seleccionarImagen()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
        gallery.setType("image/png");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imgUsuario.setImageURI(imageUri);
        }
    }

    private void guardarAlumno()
    {
        long id = 0;
        Usuario a = null;
        TaskGuardarUsuario tga = null;
        Log.i("info", "Invocaste a insertar Usuario(...);");

        try
        {
            a = new Usuario();
            a.setNombre(Nombre.getText().toString());
            a.setTelefono(Telefono.getText().toString());
            a.setCorreo(Correo.getText().toString());
            a.setPassword(Password.getText().toString());

            if (imgUsuario.getDrawable() != null)
                a.setFoto(CodificadorImagenes.codificar(imgUsuario.getDrawable()));
            else
                a.setFoto("");


            tga = new TaskGuardarUsuario(a);
            tga.execute();
            mostrarMensaje("!Se ha guardado con éxito!", Snackbar.LENGTH_LONG);
            Nombre.setText("");
            Telefono.setText("");
            Correo.setText("");
            Password.setText("");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public void mostrarMensaje(String mensaje, int length)
    {
        Snackbar.make(findViewById(android.R.id.content), mensaje, length)
                .show();
    }
}
