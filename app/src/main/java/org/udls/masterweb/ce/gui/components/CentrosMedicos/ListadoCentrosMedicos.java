package org.udls.masterweb.ce.gui.components.CentrosMedicos;

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
import org.udls.masterweb.ce.gui.MainActivity;
import org.udls.masterweb.ce.model.CentrosMedicos;
import org.udls.masterweb.ce.task.TaskConsultarCentroMedico;

import java.util.List;

public class ListadoCentrosMedicos extends Fragment {
    //PROPIEDADES
    View layoutFragment;
    RecyclerView rclvCentrosMedicos;
    TextView lblRclvVacio;
    AdapterCentrosMedicos adapterCentroMedico;
    RecyclerView.LayoutManager myLayoutManager;
    List<CentrosMedicos> centroM;
    //CONTRUCTOR
    public ListadoCentrosMedicos()
    {
        super();
    }
    private void inicializar() throws Exception
    {
        centroM = null;
        myLayoutManager = new LinearLayoutManager(getContext());
        rclvCentrosMedicos.setLayoutManager(myLayoutManager);
        actualizar();
        ((MainActivity) MainActivity.GLOBALS.get("app")).mostrarMensaje("Consultando centros medicos...", Snackbar.LENGTH_LONG);
    }
    private void actualizar()
    {
        TaskConsultarCentroMedico tca = new TaskConsultarCentroMedico();
        tca.execute();
    }
    public void actualizar(List<CentrosMedicos> CentroM) throws Exception
    {
        adapterCentroMedico = new AdapterCentrosMedicos(CentroM);
        rclvCentrosMedicos.setAdapter(adapterCentroMedico);

        if (CentroM.isEmpty())
        {
            rclvCentrosMedicos.setVisibility(View.GONE);
            lblRclvVacio.setVisibility(View.VISIBLE);
        }
        else
        {
            rclvCentrosMedicos.setVisibility(View.VISIBLE);
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
        MainActivity.GLOBALS.put("fragmentListadoCentrosMedicos", this);
        layoutFragment = inflater.inflate(R.layout.fragment_listado_centros_medicos, container, false);
        rclvCentrosMedicos = (RecyclerView) layoutFragment.findViewById(R.id.rclvCentrosMedicos);
        lblRclvVacio = (TextView) layoutFragment.findViewById(R.id.lblRclvCentrosMedicosVacio);

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
