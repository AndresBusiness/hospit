package org.udls.masterweb.ce.gui.components.Doctores;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.udls.masterweb.ce.R;
import org.udls.masterweb.ce.model.Doctores;

import java.util.List;

public class ListadoDoctores extends Fragment {
   //PROPIEDADES
    View layoutFragment;
    RecyclerView rclvDoctores;
    TextView lblRclvVacio;
    AdapterDoctores adapterDoctores;
    RecyclerView.LayoutManager myLayoutManager;
    List<ListadoDoctores> doctor;
    private int idDoctor;

    public ListadoDoctores()
    {
        super();
    }
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    private void inicializar() throws Exception
    {
        doctor = null;
        myLayoutManager = new LinearLayoutManager(getContext());
        rclvDoctores.setLayoutManager(myLayoutManager);
       // actualizar();
        ((MainDoctores) MainDoctores.GLOBALS.get("app")).mostrarMensaje("Consultando doctores...", Snackbar.LENGTH_LONG);
    }

    public void actualizar(List<Doctores> objDoctor) throws Exception
    {
        adapterDoctores = new AdapterDoctores(objDoctor);
        rclvDoctores.setAdapter(adapterDoctores);

        if (objDoctor.isEmpty())
        {
            rclvDoctores.setVisibility(View.GONE);
            lblRclvVacio.setVisibility(View.VISIBLE);
        }
        else
        {
            rclvDoctores.setVisibility(View.VISIBLE);
            lblRclvVacio.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainDoctores.GLOBALS.put("fragmentListadoDoctores", this);
        layoutFragment = inflater.inflate(R.layout.fragment_listado_doctores, container, false);
        rclvDoctores = (RecyclerView) layoutFragment.findViewById(R.id.idRecyclerViewDoctores);
        lblRclvVacio = (TextView) layoutFragment.findViewById(R.id.lblDoctoresVacio);

        try
        {
            inicializar();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return layoutFragment;
    }


}
