package cn.refactor.smoothanimatetoolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/29 18:09
 * Description : Custom WebView
 */
public class SmoothWebView extends WebView {

    private OnScrollChangedListener mOnScrollChangedListener;

    public SmoothWebView(Context context) {
        super(context);
    }

    public SmoothWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmoothWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SmoothWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(WebView who, int l, int t, int oldl, int oldt);
    }
}
