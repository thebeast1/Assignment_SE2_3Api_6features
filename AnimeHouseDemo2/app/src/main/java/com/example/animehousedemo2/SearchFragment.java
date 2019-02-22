package com.example.animehousedemo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SearchFragment extends Fragment {
    EditText editSearch;
    Button searchBtnSearch;
    String input = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        searchBtnSearch = (Button) v.findViewById(R.id.searchBtnSearch);
        editSearch = (EditText) v.findViewById(R.id.editSearch);

        searchBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "" + editSearch.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(getContext(), "Enter something to search...", Toast.LENGTH_LONG).show();
                } else {
                    //intent to the list
                    Intent intent = new Intent(getActivity().getBaseContext(),search_result.class);
                    intent.putExtra("title",input);

                    //START ACTIVITY
                    getActivity().startActivity(intent);

                }
            }
        });

        setHasOptionsMenu(true);
        return v;
    }
}
