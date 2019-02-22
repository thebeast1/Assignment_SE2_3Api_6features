package com.example.animehousedemo2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class SearchFragment extends Fragment {
    EditText editSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


}
