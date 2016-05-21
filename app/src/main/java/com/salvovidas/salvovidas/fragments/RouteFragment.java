package com.salvovidas.salvovidas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.salvovidas.salvovidas.R;
import com.salvovidas.salvovidas.services.SmsService;

import java.util.Timer;
import java.util.TimerTask;

public class RouteFragment extends Fragment {
    private static final int TIME = 30000;
    private static final int INTERVAL = 5000;
    private int count = 3;

    private CountDownTimer timer;

    private ViewGroup rootView;
    private WebView wv;
    private Button reset;
    private TextView tvHour, tvMinute, tvSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_route, container, false);
        setUpWebView(rootView);
        setUpTimer(rootView);
        setUpButton(rootView);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            timer.start();
            setUpTask();
        }
        else {  }
    }

    private void setUpButton(ViewGroup vg) {
        reset = (Button) vg.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setText("Reset timer");
                timer.cancel();
                timer.start();
            }
        });
    }

    private void setUpTask() {
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, INTERVAL, INTERVAL);
    }

    class MyTimerTask extends TimerTask {
        public void run() {
            if (count > 0) {
                getActivity().startService(new Intent(getActivity(),SmsService.class));
                count--;
            }
        }
    }

    private void setUpTimer(ViewGroup vg) {
        tvHour = (TextView) vg.findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) vg.findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) vg.findViewById(R.id.txtTimerSecond);

        timer = new CountDownTimer(TIME, 1000) {

            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long hours = seconds / 3600;
                long minutes = (seconds % 3600) / 60;

                tvHour.setText("" + String.format("%02d", hours));
                tvMinute.setText("" + String.format("%02d", minutes));
                tvSecond.setText("" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tvHour.setText("" + String.format("%02d", 0));
                tvMinute.setText("" + String.format("%02d", 0));
                tvSecond.setText("" + String.format("%02d", 0));

                reset.setText("Sending current location to buddies...");
            }
        };
    }

    private void setUpWebView(ViewGroup vg) {
        wv = (WebView) vg.findViewById(R.id.webView);
        wv.setWebViewClient(new MyBrowser());

        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        String url = "\"https://www.google.com/maps/embed/v1/directions?key=AIzaSyBU7_3nFQwVp1LzFKFB34I4c7Yiap-hnXU&" +
                    "origin=Novaliches+Quezon+City&" +
                    "destination=Diliman+Quezon+City\"";

        wv.loadData("<iframe src=" + url + "></iframe>", "text/html",
                "utf-8");
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}