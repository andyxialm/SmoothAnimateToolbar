package cn.refactor.toolbarsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.refactor.smoothanimatetoolbar.SmoothScrollView;
import cn.refactor.toolbarsample.R;
import cn.refactor.toolbarsample.fragment.base.BaseFragment;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/17 20:26
 * Description : SmoothScrollView fragment
 */
public class ScrollViewFragment extends BaseFragment {
    private SmoothScrollView mScrollView;

    public static ScrollViewFragment newInstance() {
        return new ScrollViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_smooth_sv, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = (SmoothScrollView) view.findViewById(R.id.smooth_scroll_view);
    }

    @Override
    public View getScrollTargetView() {
        return mScrollView;
    }
}
