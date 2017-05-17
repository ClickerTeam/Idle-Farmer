package com.team_clicker.idlefarmer.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pierr on 17/05/2017.
 */

public class BDDHelper extends SQLiteOpenHelper {

    public BDDHelper(Context context) {
        super(context, "infos.db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE game (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "exp REAL NOT NULL, " +
                                        "money REAL NOT NULL, " +
                                        "earnBySeconds REAL NOT NULL)");

        db.execSQL("CREATE TABLE cereals (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            "name TEXT NOT NULL, " +
                                            "level INTEGER NOT NULL, " +
                                            "basePrice REAL NOT NULL," +
                                            "baseYield REAL NOT NULL," +
                                            "currentPrice REAL NOT NULL," +
                                            "currentYield REAL NOT NULL," +
                                            "growthTime INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE technologies (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                "name TEXT NOT NULL, " +
                                                "price REAL NOT NULL, " +
                                                "coeff REAL NOT NULL)");
    }
}
