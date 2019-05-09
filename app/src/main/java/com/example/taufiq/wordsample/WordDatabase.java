package com.example.taufiq.wordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Word.class}, version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    // define the DAOs that work with the database
    public abstract WordDao wordDao();

    private static WordDatabase INSTANCE;

    public static WordDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordDatabase.class){
                if (INSTANCE == null){
                    // Create database here
                    /**
                    * Uses DatabaseBuilder to create database
                    * */
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDatabase.class,"word_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}