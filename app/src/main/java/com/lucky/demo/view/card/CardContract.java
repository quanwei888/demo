package com.lucky.demo.view.card;

import com.lucky.demo.data.Word;

public interface CardContract {
    interface View {
    }
    interface Presenter {
        Word lastWord();
        Word next();
    }
}
