package org.udls.masterweb.ce.gui.components.Doctores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CodificadorImagenes;
import org.udls.masterweb.ce.model.DataGlobal;
import org.udls.masterweb.ce.model.Doctores;

import java.util.List;

/**
 * Created by Andres on 11/28/2017.
 */

public class AdapterDoctores extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Doctores> doctores;

    public AdapterDoctores(List<Doctores> doctores)
    {
        this.doctores = doctores;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View VistaRowLayOut = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_doctores, parent, false);
        ViewHolderDoctores objControles = new ViewHolderDoctores(VistaRowLayOut);
        this.context = parent.getContext();
        return objControles;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Doctores objDoctores = doctores.get(position);
        ViewHolderDoctores vistaHolder = (ViewHolderDoctores) holder;
        Drawable drwImagen = null;
        if(objDoctores.getFotografia() != null && !objDoctores.getFotografia().isEmpty()){
            try
            {
                drwImagen = CodificadorImagenes.decodificar(objDoctores.getFotografia());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(drwImagen !=null){
            vistaHolder.ImgFotografia.setImageDrawable(drwImagen);
        }
        //PINTANDO LOS DATOS EN LAS ETIQUETAS
        vistaHolder.lblNombre.setText(Html.fromHtml("<b>" + objDoctores.getNombreDoctor() + "</b>."));
        vistaHolder.lblEspecialidad.setText(objDoctores.getEspecialidad());
        vistaHolder.lblNumeroReputacion.setText(String.valueOf(objDoctores.getReputacion()));

        //INICIALIZANDO FUENTES
        DataGlobal.Learners = Typeface.createFromAsset(context.getAssets(), "fuentes/Learners.ttf");
        DataGlobal.Song = Typeface.createFromAsset(context.getAssets(), "fuentes/Song.ttf");
        //AGREGANDO FUENTES
        vistaHolder.lblNombre.setTypeface(DataGlobal.Learners);
        vistaHolder.lblEspecialidad.setTypeface(DataGlobal.Learners);
        vistaHolder.lblNumeroReputacion.setTypeface(DataGlobal.Learners);

        //EVENTO CLICK DE LA CARDVIEW
        vistaHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INTENCIÓN DE UNA INSTANCIA
                Intent intent = new Intent(context,  DetalleDoctor.class);

                //PASANDO LOS PARAMETROS DE UNA ACTIVIDAD A OTRA
                intent.putExtra("NombreDoc", objDoctores.getNombreDoctor());
                intent.putExtra("Especialidad", objDoctores.getEspecialidad());
                intent.putExtra("Puntos", objDoctores.getReputacion());
                intent.putExtra("Experiencia", objDoctores.getExperiencia());
                intent.putExtra("Imagen", objDoctores.getFotografia());
                intent.putExtra("Cedula", objDoctores.getCedula());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return doctores.size();
    }
}
