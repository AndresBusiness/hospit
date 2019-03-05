package org.udls.masterweb.ce.gui.components.CentrosMedicos;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CodificadorImagenes;
import org.udls.masterweb.ce.gui.components.Doctores.MainDoctores;
public class DetalleCentroMedico extends AppCompatActivity {
    //DECLARACIÓN DE LAS PROPIEDADES
    TextView NombreCentroMedico;
    TextView Direccion;
    TextView Telefono;
    TextView Correo;
    TextView Horario;
    TextView Tipo;
    ImageView Imagen;
    TextView TXTDireccion;
    TextView TXTTelefono;
    TextView TXTCorreo;
    TextView TXTHorario;
    private Typeface Learners2;
    private Typeface Song2;
    Context context;
    String Longitud;
    String Latitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_centro_medico);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),  ContenedorMapa.class);
                intent.putExtra("Longitud",  getIntent().getExtras().getDouble("Longitud"));
                intent.putExtra("Latitud", getIntent().getExtras().getDouble("Latitud"));
                intent.putExtra("Nombre",getIntent().getExtras().getString("Nombre"));
                intent.putExtra("Direccion",getIntent().getExtras().getString("Direccion"));
                view.getContext().startActivity(intent);
            }
        });

        //ASIGNACIÓN DE PROPIEDADES A LOS ELEMENTOS DE LA VISTA
        NombreCentroMedico = (TextView)findViewById(R.id.idNombreCM);
        Direccion  = (TextView)findViewById(R.id.idDireccionCM);
        Telefono  = (TextView)findViewById(R.id.idTelefonoCM);
        Correo  = (TextView)findViewById(R.id.idCorreoCM);
        Horario  = (TextView)findViewById(R.id.idHorarioCM);
        Tipo  = (TextView)findViewById(R.id.idTipoCM);
        Imagen = (ImageView)findViewById(R.id.idImagenMC);

        TXTDireccion = (TextView)findViewById(R.id.txtDireccion);
        TXTTelefono = (TextView)findViewById(R.id.txtTelefono);
        TXTCorreo = (TextView)findViewById(R.id.txtCorreo);
        TXTHorario = (TextView)findViewById(R.id.txtHorario);

        //RECUPERAR DATOS
        NombreCentroMedico.setText(getIntent().getExtras().getString("Nombre"));
        Direccion.setText(getIntent().getExtras().getString("Direccion"));
        Telefono.setText(getIntent().getExtras().getString("Telefono"));
        Correo.setText(getIntent().getExtras().getString("Correo"));
        Horario.setText(getIntent().getExtras().getString("Horarios"));
        Tipo.setText(getIntent().getExtras().getString("Tipo"));

        //AGREGAR FUENTE A LOS ELEMENTOS
        this.Learners2 = Typeface.createFromAsset(this.getAssets(), "fuentes/Learners.ttf");
        this.Song2 = Typeface.createFromAsset(this.getAssets(), "fuentes/Song.ttf");
        NombreCentroMedico.setTypeface(Song2);
        Direccion.setTypeface(Learners2);
        Telefono.setTypeface(Learners2);
        Correo.setTypeface(Learners2);
        Horario.setTypeface(Learners2);
        Tipo.setTypeface(Learners2);
        TXTDireccion.setTypeface(Learners2);
        TXTCorreo.setTypeface(Learners2);
        TXTHorario.setTypeface(Learners2);
        TXTTelefono.setTypeface(Learners2);

        Drawable drwImagen = null;
        drwImagen = CodificadorImagenes.decodificar(getIntent().getExtras().getString("Imagen"));

        if(drwImagen !=null){
            Imagen.setImageDrawable(drwImagen);
        }
        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_centro_medico, menu);
        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.BLANCO), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        int id = item.getItemId();
        if (id == R.id.idVerEspecialistas) {
            i = new Intent(this, MainDoctores.class);
            i.putExtra("id",getIntent().getExtras().getInt("id"));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
