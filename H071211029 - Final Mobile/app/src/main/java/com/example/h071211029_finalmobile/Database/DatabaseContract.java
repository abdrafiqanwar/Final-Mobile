package com.example.h071211029_finalmobile.Database;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "database";
    public static final class TaskColumns implements BaseColumns {
        public static String TITLE = "title";
        public static String NAME = "name";
        public static String VOTE_AVERAGE = "vote_average";
        public static String OVERVIEW = "overview";
        public static String RELEASE_DATE = "release_date";
        public static String FIRST_AIR_DATE = "first_air_date";
        public static String POSTER_PATH = "poster_path";
        public static String BACKDROP_PATH = "backdrop_path";
    }
}
