package com.gunn.coursecaddy.data;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by SESA300553 on 3/22/2015.
 */

public class GolfNowProvider extends ContentProvider {
    // The URI Matcher used by this content provider.
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private GolfNowDbHelper mOpenHelper;

    static final int COURSE = 100;
    static final int USER = 200;
    static final int ROUND = 300;
    static final int ADDRESS = 400;

    static UriMatcher buildUriMatcher() {
        // I know what you're thinking.  Why create a UriMatcher when you can use regular
        // expressions instead?  Because you're not crazy, that's why.

        // All paths added to the UriMatcher have a corresponding code to return when a match is
        // found.  The code passed into the constructor represents the code to return for the root
        // URI.  It's common to use NO_MATCH as the code for this case.
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = GolfNowContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.
        matcher.addURI(authority, GolfNowContract.PATH_COURSE, COURSE);

        matcher.addURI(authority, GolfNowContract.PATH_USER, USER);

        matcher.addURI(authority, GolfNowContract.PATH_ROUND, ROUND);

        matcher.addURI(authority, GolfNowContract.PATH_ADDRESS, ADDRESS);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new GolfNowDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        // Use the Uri Matcher to determine what kind of URI this is.
        final int match = sUriMatcher.match(uri);

        switch (match) {
            // Student: Uncomment and fill out these two cases
            case COURSE:
                return GolfNowContract.CourseEntry.CONTENT_TYPE;
            case USER:
                return GolfNowContract.UserEntry.CONTENT_TYPE;
            case ROUND:
                return GolfNowContract.RoundEntry.CONTENT_TYPE;
            case ADDRESS:
                return GolfNowContract.AddressEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    @TargetApi(16)
    public void shutdown() {
        mOpenHelper.close();
        super.shutdown();
    }
}
