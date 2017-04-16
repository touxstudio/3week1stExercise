package org.coursera.notifications;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import android.util.Log;

/**
 * Created by TouxStudio on 05/04/2017.
 */



@SuppressLint("NewApi")
public class MyJobService extends JobService {

    private static final String TAG = "MyJobService";

    @Override
    public boolean onStartJob(JobParameters params) {

        Log.d(TAG, "Performing long running task in scheduled job");
        // TODO(developer): add long running task here.
        return false;

    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
