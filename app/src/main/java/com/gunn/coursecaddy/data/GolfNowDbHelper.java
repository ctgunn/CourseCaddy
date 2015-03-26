package com.gunn.coursecaddy.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.gunn.coursecaddy.data.GolfNowContract.CourseEntry;
import com.gunn.coursecaddy.data.GolfNowContract.UserEntry;
import com.gunn.coursecaddy.data.GolfNowContract.RoundEntry;
import com.gunn.coursecaddy.data.GolfNowContract.AddressEntry;

/**
 * Created by SESA300553 on 3/22/2015.
 */
public class GolfNowDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "coursecaddy.db";

    public GolfNowDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_COURSE_TABLE = "CREATE TABLE " + CourseEntry.TABLE_NAME + " (" +
            CourseEntry._ID + " INTEGER PRIMARY KEY," +
            CourseEntry.COLUMN_COURSE_NAME + " TEXT UNIQUE NOT NULL, " +
            CourseEntry.COLUMN_COURSE_PHONE_NUMBER + " TEXT NOT NULL, " +
            CourseEntry.COLUMN_COURSE_ADDRESS_ID + " TEXT NOT NULL, " +
            CourseEntry.COLUMN_COURSE_LATITUDE + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_LONGITUDE + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_WEB_URL + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_PAR + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_SLOPE + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_AVERAGE_RATING + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_DESCRIPTION + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_DEFAULT_THUMBNAIL_URL + " TEXT NOT NULL " +
            CourseEntry.COLUMN_COURSE_DEFAULT_SMALL_IMAGE_URL + " TEXT NOT NULL " +
        " );";

        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
            UserEntry._ID + " INTEGER PRIMARY KEY," +
            UserEntry.COLUMN_SCORING_AVERAGE + " TEXT UNIQUE NOT NULL, " +
            UserEntry.COLUMN_ROUNDS_PLAYED + " TEXT NOT NULL, " +
            UserEntry.COLUMN_VS_SCORING_AVERAGE + " TEXT NOT NULL, " +
            UserEntry.COLUMN_LOW_ROUND + " TEXT NOT NULL " +
            UserEntry.COLUMN_LOW_ROUND_DATE + " TEXT NOT NULL " +
            UserEntry.COLUMN_LOW_ROUND_COURSE + " TEXT NOT NULL " +
            UserEntry.COLUMN_EAGLES_SCORED + " TEXT NOT NULL " +
            UserEntry.COLUMN_BIRDIES_SCORED + " TEXT NOT NULL " +
        " );";

        final String SQL_CREATE_ROUND_TABLE = "CREATE TABLE " + RoundEntry.TABLE_NAME + " (" +
            RoundEntry._ID + " INTEGER PRIMARY KEY," +
            RoundEntry.COLUMN_COURSE_ID + " TEXT UNIQUE NOT NULL, " +
            RoundEntry.COLUMN_USER_ID + " TEXT NOT NULL, " +
            RoundEntry.COLUMN_DATE + " TEXT NOT NULL, " +
            RoundEntry.COLUMN_HOLE_1 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_2 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_3 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_4 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_5 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_6 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_7 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_8 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_9 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_10 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_11 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_12 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_13 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_14 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_15 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_16 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_17 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_HOLE_18 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_1 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_2 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_3 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_4 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_5 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_6 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_7 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_8 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_9 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_10 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_11 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_12 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_13 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_14 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_15 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_16 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_17 + " TEXT NOT NULL " +
            RoundEntry.COLUMN_PAR_18 + " TEXT NOT NULL " +
        " );";

        final String SQL_CREATE_ADDRESS_TABLE = "CREATE TABLE " + AddressEntry.TABLE_NAME + " (" +
            AddressEntry._ID + " INTEGER PRIMARY KEY," +
            AddressEntry.COLUMN_ADDRESS_TYPE + " TEXT UNIQUE NOT NULL, " +
            AddressEntry.COLUMN_LINE_1 + " TEXT NOT NULL, " +
            AddressEntry.COLUMN_LINE_2 + " TEXT NOT NULL, " +
            AddressEntry.COLUMN_CITY_NAME + " TEXT NOT NULL " +
            AddressEntry.COLUMN_STATE_NAME + " TEXT NOT NULL " +
            AddressEntry.COLUMN_POSTAL_CODE + " TEXT NOT NULL " +
            AddressEntry.COLUMN_COUNTRY_CODE + " TEXT NOT NULL " +
        " );";

        sqLiteDatabase.execSQL(SQL_CREATE_COURSE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ROUND_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ADDRESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LocationEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WeatherEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
