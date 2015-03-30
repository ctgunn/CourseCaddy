package com.gunn.coursecaddy.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by SESA300553 on 3/23/2015.
 */
public class CourseCaddySyncService extends Service {
    private final String LOG_TAG = CourseCaddySyncService.class.getSimpleName();

    private static final Object sSyncAdapterLock = new Object();
    private static CourseCaddySyncAdapter sCourseCaddySyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("CourseCaddySyncService", "onCreate - CourseCaddySyncService");
        synchronized (sSyncAdapterLock) {
            if (sCourseCaddySyncAdapter == null) {
                sCourseCaddySyncAdapter = new CourseCaddySyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sCourseCaddySyncAdapter.getSyncAdapterBinder();
    }
}
