package com.example.taufiq.wordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepo;
    private LiveData<List<Word>> allWords;


    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepo = new WordRepository(application);
        allWords = wordRepo.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    public void insert(Word word){
        wordRepo.insert(word);
    }
}
