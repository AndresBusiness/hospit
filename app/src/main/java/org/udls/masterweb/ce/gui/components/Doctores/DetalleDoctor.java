package org.udls.masterweb.ce.gui.components.Doctores;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CodificadorImagenes;

public class DetalleDoctor extends AppCompatActivity {
    TextView NombreDoc;
    TextView Especialidad;
    TextView Experienecia;
    TextView Puntos;
    TextView Cedula;
    ImageView Imagen;
    private Typeface Learners2;
    private Typeface Song2;
    private Button btnPuntos;
    private Button btnCita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_doctor);

        //ASIGNACIÓN DE PROPIEDADES A LOS ELEMENTOS DE LA VISTA
        NombreDoc = (TextView)findViewById(R.id.idNombreDoctor);
        Especialidad  = (TextView)findViewById(R.id.idEspecialidadDoc);
        Experienecia  = (TextView)findViewById(R.id.idExperienciaDoc);
        Puntos  = (TextView)findViewById(R.id.idPuntos);
        Cedula  = (TextView)findViewById(R.id.idCedula);
        Imagen = (ImageView)findViewById(R.id.idImagenDoc);

        //RECUPERAR DATOS
        NombreDoc.setText(getIntent().getExtras().getString("NombreDoc"));
        Especialidad.setText(getIntent().getExtras().getString("Especialidad"));
        Experienecia.setText(getIntent().getExtras().getString("Experiencia"));
        Puntos.setText("Puntos: " + getIntent().getExtras().getInt("Puntos"));
        Cedula.setText("Cédula Profeional: " + getIntent().getExtras().getString("Cedula"));
        Drawable drwImagen = null;
        drwImagen = CodificadorImagenes.decodificar(getIntent().getExtras().getString("Imagen"));

        if(drwImagen !=null){
            Imagen.setImageDrawable(drwImagen);
        }
        //AGREGAR FUENTE A LOS ELEMENTOS
        this.Learners2 = Typeface.createFromAsset(this.getAssets(), "fuentes/Learners.ttf");
        this.Song2 = Typeface.createFromAsset(this.getAssets(), "fuentes/Song.ttf");
        NombreDoc.setTypeface(Song2);
        Especialidad.setTypeface(Song2);
        Experienecia.setTypeface(Song2);
        Puntos.setTypeface(Song2);
        Cedula.setTypeface(Song2);
        btnPuntos = (Button) findViewById(R.id.idBtnPunto);
        btnPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarPunto();
            }
        });
        btnCita = (Button) findViewById(R.id.idBtnCita);
        btnCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerCita();
            }
        });
        //BÓTON ATRAS
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    private void agregarPunto() {
        btnCita = (Button) findViewById(R.id.idBtnPunto);
        btnCita.setEnabled(false);
        int puntoExtra = getIntent().getExtras().getInt("Puntos") + 1;
        Puntos.setText("Puntos: " + puntoExtra);

    }

    private void hacerCita() {}

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
