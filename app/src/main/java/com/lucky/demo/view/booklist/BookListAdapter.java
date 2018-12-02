package com.lucky.demo.view.booklist;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lucky.demo.R;
import com.lucky.demo.databinding.ItemBookListBinding;

import java.util.List;
import java.util.Map;

/**
 * Created by qw on 18-12-2.
 */

public class BookListAdapter extends BaseAdapter {
    List<Map<String, Object>> data;
    int layoutId;

    public BookListAdapter(List<Map<String, Object>> data) {
        this.data = data;
        this.layoutId = R.layout.item_book_list;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int pos) {
        return data.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ItemBookListBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setBook(data.get(pos));
        return binding.getRoot();
    }
}
