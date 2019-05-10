package com.example.taufiq.wordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater minflater;
    private List<Word> mWords; // cache copy of words


     public WordListAdapter(Context context) {
        minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = minflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            wordViewHolder.words.setText(current.aWord);
        } else {
            // cover the case of data not being ready yet.
            wordViewHolder.words.setText(R.string.no_word);
        }
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWords != null) {
            return mWords.size();
        } else {
            return 0;
        }

    }


    class WordViewHolder extends RecyclerView.ViewHolder {
         TextView words;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            words = itemView.findViewById(R.id.word_id);
        }
    }
}
