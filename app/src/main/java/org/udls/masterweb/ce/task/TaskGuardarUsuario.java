package org.udls.masterweb.ce.task;

import android.os.AsyncTask;

import org.udls.masterweb.ce.core.ControladorUsuario;
import org.udls.masterweb.ce.model.Usuario;


public class TaskGuardarUsuario extends AsyncTask<Void, Void, Void>
{
    Usuario userData;

    public TaskGuardarUsuario(Usuario userData)
    {
        this.userData = userData;
    }


    protected Void doInBackground(Void... params)
    {
        ControladorUsuario ca = new ControladorUsuario(null);
        int idUsuario = 0;
        try
        {
            idUsuario = ca.save(userData);
            userData.setIdUsuario(idUsuario);
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


}
