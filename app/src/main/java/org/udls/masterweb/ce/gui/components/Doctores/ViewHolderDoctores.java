package org.udls.masterweb.ce.gui.components.Doctores;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.udls.masterweb.ce.R;

/**
 * Created by Andres on 11/28/2017.
 */

public class ViewHolderDoctores  extends  RecyclerView.ViewHolder{

    protected ImageView ImgFotografia;
    protected TextView lblNombre;
    protected TextView lblEspecialidad;
    protected TextView lblExperiencia;
    protected TextView lblNumeroReputacion;
    protected CardView cardView;

    public ViewHolderDoctores(final View itemView) {
        super(itemView);
        ImgFotografia = (ImageView) itemView.findViewById(R.id.idImgDoctor);
        lblNombre = (TextView) itemView.findViewById(R.id.idNombreDoctor);
        lblEspecialidad = (TextView) itemView.findViewById(R.id.idEspecialidad);
        lblNumeroReputacion = (TextView) itemView.findViewById(R.id.idNumeroReputacion);
        cardView = (CardView) itemView.findViewById(R.id.idCardDoctores);

    }
}
