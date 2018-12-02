package com.lucky.demo.view.booklist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.lucky.demo.R;
import com.lucky.demo.data.room.RoomDb;
import com.lucky.demo.data.room.RoomEntity.Book;
import com.lucky.demo.data.room.RoomEntity.User;
import com.lucky.demo.databinding.ActivityBookListBinding;
import com.lucky.demo.databinding.ActivityMainBinding;
import com.lucky.demo.util.AppExecutors;
import com.lucky.demo.util.TestDataUtil;
import com.lucky.demo.view.booklist.BookListContract.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookListActivity extends AppCompatActivity implements View {
    Presenter presenter;
    ActivityBookListBinding bindding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindding = DataBindingUtil.setContentView(this, R.layout.activity_book_list);


        ObservableListView listView = (ObservableListView) findViewById(R.id.list);

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 10; i++) {
            Map<String, Object> row = new HashMap<String, Object>();
            row.put("name", "aaa");
            row.put("coun", "bbb");
            data.add(row);
        }

        BookListAdapter adapter = new BookListAdapter(data);
        listView.setAdapter(adapter);

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onInitDataSuccess(Map<String, Object> data) {
    }
}
