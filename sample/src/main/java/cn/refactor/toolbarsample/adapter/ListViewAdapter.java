package cn.refactor.toolbarsample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.toolbarsample.R;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/17 21:09
 * Description : ListView Adapter
 */
public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mDataList;

    public ListViewAdapter(Context context) {
        mContext = context;
        mDataList = new ArrayList<>();
        for (int i = 0; i < 40; i ++) {
            mDataList.add(String.valueOf(i));
        }
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_text, null);
            holder = new ViewHolder();
            holder.mTextView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTextView.setText(mDataList.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public TextView mTextView;
    }
}
