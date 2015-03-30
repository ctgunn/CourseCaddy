package com.gunn.coursecaddy.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Created by SESA300553 on 3/22/2015.
 */
public class GolfNowContract {

    public final String LOG_TAG = GolfNowContract.class.getSimpleName();

    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "com.gunn.sunshine.app";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_COURSE = "course";
    public static final String PATH_USER = "user";
    public static final String PATH_ROUND = "round";
    public static final String PATH_ADDRESS = "address";

    /* Inner class that defines the table contents of the course table */
    public static final class CourseEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_COURSE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_COURSE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_COURSE;

        // Table name
        public static final String TABLE_NAME = "course";

        public static final String COLUMN_COURSE_NAME = "course_name";
        public static final String COLUMN_COURSE_PHONE_NUMBER = "course_phone_number";
        public static final String COLUMN_COURSE_ADDRESS_ID = "course_address_id";
        public static final String COLUMN_COURSE_LATITUDE = "course_latitude";
        public static final String COLUMN_COURSE_LONGITUDE = "course_longitude";
        public static final String COLUMN_COURSE_WEB_URL = "course_web_url";
        public static final String COLUMN_COURSE_PAR = "course_par";
        public static final String COLUMN_COURSE_SLOPE = "course_slope";
        public static final String COLUMN_COURSE_AVERAGE_RATING = "course_average_rating";
        public static final String COLUMN_COURSE_DESCRIPTION = "course_description";
        public static final String COLUMN_COURSE_DEFAULT_THUMBNAIL_URL = "course_default_thumbnail_url";
        public static final String COLUMN_COURSE_DEFAULT_SMALL_IMAGE_URL = "course_default_small_image_url";



        public static Uri buildCourseUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    /* Inner class that defines the table contents of the user table */
    public static final class UserEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_USER).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        // Table name
        public static final String TABLE_NAME = "user";

        public static final String COLUMN_SCORING_AVERAGE = "scoring_average";
        public static final String COLUMN_ROUNDS_PLAYED = "rounds_played";
        public static final String COLUMN_VS_SCORING_AVERAGE = "vs_scoring_average";
        public static final String COLUMN_LOW_ROUND = "low_round";
        public static final String COLUMN_LOW_ROUND_DATE = "low_round_date";
        public static final String COLUMN_LOW_ROUND_COURSE = "low_round_course";
//        public static final String COLUMN_PAR_3_SCORING_AVERAGE = "par_3_scoring_average";
//        public static final String COLUMN_PAR_4_SCORING_AVERAGE = "par_4_scoring_average";
//        public static final String COLUMN_PAR_5_SCORING_AVERAGE = "par_5_scoring_average";
        public static final String COLUMN_EAGLES_SCORED = "eagles_scored";
        public static final String COLUMN_BIRDIES_SCORED = "birdies_scored";

        public static Uri buildUserUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    /* Inner class that defines the table contents of the round table */
    public static final class RoundEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ROUND).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ROUND;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ROUND;

        // Table name
        public static final String TABLE_NAME = "round";

        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_SUBPAR_STROKES = "subpar_strokes";

        // These columns will hold the actual score that the user recorded on each hole.
        public static final String COLUMN_HOLE_1 = "hole_1";
        public static final String COLUMN_HOLE_2 = "hole_2";
        public static final String COLUMN_HOLE_3 = "hole_3";
        public static final String COLUMN_HOLE_4 = "hole_4";
        public static final String COLUMN_HOLE_5 = "hole_5";
        public static final String COLUMN_HOLE_6 = "hole_6";
        public static final String COLUMN_HOLE_7 = "hole_7";
        public static final String COLUMN_HOLE_8 = "hole_8";
        public static final String COLUMN_HOLE_9 = "hole_9";
        public static final String COLUMN_HOLE_10 = "hole_10";
        public static final String COLUMN_HOLE_11 = "hole_11";
        public static final String COLUMN_HOLE_12 = "hole_12";
        public static final String COLUMN_HOLE_13 = "hole_13";
        public static final String COLUMN_HOLE_14 = "hole_14";
        public static final String COLUMN_HOLE_15 = "hole_15";
        public static final String COLUMN_HOLE_16 = "hole_16";
        public static final String COLUMN_HOLE_17 = "hole_17";
        public static final String COLUMN_HOLE_18 = "hole_18";

        // These columns will hold the par for all 18 holes.
        public static final String COLUMN_PAR_1 = "par_1";
        public static final String COLUMN_PAR_2 = "par_2";
        public static final String COLUMN_PAR_3 = "par_3";
        public static final String COLUMN_PAR_4 = "par_4";
        public static final String COLUMN_PAR_5 = "par_5";
        public static final String COLUMN_PAR_6 = "par_6";
        public static final String COLUMN_PAR_7 = "par_7";
        public static final String COLUMN_PAR_8 = "par_8";
        public static final String COLUMN_PAR_9 = "par_9";
        public static final String COLUMN_PAR_10 = "par_10";
        public static final String COLUMN_PAR_11 = "par_11";
        public static final String COLUMN_PAR_12 = "par_12";
        public static final String COLUMN_PAR_13 = "par_13";
        public static final String COLUMN_PAR_14 = "par_14";
        public static final String COLUMN_PAR_15 = "par_15";
        public static final String COLUMN_PAR_16 = "par_16";
        public static final String COLUMN_PAR_17 = "par_17";
        public static final String COLUMN_PAR_18 = "par_18";

        public static Uri buildRoundUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }


    /* Inner class that defines the table contents of the round table */
    public static final class AddressEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ADDRESS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ADDRESS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ADDRESS;

        // Table name
        public static final String TABLE_NAME = "address";

        public static final String COLUMN_ADDRESS_TYPE = "address_type";

        // The location setting string is what will be sent to openweathermap
        // as the location query.
        public static final String COLUMN_LINE_1 = "line_1";
        public static final String COLUMN_LINE_2 = "line_2";

        // Human readable location string, provided by the API.  Because for styling,
        // "Nashville" is more recognizable than 37244.
        public static final String COLUMN_CITY_NAME = "city_name";
        public static final String COLUMN_STATE_NAME = "state_name";
        public static final String COLUMN_POSTAL_CODE = "postal_code";
        public static final String COLUMN_COUNTRY_CODE = "country_code";

        public static Uri buildAddressUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
