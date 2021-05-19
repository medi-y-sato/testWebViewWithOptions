package jp.mediba.ysato.testwebviewwithoptions

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        val targetUrl = "https://google.com"

        val webViewClent: WebViewClient = object : WebViewClient() {
        }

        webView.setWebViewClient(webViewClent)
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().javaScriptEnabled = true
        webView.getSettings().setGeolocationEnabled(true);

        webView.getSettings().domStorageEnabled = true
        webView.getSettings().mediaPlaybackRequiresUserGesture = false;

        webView.loadUrl(targetUrl)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        val webView: WebView = findViewById(R.id.webView)

        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}