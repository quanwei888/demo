package com.lucky.demo.view.booklist;

import com.lucky.demo.data.room.RoomEntity;

import java.util.List;


interface BookListContract {
    interface View {
        void onBookListLoaded(List<RoomEntity.Book> books);
    }

    interface Presenter {
        List<RoomEntity.Book> getBookList();
    }

}
