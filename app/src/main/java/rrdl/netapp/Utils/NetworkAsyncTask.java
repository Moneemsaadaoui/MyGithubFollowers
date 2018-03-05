package rrdl.netapp.Utils;

import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by moneem on 05/03/18.
 */

public class NetworkAsyncTask extends AsyncTask<String,Void,String> {

    public NetworkAsyncTask(Listeners callback) {
        this.callback = new WeakReference<>(callback);
    }

    public interface Listeners{
        void onPreExecute();

        void onPreExectue();
            void doInBackground();
            void onPostExecute(String success);
        }
        private final WeakReference<Listeners>callback;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.callback.get().onPreExectue();
        Log.e("TAG","Async is started");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.callback.get().onPostExecute(s);
        Log.e("TAG","AsyncTask is finished");

    }


    @Override
    protected String doInBackground(String... url) {
        this.callback.get().doInBackground();
        Log.e("TAG","Async task crunching some numbers");
        return MyhttpConnection.startHttpRequest(url[0]);

    }
}
