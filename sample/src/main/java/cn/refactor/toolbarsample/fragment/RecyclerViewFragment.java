package cn.refactor.toolbarsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.refactor.toolbarsample.R;
import cn.refactor.toolbarsample.adapter.RecyclerViewAdapter;
import cn.refactor.toolbarsample.fragment.base.BaseFragment;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/17 20:25
 * Description : RecyclerView
 */
public class RecyclerViewFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rv, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        setupViews();
    }

    private void setupViews() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public View getScrollTargetView() {
        return mRecyclerView;
    }
}
