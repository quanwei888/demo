package com.lucky.demo.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lucky.demo.R;
import com.lucky.demo.fragment.WordDetail;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                WordDetail wd = (WordDetail)fragmentManager.findFragmentById(R.id.fragWordDetail);
                wd.setData("AAA","bbb","CCC");
            }
        });
    }
}
