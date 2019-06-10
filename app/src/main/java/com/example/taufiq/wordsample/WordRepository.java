package com.example.taufiq.wordsample;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * A Repository is a class that abstracts access to multiple data sources.
 * The Repository is not part of the Architecture Components libraries,
 * but is a suggested best practice for code separation and architecture.
 * A Repository class handles data operations.
 * It provides a clean API to the rest of the app for app data.
 */
public class WordRepository {

    // member variables for the dao and list
    private WordDao awordDao;
    private LiveData<List<Word>> mAllWords;

    // add constructor that gets a handle to the database and initializes

    public WordRepository(Application application) {
        WordDatabase database = WordDatabase.getDatabase(application);
        awordDao = database.wordDao();
        mAllWords = awordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsync(awordDao).execute(word);
    }

    public static class insertAsync extends AsyncTask<Word, Void, Void> {

        private WordDao asyncDaos;

        public insertAsync(WordDao asyncDaos) {
            this.asyncDaos = asyncDaos;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            asyncDaos.insert(words[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsync(awordDao).execute();
    }


    private static class deleteAllAsync extends AsyncTask<Void, Void, Void> {
        private WordDao dao;

        deleteAllAsync(WordDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}
