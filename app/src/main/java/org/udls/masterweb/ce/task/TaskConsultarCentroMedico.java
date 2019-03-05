package org.udls.masterweb.ce.task;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import org.udls.masterweb.ce.gui.MainActivity;
import org.udls.masterweb.ce.model.CentrosMedicos;
import org.udls.masterweb.ce.core.ControladorCentrosMedicos;
import org.udls.masterweb.ce.gui.components.CentrosMedicos.ListadoCentrosMedicos;
import java.util.ArrayList;
import java.util.List;

public class TaskConsultarCentroMedico extends AsyncTask<Void, Void, Void> {

    List<CentrosMedicos> centrosmedicos;
    public TaskConsultarCentroMedico()
    {
        centrosmedicos = new ArrayList<>();
    }
    @Override
    protected Void doInBackground(Void... params) {
        ControladorCentrosMedicos ca = new ControladorCentrosMedicos(null);
        try
        {
            centrosmedicos = ca.ObtenerCentrosMedicos();
            return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.i("info", "Listo...");
        try
        {
            if (MainActivity.GLOBALS.get("app") != null)
                    ((MainActivity) MainActivity.GLOBALS.get("app")).getViewPagerAdapter().getFragmentListadoCentrosMedicos().actualizar(centrosmedicos);
                else
                ((ListadoCentrosMedicos) MainActivity.GLOBALS.get("fragmentListadoCentrosMedicos")).actualizar(centrosmedicos);
            ((MainActivity) MainActivity.GLOBALS.get("app")).mostrarMensaje("Centros Medicos: " + centrosmedicos.size(), Snackbar.LENGTH_LONG);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", ex.toString());
        }
    }
}
