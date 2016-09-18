package cn.refactor.smoothanimatetoolbar.listeners;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AbsListView;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/16 22:08
 * Description : ScrollUp and scrollDown listener
 */
public abstract class OnListViewScrollChangedListener implements BaseScrollListener, AbsListView.OnScrollListener {
    private AbsListView mListView;
    private int mLastScrollY;
    private int mPreviousFirstVisibleItem;
    private int mScrollThreshold;
    private boolean mLastScrollDirectionToUp;

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(totalItemCount == 0) return;
        if (isSameRow(firstVisibleItem)) {
            int newScrollY = getTopItemScrollY();
            boolean isSignificantDelta = Math.abs(mLastScrollY - newScrollY) > mScrollThreshold;
            if (isSignificantDelta) {
                if (mLastScrollY > newScrollY) {
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
            mLastScrollY = newScrollY;
        } else {
            if (firstVisibleItem > mPreviousFirstVisibleItem) {
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

            mLastScrollY = getTopItemScrollY();
            mPreviousFirstVisibleItem = firstVisibleItem;
        }
    }

    public void setScrollThreshold(int scrollThreshold) {
        mScrollThreshold = scrollThreshold;
    }

    public void setListView(@NonNull AbsListView listView) {
        mListView = listView;
    }

    private boolean isSameRow(int firstVisibleItem) {
        return firstVisibleItem == mPreviousFirstVisibleItem;
    }

    private int getTopItemScrollY() {
        if (mListView == null || mListView.getChildAt(0) == null) return 0;
        View topChild = mListView.getChildAt(0);
        return topChild.getTop();
    }
}
