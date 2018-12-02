package com.lucky.demo.view.card;

import android.support.annotation.NonNull;

import com.lucky.demo.data.Task;
import com.lucky.demo.data.Word;
import com.lucky.demo.data.source.DataSource;
import com.lucky.demo.data.source.Repository;
import com.lucky.demo.view.BasePresenter;

public class CardPresenter implements CardContract.Presenter {
    CardContract.View view;
    DataSource ds;
    Task task;

    public CardPresenter(@NonNull CardContract.View view) {
        this.view = view;
        this.ds = Repository.getInstance(null, null);
    }


    @Override
    public Word lastWord() {
        return null;
    }

    @Override
    public Word next() {
        return null;
    }

}
