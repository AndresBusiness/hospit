package org.udls.masterweb.ce.task;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import org.udls.masterweb.ce.core.ControladorDoctores;
import org.udls.masterweb.ce.gui.components.Doctores.MainDoctores;
import org.udls.masterweb.ce.gui.components.Doctores.ListadoDoctores;
import org.udls.masterweb.ce.model.Doctores;

import java.util.ArrayList;
import java.util.List;


public class TaskConsultarDoctores extends AsyncTask<Void, Void, Void> {

    ListadoDoctores fla;
    List<Doctores> listaDoctor;

    int idCentroMedico;

    public TaskConsultarDoctores(int idCentroMedico)
    {
        this.idCentroMedico = idCentroMedico;
    }
    public TaskConsultarDoctores()
    {
        listaDoctor = new ArrayList<>();
    }
    @Override
    protected Void doInBackground(Void... params) {
        ControladorDoctores ca = new ControladorDoctores(null);
        try
        {
            listaDoctor = ca.ObtenerDoctoresxClinica(idCentroMedico);
            return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.i("info", "Listo...");
        try
        {
            if (MainDoctores.GLOBALS.get("app") != null)
                 ((MainDoctores) MainDoctores.GLOBALS.get("app")).getViewPagerAdapter().getFragmentListadoDoctores().actualizar(listaDoctor);
            else
                 ((ListadoDoctores) MainDoctores.GLOBALS.get("fragmentListadoDoctores")).actualizar(listaDoctor);
            ((MainDoctores) MainDoctores.GLOBALS.get("app")).mostrarMensaje("Doctores: " + listaDoctor.size(), Snackbar.LENGTH_LONG);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", ex.toString());
        }
    }
}