package com.lucky.demo.view.card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucky.demo.R;

public class CardActivity extends AppCompatActivity {
    View mWordView;
    View mAccentView;
    View mSentEnView;
    View mSentChView;
    View mEnMeanView;
    View mMeanView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Button button=(Button)findViewById(R.id.button2);
        mWordView=(View)findViewById(R.id.wordView);

        button.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) mWordView.getLayoutParams();
            p.setMargins(p.leftMargin,p.topMargin+100,p.rightMargin,p.bottomMargin);
            mWordView.setPadding(mWordView.getPaddingLeft(),
                    mWordView.getPaddingTop()-100,
                    mWordView.getPaddingRight(),
                    mWordView.getPaddingBottom());
        } });
    }
}
