package cn.refactor.toolbarsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import cn.refactor.smoothanimatetoolbar.SmoothWebView;
import cn.refactor.toolbarsample.R;
import cn.refactor.toolbarsample.adapter.ListViewAdapter;
import cn.refactor.toolbarsample.fragment.base.BaseFragment;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/29 17:54
 * Description : WebView fragment sample
 */
public class WebViewFragment extends BaseFragment {

    private SmoothWebView mWebView;

    public static WebViewFragment newInstance() {
        return new WebViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_webview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView = (SmoothWebView) view.findViewById(R.id.webView);
        setupViews();
    }

    private void setupViews() {
        mWebView.loadUrl("https://github.com/andyxialm");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public View getScrollTargetView() {
        return mWebView;
    }
}
