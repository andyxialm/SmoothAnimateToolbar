package cn.refactor.smoothanimatetoolbar.listeners;

import android.support.v7.widget.RecyclerView;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/16 21:55
 * Description : ScrollUp and scrollDown listener
 */
public abstract class OnRecyclerViewScrollChangedListener extends RecyclerView.OnScrollListener implements BaseScrollListener {

    private int mScrollThreshold;
    private boolean mLastScrollDirectionToUp;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        boolean isSignificantDelta = Math.abs(dy) > mScrollThreshold;
        if (isSignificantDelta) {
            if (dy > 0) {
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
    }

    public void setScrollThreshold(int scrollThreshold) {
        mScrollThreshold = scrollThreshold;
    }
}
