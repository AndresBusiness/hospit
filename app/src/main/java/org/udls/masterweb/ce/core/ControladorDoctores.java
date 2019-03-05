package org.udls.masterweb.ce.core;

import android.content.Context;
import android.util.Log;
import org.udls.masterweb.ce.model.Doctores;
import org.udls.masterweb.ce.model.DataGlobal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import flexjson.JSONDeserializer;

public class ControladorDoctores {

    Context context;
    public ControladorDoctores(Context context)
    {
        this.context = context;
    }

    public List<Doctores> ObtenerDoctoresAll() throws Exception
    {
        List<Doctores> doctores = new ArrayList<>();
        JSONDeserializer<List<Doctores>> jdss = new JSONDeserializer<List<Doctores>>();
        URL obj = new URL(DataGlobal.ConexionApiRest + "Doctores/ObtenerDoctores");
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
        Log.i("info", responseBuffer.toString());
        jdss.use("values", Doctores.class);
        doctores = jdss.deserialize(responseBuffer.toString());
        return doctores;
    }
    public List<Doctores> ObtenerDoctoresxClinica(int idClinica) throws Exception
    {
        List<Doctores> doctores = new ArrayList<>();
        JSONDeserializer<List<Doctores>> jdss = new JSONDeserializer<List<Doctores>>();
        URL obj = new URL(DataGlobal.ConexionApiRest + "Doctores/ObtenerDoctoresxClinica/" + idClinica);
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
        Log.i("info", responseBuffer.toString());
        jdss.use("values", Doctores.class);
        doctores = jdss.deserialize(responseBuffer.toString());
        return doctores;
    }
}
