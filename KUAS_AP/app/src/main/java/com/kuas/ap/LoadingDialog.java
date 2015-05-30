package com.kuas.ap;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;

public class LoadingDialog extends Activity {
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = (int) (metrics.widthPixels * 0.80);
        getWindow().setLayout(screenWidth, ViewGroup.LayoutParams.WRAP_CONTENT);

        Bundle bundle = getIntent().getExtras();

        ProgressWheel ProgressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        ProgressWheel.setBarWidth(6);
        ProgressWheel.setMaterial(true);
        ((TextView) findViewById(R.id.title)).setText(bundle.getString("Title"));

        activity = this;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return true;
    }
}
