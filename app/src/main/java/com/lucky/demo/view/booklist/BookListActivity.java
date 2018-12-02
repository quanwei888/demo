package com.lucky.demo.view.booklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lucky.demo.R;
import com.lucky.demo.data.room.RoomEntity;

import java.util.List;

public class BookListActivity extends AppCompatActivity implements BookListContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
    }

    @Override
    public void onBookListLoaded(List<RoomEntity.Book> books) {

    }
}
