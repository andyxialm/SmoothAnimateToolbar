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

package cn.refactor.smoothanimatetoolbar.listeners;

import android.webkit.WebView;
import android.widget.ScrollView;

import cn.refactor.smoothanimatetoolbar.SmoothWebView;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/14 15:46
 * Description : ScrollUp and scrollDown listener
 */
public abstract class OnSmoothWebViewScrollChangedListener implements SmoothWebView.OnScrollChangedListener, BaseScrollListener {
    private int mLastScrollY;
    private int mScrollThreshold;
    private boolean mLastScrollDirectionToUp;

    @Override
    public void onScrollChanged(WebView who, int l, int t, int oldl, int oldt) {
        boolean isSignificantDelta = Math.abs(t - mLastScrollY) > mScrollThreshold;
        if (isSignificantDelta) {
            if (t > mLastScrollY) {
                if (!mLastScrollDirectionToUp) {
                    mLastScrollDirectionToUp = true;
                    onScrollUp();
                }
            } else {
                if (mLastScrollDirectionToUp) {
                    mLastScrollDirectionToUp = false;
                    onScrollDown();
                }
            }
        }
        mLastScrollY = t;
    }

    public void setScrollThreshold(int scrollThreshold) {
        mScrollThreshold = scrollThreshold;
    }
}
