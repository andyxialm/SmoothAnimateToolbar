package cn.refactor.toolbarsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar;
import cn.refactor.smoothanimatetoolbar.SmoothScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmoothAnimateToolbar toolbar = (SmoothAnimateToolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.btn_1_toolbar).setOnClickListener(this);
        toolbar.findViewById(R.id.btn_2_toolbar).setOnClickListener(this);
        toolbar.attachToScrollView(((SmoothScrollView) findViewById(R.id.scrollView)));
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
