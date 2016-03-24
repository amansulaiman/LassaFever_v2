package com.tech.c3nx.lassafever;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class AffectedAreaFragment extends Fragment {

    View rootview;
    WebView web;
    ProgressBar progressBar;

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public AffectedAreaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (haveNetworkConnection()){
            rootview = inflater.inflate(R.layout.fragment_affected_area, container, false);
            web = (WebView) rootview.findViewById(R.id.webView);
            progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);
            //web.setWebViewClient(new myWebClient());
            web.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE) {
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                    }
                    progressBar.setProgress(progress);
                    if (progress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                    }
                }
            });
            web.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedError(WebView view, int errorCode,
                                            String description, String failingUrl) {
                    // Handle the error

                    web.loadUrl("file:///android_res/drawable/affect.jpg");

                    Toast.makeText(getActivity(), "Oh no! Can't fetch data from Internet! Please Check your Connectivity", Toast.LENGTH_SHORT).show();
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            web.getSettings().setJavaScriptEnabled(true);
            //web.getSettings().setBuiltInZoomControls(true);
            web.getSettings().setSupportZoom(true);
            //web.setInitialScale(1);
            web.getSettings().setLoadWithOverviewMode(true);
            //web.getSettings().setUseWideViewPort(false);
            web.loadUrl("https://www.google.com/fusiontables/embedviz?q=select+col1+from+1Fw103ZCx_qGnT_nCi7qK-8SihOWboqMZhg7xK45m&viz=MAP&h=false&lat=3.368142215084222&lng=23.10431011894525&t=3&z=4&l=col1&y=2&tmplt=2&hml=GEOCODABLE");
        }else {
            rootview = inflater.inflate(R.layout.fragment_affected_area_error, container, false);
            Toast.makeText(getActivity(), "Oh no! Can't fetch data from Internet! Please Check your Connectivity", Toast.LENGTH_SHORT).show();
        }
        return rootview;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
