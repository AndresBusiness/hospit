package org.udls.masterweb.ce.gui.components.CentrosMedicos;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.udls.masterweb.ce.R;

public class ViewHolderCentrosMedicos extends  RecyclerView.ViewHolder{

    protected ImageView ImgFotografia;
    protected TextView lblDireccion;
    protected TextView lblNombreCentroMedico;
    protected TextView lblTelefono;
    protected CardView cardView;

    public ViewHolderCentrosMedicos(final View itemView) {
        super(itemView);
        ImgFotografia = (ImageView) itemView.findViewById(R.id.idImgCentroMedico);
        lblNombreCentroMedico = (TextView) itemView.findViewById(R.id.idNombreCentroMedico);
        lblDireccion = (TextView) itemView.findViewById(R.id.idDireccion);
        lblTelefono = (TextView) itemView.findViewById(R.id.idTelefono);
        cardView = (CardView) itemView.findViewById(R.id.idCard);

    }

}



