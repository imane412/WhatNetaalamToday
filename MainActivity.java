package com.imane.whatnetaalamtoday;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebViewAssetLoader;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView web = new WebView(this);
        web.setBackgroundColor(0xFFF9F6FF);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        WebViewAssetLoader loader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this))
                .build();
        web.setWebViewClient(new androidx.webkit.WebViewClientCompat() {
            @Override public android.webkit.WebResourceResponse shouldInterceptRequest(WebView v, String url) {
                return loader.shouldInterceptRequest(android.net.Uri.parse(url));
            }
        });
        web.loadUrl("https://appassets.androidplatform.net/assets/index.html");
        setContentView(web);
    }
}
