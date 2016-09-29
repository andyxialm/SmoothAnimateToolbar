/**
 * Copyright 2016 andy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.refactor.smoothanimatetoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import cn.refactor.smoothanimatetoolbar.listeners.OnListViewScrollChangedListener;
import cn.refactor.smoothanimatetoolbar.listeners.OnRecyclerViewScrollChangedListener;
import cn.refactor.smoothanimatetoolbar.listeners.OnSmoothScrollViewScrollChangedListener;
import cn.refactor.smoothanimatetoolbar.listeners.OnSmoothWebViewScrollChangedListener;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/14 15:19
 * Description : Toolbar with animation linkage ScrollView
 */
public class SmoothAnimateToolbar extends RelativeLayout {

    private static final String TAG                   = SmoothAnimateToolbar.class.getSimpleName();
    private static final int DEFAULT_ANIM_DURATION    = 1000;
    private static final int DEFAULT_SCROLL_THRESHOLD = 10;

    private int mAnimDuration;
    private int mScrollThreshold;

    public SmoothAnimateToolbar(Context context) {
        this(context, null);
    }

    public SmoothAnimateToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmoothAnimateToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * Get attrs
     * @param attrs attributes
     */
    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.SmoothAnimateToolbar);
            mAnimDuration = ta.getInt(R.styleable.SmoothAnimateToolbar_animDuration, DEFAULT_ANIM_DURATION);
            mScrollThreshold = ta.getInt(R.styleable.SmoothAnimateToolbar_scrollThreshold, DEFAULT_SCROLL_THRESHOLD);
            ta.recycle();
        }
    }

    /**
     * Attach view to set scrollChangedListener
     * @param view target View
     */
    public void attach(View view) {
        if (view instanceof SmoothScrollView) {
            attachToScrollView((SmoothScrollView) view);
        } else if (view instanceof SmoothWebView) {
            attachToWebView((SmoothWebView) view);
        } else if (view instanceof RecyclerView) {
            attachToRecyclerView((RecyclerView) view);
        } else if (view instanceof ListView) {
            attachToListView((ListView) view);
        } else {
            Log.i(TAG, "Boom! Not support this view");
        }
    }

    /**
     * Attach WebView to this toolbar
     * @param webView WebView
     */
    public void attachToWebView(SmoothWebView webView) {
        if (webView == null) {
            Log.i(TAG, "Boom! WebView is null");
            return;
        }

        OnSmoothWebViewScrollChangedListener onScrollChangedListener = new OnSmoothWebViewScrollChangedListener() {
            @Override
            public void onScrollUp() {
                hide();
            }

            @Override
            public void onScrollDown() {
                show();
            }
        };
        onScrollChangedListener.setScrollThreshold(mScrollThreshold);
        webView.setOnScrollChangedListener(onScrollChangedListener);
    }

    /**
     * Attach ScrollView to this toolbar
     * @param scrollView SmoothScrollView
     */
    public void attachToScrollView(SmoothScrollView scrollView) {
        if (scrollView == null) {
            Log.i(TAG, "Boom! ScrollView is null");
            return;
        }

        OnSmoothScrollViewScrollChangedListener onScrollChangedListener = new OnSmoothScrollViewScrollChangedListener() {
            @Override
            public void onScrollUp() {
                hide();
            }

            @Override
            public void onScrollDown() {
                show();
            }
        };
        onScrollChangedListener.setScrollThreshold(mScrollThreshold);
        scrollView.setOnScrollChangedListener(onScrollChangedListener);
    }

    /**
     * Attach RecyclerView to this toolbar
     * @param recyclerView RecyclerView
     */
    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            Log.i(TAG, "Boom! RecyclerView is null");
            return;
        }

        OnRecyclerViewScrollChangedListener onScrollChangedListener = new OnRecyclerViewScrollChangedListener() {
            @Override
            public void onScrollUp() {
                hide();
            }

            @Override
            public void onScrollDown() {
                show();
            }
        };
        onScrollChangedListener.setScrollThreshold(mScrollThreshold);
        recyclerView.addOnScrollListener(onScrollChangedListener);
    }

    /**
     * Attach ListView to this toolbar
     * @param listView ListView
     */
    public void attachToListView(ListView listView) {
        if (listView == null) {
            Log.i(TAG, "Boom! ListView is null");
            return;
        }

        OnListViewScrollChangedListener onScrollChangedListener = new OnListViewScrollChangedListener() {
            @Override
            public void onScrollUp() {
                hide();
            }

            @Override
            public void onScrollDown() {
                show();
            }
        };
        onScrollChangedListener.setListView(listView);
        onScrollChangedListener.setScrollThreshold(mScrollThreshold);
        listView.setOnScrollListener(onScrollChangedListener);
    }

    /**
     * Set animation duration
     * @param millisecond duration
     */
    @SuppressWarnings("unused")
    public void setAnimDuration(int millisecond) {
        mAnimDuration = millisecond;
    }

    /**
     * Set scroll threshold. Animation will start when the scroll dY reach to the threshold.
     * @param scrollThreshold scroll threshold
     */
    @SuppressWarnings("unused")
    public void setScrollThreshold(int scrollThreshold) {
        mScrollThreshold = scrollThreshold;
    }

    /**
     * Show toolbar with animation
     */
    public void show() {
        animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(mAnimDuration);
    }

    /**
     * Hide toolbar with animation
     */
    public void hide() {
        animate().translationY(-getHeight()).setInterpolator(new DecelerateInterpolator(2)).setDuration(mAnimDuration);
    }
}
