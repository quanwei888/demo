package com.lucky.demo.view.bookwords;


import com.lucky.demo.data.Word;
import com.lucky.demo.view.BasePresenter;
import com.lucky.demo.view.BaseView;

import java.util.List;

/**
 * Created by qw on 18-12-1.
 */

public class BookWordsContract {
    interface View extends BaseView<Presenter> {
        void onWordListLoaded(List<Word> words);
    }


    interface Presenter extends BasePresenter {
        List<Word> getWordList();

        void tagWord(int wordId, int tag);
    }
}
