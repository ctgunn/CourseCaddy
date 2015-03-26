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
    private static CourseCaddySyncService sCourseCaddySyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("SunshineSyncService", "onCreate - SunshineSyncService");
        synchronized (sSyncAdapterLock) {
            if (sCourseCaddySyncAdapter == null) {
                sCourseCaddySyncAdapter = new CourseCaddySyncService(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sCourseCaddySyncAdapter.getSyncAdapterBinder();
    }
}
