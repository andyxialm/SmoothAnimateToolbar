package cn.refactor.toolbarsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

import cn.refactor.toolbarsample.R;

/**
 * Create by andy (https://github.com/andyxialm)
 * Create time: 16/9/17 20:37
 * Description : RecyclerView adapter
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDataList;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv);
        }

        public void bind() {
            Glide.with(mContext)
                    .load(R.mipmap.ic_launcher)
                    .dontAnimate()
                    .into(mImageView);
        }
    }
}
