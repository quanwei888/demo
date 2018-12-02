package com.lucky.demo.view.bookwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lucky.demo.R;
import com.lucky.demo.data.Word;
import com.lucky.demo.view.BaseView;

import java.util.List;

public class BookWordsActivity extends AppCompatActivity implements BookWordsContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_words);
    }

    @Override
    public void onWordListLoaded(List<Word> words) {

    }

    @Override
    public void setPresenter(BookWordsContract.Presenter presenter) {

    }
}
