package cn.refactor.toolbarsample.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar;
import cn.refactor.toolbarsample.R;
import cn.refactor.toolbarsample.fragment.ListViewFragment;
import cn.refactor.toolbarsample.fragment.RecyclerViewFragment;
import cn.refactor.toolbarsample.fragment.ScrollViewFragment;
import cn.refactor.toolbarsample.fragment.base.BaseFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SmoothAnimateToolbar mToolbar;
    private List<BaseFragment> mFragmentList;
    private int mCurrFragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        mToolbar = (SmoothAnimateToolbar) findViewById(R.id.toolbar);
        assert mToolbar != null;
        mToolbar.findViewById(R.id.btn_1_toolbar).setOnClickListener(this);
        mToolbar.findViewById(R.id.btn_2_toolbar).setOnClickListener(this);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        assert bottomNavigationBar != null;
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.recycler_view))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.list_view))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.scroll_view))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(final int position) {
                switchFragment(position);

                mToolbar.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mToolbar.attach(mFragmentList.get(position).getScrollTargetView());
                    }
                }, 300);
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

        mFragmentList = new ArrayList<>();
        mFragmentList.add(RecyclerViewFragment.newInstance());
        mFragmentList.add(ListViewFragment.newInstance());
        mFragmentList.add(ScrollViewFragment.newInstance());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, mFragmentList.get(0));
        transaction.commit();

        mToolbar.postDelayed(new Runnable() {
            @Override
            public void run() {
                mToolbar.attach(mFragmentList.get(0).getScrollTargetView());
            }
        }, 300);
    }

    /**
     * Switch fragment
     * @param position fragment index
     */
    private void switchFragment(int position) {
        BaseFragment toFragment = mFragmentList.get(position);
        BaseFragment fromFragment = mFragmentList.get(mCurrFragmentIndex);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!toFragment.isAdded()) {
            transaction.hide(fromFragment).add(R.id.fragment_container, toFragment).commit();
        } else {
            transaction.hide(fromFragment).show(toFragment).commit();
        }
        mCurrFragmentIndex = position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1_toolbar:
                Toast.makeText(this, "Click left button.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2_toolbar:
                Toast.makeText(this, "Click right button.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
