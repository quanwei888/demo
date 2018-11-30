package com.lucky.demo.view.card;

import android.support.annotation.NonNull;

import com.lucky.demo.data.Word;
import com.lucky.demo.view.home.HomeContract;

public class CardPresenter implements CardContract.Presenter {
    HomeContract.View mHomeView;

    public CardPresenter(@NonNull HomeContract.View homeView) {
        mHomeView = homeView;
    }

    @Override
    public Word getNextWord() {
        return null;
    }

    @Override
    public Word getLastWord() {
        return null;
    }

    @Override
    public Word next() {
        return null;
    }

    @Override
    public Word getWord() {
        return null;
    }

    @Override
    public int getWordTag(int wordId) {
        return 0;
    }

    @Override
    public void setWordTag(int wordId, int tag) {

    }
}
