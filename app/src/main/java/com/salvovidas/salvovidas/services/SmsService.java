package com.salvovidas.salvovidas.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.salvovidas.salvovidas.R;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.util.UUID;

import cz.msebera.android.httpclient.Header;

public class SmsService extends Service {
    AsyncHttpClient client = new AsyncHttpClient();

    public SmsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Sending your location to your buddies...", Toast.LENGTH_LONG).show();
        sendMessage();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Done sending", Toast.LENGTH_LONG).show();
    }

    private void sendMessage() {
        final String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        StringUtils.leftPad(uuid, 32, '0');
        RequestParams params = new RequestParams();
        params.add("message_type", "SEND");
        params.add("mobile_number", getString(R.string.mobile));
        params.add("shortcode", getString(R.string.shortcode));
        params.add("message_id", uuid);
        params.add("message", "Christiane Yee is at Quezon City Polytechnic University, Novaliches, Quezon City");
        params.add("client_id", getString(R.string.chikka_id));
        params.add("secret_key", getString(R.string.chikka_key));

        client.post(getString(R.string.chikka_url), params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject obj) {
                Toast.makeText(getApplicationContext(), obj.toString(), Toast.LENGTH_LONG).show();
                stopSelf();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Toast.makeText(getApplicationContext(), errorResponse.toString(), Toast.LENGTH_LONG).show();
                stopSelf();
            }
        });

    }
}
