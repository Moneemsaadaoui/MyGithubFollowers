package rrdl.netapp.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by moneem on 05/03/18.
 */

public class MyhttpConnection {
    public static String startHttpRequest(String urlString) {
        StringBuilder stringBuilder=new StringBuilder();
        try
        {

            URL url=new URL(urlString);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.connect();
            InputStream in=con.getInputStream();

            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String line;
            while((line=reader.readLine())!=null)
            {
                stringBuilder.append(line);
            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

}
