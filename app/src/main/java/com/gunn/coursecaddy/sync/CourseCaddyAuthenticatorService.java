package com.gunn.coursecaddy.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by SESA300553 on 3/23/2015.
 */
public class CourseCaddyAuthenticatorService extends Service {
    // Instance field that stores the authenticator object
    private CourseCaddyAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new CourseCaddyAuthenticator(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
