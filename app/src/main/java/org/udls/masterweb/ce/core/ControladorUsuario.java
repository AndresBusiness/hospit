package org.udls.masterweb.ce.core;

import android.content.Context;
import android.util.Log;

import org.udls.masterweb.ce.model.DataGlobal;
import org.udls.masterweb.ce.model.Usuario;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import flexjson.JSONDeserializer;


/**
 * Created by Andres on 12/2/2017.
 */

public class ControladorUsuario {

    Context context;
    public ControladorUsuario(Context context)
    {
        this.context = context;
    }


    public int save(Usuario objUsuario) throws Exception
    {
        String ruta = DataGlobal.ConexionApiRest + "Usuarios/AgregarUsuario";
        String parametros = armarParametros(objUsuario);
        URL url = new URL(ruta);
        HttpURLConnection connHttp = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        BufferedReader br = null;
        BufferedWriter bwriter = null;
        OutputStream out = null;
        String lineaActual;
        StringBuffer responseBuffer = new StringBuffer();
        JSONDeserializer jdss = new JSONDeserializer();
        Map<String, String> mapaResultado = null;
        Log.i("info", ruta);
        connHttp.setRequestMethod("POST");
        connHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connHttp.setDoOutput(true);
        connHttp.setDoInput(true);
        out = new BufferedOutputStream(connHttp.getOutputStream());
        bwriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        bwriter.write(parametros);
        bwriter.flush();
        bwriter.close();
        out.close();
        connHttp.connect();
        responseCode = connHttp.getResponseCode();
        Log.i("info", "Response Code: " + responseCode);
        return 1;

    }

    private String armarParametros(Usuario Objuser)
    {
        String parametros = "nombre=" + URLEncoder.encode(Objuser.getNombre()) + "&" +
                "correo=" + URLEncoder.encode(Objuser.getCorreo()) + "&" +
                "telefono=" + URLEncoder.encode(Objuser.getTelefono()) + "&" +
                "password=" + URLEncoder.encode(Objuser.getPassword()) + "&" +
                "foto=" + Objuser.getFoto();
        return parametros;
    }
}
