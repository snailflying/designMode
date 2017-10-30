package com.aaron.design;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.aaron.design.clone.CloneTest;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText input;
    Button done;
    //    String url = "http://test.cssandjs.com/magicwindow.html";
    String default_url;
    private int loadCount = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        test();
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
        default_url = getString(R.string.default_url);

        webView = (WebView) findViewById(R.id.webview);
        input = (EditText) findViewById(R.id.input);
        done = (Button) findViewById(R.id.done);

        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(false);
//        if (Build.VERSION.SDK_INT >= 21) {
//            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//
//        if (Build.VERSION.SDK_INT < 8) {
//
////            webView.getSettings().setPluginsEnabled(true);
//        } else {
//
//            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        }

/*
*
* (new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                         if (url.startsWith("unsafe:")) {
                                             url = url.substring(7);
                                         }

                                         WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                                         Log.e("MainActivity", "hit:" + hitTestResult);
                                         if (hitTestResult != null) {
                                             String extra = hitTestResult.getExtra();
                                             Log.e("MainActivity", "hit extra:" + hitTestResult.getExtra());

                                             if (!TextUtils.isEmpty(extra)) {
                                                 loadCount++;
                                                 if (loadCount >= 1) {
                                                     loadCount = 0;
                                                     if (url.startsWith(WebView.SCHEME_TEL) || url.startsWith("sms:") || url.startsWith(WebView.SCHEME_MAILTO)) {
                                                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                                         startActivity(intent);
                                                     } else {
                                                         Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                                         intent.putExtra("url", url);
                                                         startActivity(intent);
                                                     }
                                                 } else {
                                                     view.loadUrl(url);
                                                 }
                                                 return true;
                                             }
                                         }

                                         return super.shouldOverrideUrlLoading(view, url);
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
        )
*
* */
        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                                         DebugLog.i("MW " + TAG + "shouldOverrideUrlLoading:"+url);
                                         if (url.startsWith("unsafe:")) {
                                             url = url.substring(7);
                                         }
//                                         DebugLog.e("aaron redirect interruptRedirectDownLoad:" + interruptRedirectDownLoad + ", url:" + url);

                                         if (url.startsWith("http:") || url.startsWith("https:")) {
                                             //某些特殊的重定向后不能跳转，比如淘宝具体页
//                                     view.loadUrl(Uri.decode(url));
                                             view.loadUrl(url);
                                             return false;
                                         } else {
                                             try {
                                                 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                 view.getContext().startActivity(intent);
                                             } catch (Exception e) {
//                                                 interruptRedirectDownLoad = false;
                                             }

                                             return true;
                                         }
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         super.onPageFinished(view, url);
                                     }
                                 }
        );
//        url = getIntent().getStringExtra("url");
//        url = "https://content.mlinks.co/internal/content-single/?spm=HHXN7QPA.2CV29VED.PI-FCETRHKK.T000.WUQS0CKB-8b426356081c4e0faace02f1a7052bdc-59672eb5bc4cb2699bc7dc64&mw_contentid=WUQS0CKB-8b426356081c4e0faace02f1a7052bdc-59672eb5bc4cb2699bc7dc64&rdm=WUKdJcOYCwW658TI&mw_guanggao=true&mw_channel=T101";
        if (!TextUtils.isEmpty(input.getText())) {
            default_url = input.getText().toString();
        }
//        url = "http://test.cssandjs.com/magicwindow.html";

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(input.getText())) {
                    default_url = input.getText().toString();
                }
                webView.loadUrl(default_url);
            }
        });

//        if (!TextUtils.isEmpty(default_url)) {
//            webView.loadUrl(default_url);
//        }
    }

    void test(){
        CloneTest test = new CloneTest();
        try {
            test.test();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
