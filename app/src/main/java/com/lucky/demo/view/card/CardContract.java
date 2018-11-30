package com.lucky.demo.view.card;

import com.lucky.demo.data.Word;
import com.lucky.demo.view.home.HomeData;

public interface CardContract {
    interface View {

    }
    interface Presenter {
        Word getNextWord();
        Word getLastWord();
        Word next();
        Word getWord();
        int getWordTag(int wordId);
        void setWordTag(int wordId,int tag);
    }
}
