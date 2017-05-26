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

        db.execSQL("INSERT INTO game VALUES (1,0,5,0)");

        db.execSQL("INSERT INTO cereals VALUES (1,'Orge',0,2500,1,2500,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (2,'Avoine',0,15000,5,15000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (3,'Colza',0,50000,20,50000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (4,'Houblon',0,100000,50,100000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (5,'Maïs',0,250000,100,250000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (6,'Riz',0,500000,500,500000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (7,'Seigle',0,1000000,1000,1000000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (8,'Lin',0,10000000,2000,10000000,0,0)");

        db.execSQL("INSERT INTO cereals VALUES (9,'Blé',0,5,0.1,5,0,0)");
    }
}
