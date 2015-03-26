package com.gunn.coursecaddy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gunn.coursecaddy.sync.CourseCaddySyncAdapter;


public class MainActivity extends ActionBarActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String COURSEDETAILFRAGMENT_TAG = "CDFTAG";
    private Boolean userLoggedIn = false;
    private boolean mTwoPane;
    private String mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mLocation = Utility.getPreferredLocation(this);

        setContentView(R.layout.activity_main);

        if (findViewById(R.id.course_detail_container) != null) {
            // The detail container view will be present only in the large-screen layouts
            // (res/layout-sw600dp). If this view is present, then the activity should be
            // in two-pane mode.
            mTwoPane = true;
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.course_detail_container, new CourseDetailFragment(), COURSEDETAILFRAGMENT_TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
            getSupportActionBar().setElevation(0f);
        }

        CourseListFragment courseListFragment =  ((CourseListFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fragment_forecast));
        courseListFragment.setUseTodayLayout(!mTwoPane);

        CourseCaddySyncAdapter.initializeSyncAdapter(this);

        if(!userLoggedIn) {

        }
        else {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}