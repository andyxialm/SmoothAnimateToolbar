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
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/14 15:19
 * Description : Toolbar with animation linkage ScrollView
 */
public class SmoothAnimateToolbar extends Toolbar {

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
     * Attach ScrollView to this toolbar
     * @param scrollView attach ScrollView
     */
    public void attachToScrollView(SmoothScrollView scrollView) {
        if (scrollView == null) {
            throw new RuntimeException("Boom! ScrollView is null");
        }

        SmoothOnScrollChangeListener smoothOnScrollChangeListener = new SmoothOnScrollChangeListener() {
            @Override
            void onScrollUp() {
                hide();
            }

            @Override
            void onScrollDown() {
                show();
            }
        };
        smoothOnScrollChangeListener.setScrollThreshold(mScrollThreshold);
        scrollView.setOnScrollChangedListener(smoothOnScrollChangeListener);
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
     * @param scrollThreshold
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
