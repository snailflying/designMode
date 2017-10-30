package com.aaron.design;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aaron.design.utils.IntentBuilder;

public class SecondActivity extends AppCompatActivity {
    WebView webView;
    String url;
    private int loadCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }


    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(false);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                         if (url.startsWith("unsafe:")) {
                                             url = url.substring(7);
                                         }


                                         if (url.startsWith("http:") || url.startsWith("https:")) {
                                             view.loadUrl(url);
                                             return false;
                                         } else {
                                             try {
                                                 IntentBuilder.buildIntent(SecondActivity.this, Uri.parse(url));
                                             } catch (Exception e) {
                                             }

                                             return true;
                                         }
                                     }
//
//                             @Override
//                             public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//
//                                 // 不要使用super，否则有些手机访问不了，因为包含了一条 handler.cancel()
//                                 // super.onReceivedSslError(view, handler, error);
//
//                                 // 接受所有网站的证书，忽略SSL错误，执行访问网页
//                                 DebugLog.e("error:" + error);
//                                 handler.proceed();
//                             }
                                 }
        );
        url = getIntent().getStringExtra("url");
//        url = "https://contenttest.mlinks.co/internal/content-channel/home?utm_source=XL363IEI&spm=JU9AZBJ5.2446XIV4.PI-IZFIWKPL.T101.WCxlYbYY&rdm=G9i9Ifiu2z1nzyRF&mw_prod_content=1&mw_hc=1";

        if (!TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

}
