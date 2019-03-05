package org.udls.masterweb.ce.gui.components.CentrosMedicos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.udls.masterweb.ce.model.DataGlobal;
import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.core.CodificadorImagenes;
import org.udls.masterweb.ce.model.CentrosMedicos;
import java.util.List;

public class AdapterCentrosMedicos extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<CentrosMedicos> centroMedico;

    public AdapterCentrosMedicos(List<CentrosMedicos> centroMedico)
    {
        this.centroMedico = centroMedico;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View VistaRowLayOut = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_centro_medico, parent, false);
        ViewHolderCentrosMedicos objControles = new ViewHolderCentrosMedicos(VistaRowLayOut);
        this.context = parent.getContext();
        return objControles;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CentrosMedicos objCentroMedico = centroMedico.get(position);
        ViewHolderCentrosMedicos vistaHolder = (ViewHolderCentrosMedicos) holder;
        Drawable drwImagen = null;

        if(objCentroMedico.getFotografia() != null && !objCentroMedico.getFotografia().isEmpty()){
            try
            {
                drwImagen = CodificadorImagenes.decodificar(objCentroMedico.getFotografia());
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
        vistaHolder.lblNombreCentroMedico.setText(Html.fromHtml("<b>" + objCentroMedico.getNombreCentroMedico() + "</b>."));
        vistaHolder.lblTelefono.setText(objCentroMedico.getTelefono());
        vistaHolder.lblDireccion.setText(objCentroMedico.getDireccion());
        //INICIALIZANDO FUENTES
        DataGlobal.Learners = Typeface.createFromAsset(context.getAssets(), "fuentes/Learners.ttf");
        DataGlobal.Song = Typeface.createFromAsset(context.getAssets(), "fuentes/Song.ttf");
        //AGREGANDO FUENTES
        vistaHolder.lblNombreCentroMedico.setTypeface(DataGlobal.Song);
        vistaHolder.lblTelefono.setTypeface(DataGlobal.Learners);
        vistaHolder.lblDireccion.setTypeface(DataGlobal.Learners);

        //EVENTO CLICK DE LA CARDVIEW
        vistaHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INTENCIÓN DE UNA INSTANCIA
                Intent intent = new Intent(context,  DetalleCentroMedico.class);

                //PASANDO LOS PARAMETROS DE UNA ACTIVIDAD A OTRA
                intent.putExtra("Nombre", objCentroMedico.getNombreCentroMedico());
                intent.putExtra("Direccion", objCentroMedico.getDireccion());
                intent.putExtra("Telefono", objCentroMedico.getTelefono());
                intent.putExtra("Correo", objCentroMedico.getCorreo());
                intent.putExtra("Horarios", objCentroMedico.getHorario());
                intent.putExtra("Tipo", objCentroMedico.getTipo());
                intent.putExtra("Longitud", objCentroMedico.getLongitud());
                intent.putExtra("Latitud", objCentroMedico.getLatitud());
                intent.putExtra("Imagen", objCentroMedico.getFotografia());
                intent.putExtra("id", objCentroMedico.getIdCentromedico());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return centroMedico.size();
    }
}
