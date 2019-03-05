package org.udls.masterweb.ce.core;
import android.content.Context;
import android.util.Log;

import org.udls.masterweb.ce.model.CentrosMedicos;
import org.udls.masterweb.ce.model.DataGlobal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import flexjson.JSONDeserializer;

public class ControladorCentrosMedicos {

    Context context;
    public ControladorCentrosMedicos(Context context)
    {
        this.context = context;
    }

    public List<CentrosMedicos> ObtenerCentrosMedicos() throws Exception
    {
        List<CentrosMedicos> CentrosMedicos = new ArrayList<>();
        JSONDeserializer<List<CentrosMedicos>> jdss = new JSONDeserializer<List<CentrosMedicos>>();
        URL obj = new URL(DataGlobal.ConexionApiRest + "CentrosMedicos/ObtenerCentrosMedicos");
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
        jdss.use("values", CentrosMedicos.class);
        CentrosMedicos = jdss.deserialize(responseBuffer.toString());
        return CentrosMedicos;
    }

}


