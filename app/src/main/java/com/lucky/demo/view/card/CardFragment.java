package com.lucky.demo.view.card;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucky.demo.R;
import com.lucky.demo.data.Word;

public class CardFragment extends Fragment {
    Word mWord;

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance(Word word) {
        CardFragment fragment = new CardFragment();
        fragment.mWord = word;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

}
