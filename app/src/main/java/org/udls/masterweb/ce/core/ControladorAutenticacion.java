package org.udls.masterweb.ce.core;

import android.content.Context;
import android.util.Log;

import org.udls.masterweb.ce.model.DataGlobal;
import org.udls.masterweb.ce.model.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import flexjson.JSONDeserializer;

/**
 * Created by Andres on 12/1/2017.
 */

public class ControladorAutenticacion {
    Context context;
    public ControladorAutenticacion(Context context)
    {
        this.context = context;
    }

    public Usuario Auth(String email, String password) throws Exception
    {
        JSONDeserializer<Usuario> jdss = new JSONDeserializer<Usuario>();
        URL obj = new URL(DataGlobal.ConexionApiRest + "Usuarios/Autenticacion/andres-tic@hotmail.com/12345");
        HttpURLConnection connHttp = (HttpURLConnection) obj.openConnection();
        int responseCode = 0;
        BufferedReader br = null;
        String lineaActual;
        StringBuffer responseBuffer = new StringBuffer();
        connHttp.setRequestMethod("GET");
        responseCode = connHttp.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK)
        {
            br = new BufferedReader(new InputStreamReader(connHttp.getInputStream()));
            while ((lineaActual = br.readLine()) != null)
                responseBuffer.append(lineaActual);
            br.close();
        }
        Log.i("DATOS DEL USUARIO ---->", responseBuffer.toString());
        Usuario  user = new JSONDeserializer<Usuario>().deserialize( responseBuffer.toString() , Usuario.class);

        return user;
    }

}
