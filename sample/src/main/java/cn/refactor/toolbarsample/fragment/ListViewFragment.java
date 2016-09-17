package cn.refactor.toolbarsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cn.refactor.toolbarsample.R;
import cn.refactor.toolbarsample.adapter.ListViewAdapter;
import cn.refactor.toolbarsample.fragment.base.BaseFragment;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/17 20:25
 * Description : ListView Fragment
 */
public class ListViewFragment extends BaseFragment {

    private ListView mListView;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lv, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ListView) view.findViewById(R.id.list_view);
        setupViews();
    }

    private void setupViews() {
        ListViewAdapter adapter = new ListViewAdapter(getActivity());
        mListView.setAdapter(adapter);
    }

    @Override
    public View getScrollTargetView() {
        return mListView;
    }
}
