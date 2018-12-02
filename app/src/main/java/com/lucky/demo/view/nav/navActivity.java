package com.lucky.demo.view.nav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lucky.demo.R;
import com.lucky.demo.view.booklist.BookListActivity;
import com.lucky.demo.view.card.CardActivity;
import com.lucky.demo.view.main.MainActivity;
import com.lucky.demo.view.wordlist.WordListActivity;

public class navActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        findViewById(R.id.card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CardActivity.class));
            }
        });
        findViewById(R.id.wordlist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), BookListActivity.class));
            }
        });
        findViewById(R.id.main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }

}
