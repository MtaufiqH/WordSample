package com.example.taufiq.wordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {


    // a method to insert a new Word
    @Insert
    void insert(Word word);

    // method to delete all words
    @Query("DELETE FROM word_table")
    void deleteAll();

    // method to call all Words
    @Query("SELECT * FROM word_table ORDER BY word ASC")
   LiveData<List<Word>> getAllWords();



}
