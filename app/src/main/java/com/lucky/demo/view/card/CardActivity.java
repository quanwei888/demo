package com.lucky.demo.view.card;

import android.app.ActionBar;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucky.demo.R;
import com.lucky.demo.data.Word;
import com.lucky.demo.databinding.ActivityCardBinding;
import com.lucky.demo.view.BaseView;

public class CardActivity extends AppCompatActivity implements CardContract.View {
    CardContract.Presenter mPresenter;
    ActivityCardBinding binding;

    TextView mWordTxt;
    TextView mPtTxt;
    TextView mEnExampleTxt;
    TextView mCnExampleTxt;

    Word mWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_card);


        mPresenter = new CardPresenter(this);

        mWordTxt = findViewById(R.id.word);
        mPtTxt = findViewById(R.id.pt);
        mEnExampleTxt = findViewById(R.id.enExample);
        mCnExampleTxt = findViewById(R.id.cnExample);

        mWord = mPresenter.next();
        showWord(mWord);

        findViewById(R.id.goonBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWord = mPresenter.next();
                showWord(mWord);
            }
        });
    }

    void showWord(Word word) {
        binding.setWord(word);

        //mWordTxt.setText(word.word);
        mPtTxt.setText(word.pt);
        if (word.examples.size() > 0) {
            mEnExampleTxt.setText(word.examples.get(0).en);
            mCnExampleTxt.setText(word.examples.get(0).cn);
        }
    }
}
