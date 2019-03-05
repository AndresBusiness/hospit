package org.udls.masterweb.ce.task;

import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;

import org.udls.masterweb.ce.core.ControladorAutenticacion;
import org.udls.masterweb.ce.gui.MainActivity;
import org.udls.masterweb.ce.model.Usuario;
import org.udls.masterweb.ce.seg.Perfil;

/**
 * Created by Andres on 12/1/2017.
 */

public class TaskAuthentication  extends AsyncTask<Void, Void, Void> {
    private static Usuario user;
    Context context;
    public TaskAuthentication()
    {
        setUser(new Usuario());
    }
    String email;
    String password;

    public TaskAuthentication(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        TaskAuthentication.user = user;
    }

    @Override
    protected Void doInBackground(Void... params) {
        ControladorAutenticacion objUsuario = new ControladorAutenticacion(null);
        try
        {
            setUser(objUsuario.Auth(email, password));

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
            if (Perfil.GLOBALS.get("app") != null)
                ((Perfil) Perfil.GLOBALS.get("app")).PasarDatos(user);
            else
            ((Perfil) MainActivity.GLOBALS.get("app")).mostrarMensaje("Usuario  ....: " + user, Snackbar.LENGTH_LONG);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", ex.toString());
        }
    }
}
