package cn.refactor.smoothanimatetoolbar.listeners;

import android.view.View;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/16 22:33
 * Description : get scroll target view
 */
public interface DirectionTargetView {

    /**
     * @return SmoothScroll or RecyclerView or ListView's instance
     */
    View getScrollTargetView();
}
