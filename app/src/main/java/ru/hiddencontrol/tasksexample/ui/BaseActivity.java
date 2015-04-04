package ru.hiddencontrol.tasksexample.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ru.hiddencontrol.tasksexample.R;


public class BaseActivity extends ActionBarActivity {

    private static final Class[] TASK1 =
            new Class[] { AActivity.class, BActivity.class, CActivity.class, DActivity.class };

    private static final Class[] TASK2 =
            new Class[] { XActivity.class, YActivity.class, ZActivity.class };


    @InjectView(R.id.text_back_stack)
    public TextView mBackStackText;
    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.inject(this);
        mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBackStack();
    }

    private void updateBackStack() {
        List<ActivityManager.RunningTaskInfo> tasks = mActivityManager.getRunningTasks(100);
        mBackStackText.setText("");
        for (ActivityManager.RunningTaskInfo r : tasks) {
            mBackStackText.append("Task: " + r.id + "(" + r.description +") "
                    + "Num Activities = " + r.numActivities + "\n");

        }
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_a)
    public void openActivityA() {
        startActivity(new Intent(this, AActivity.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_b)
    public void openActivityB() {
        startActivity(new Intent(this, BActivity.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_c)
    public void openActivityC() {
        startActivity(new Intent(this, CActivity.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_d)
    public void openActivityD() {
        startActivity(new Intent(this, DActivity.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_x)
    public void openActivityX() {
        Intent intent = new Intent(this, XActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_y)
    public void openActivityY() {
        startActivity(new Intent(this, YActivity.class));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_z)
    public void openActivityZ() {
        startActivity(new Intent(this, ZActivity.class));
    }
}
