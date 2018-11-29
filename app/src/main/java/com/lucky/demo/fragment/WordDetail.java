package com.lucky.demo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucky.demo.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WordDetail.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WordDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordDetail extends Fragment {
    TextView txtWord;
    TextView txtAccent;
    TextView txtMean;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_word_detail, container, false);

        txtWord = (TextView)v.findViewById(R.id.txtWord);
        txtAccent = (TextView)v.findViewById(R.id.txtAccent);
        txtMean = (TextView)v.findViewById(R.id.txtMean);

        return v;
    }

    public void setData(String word,String acent,String mean) {
        txtWord.setText(word);
        txtAccent.setText(acent);
        txtMean.setText(mean);
    }
}
