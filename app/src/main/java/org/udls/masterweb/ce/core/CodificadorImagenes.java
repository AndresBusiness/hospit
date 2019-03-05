package org.udls.masterweb.ce.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Grios on 02/10/2016.
 */
public class CodificadorImagenes
{
    public static Drawable decodificar(String str)
    {

        String strImg = URLDecoder.decode(str);
        byte[] bytes = Base64.decode(str, Base64.DEFAULT);
        Drawable drw = new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        return drw;
    }

    public static String codificar(Drawable drw) throws Exception
    {
        Bitmap bitmap = ((BitmapDrawable) drw).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bytes = null;
        String strOut = null;

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        bytes = stream.toByteArray();
        strOut = Base64.encodeToString(bytes, Base64.DEFAULT);
        strOut = strOut.replaceAll("\n", "");
        strOut = URLEncoder.encode(strOut, "UTF-8");
        return strOut;
    }
}
