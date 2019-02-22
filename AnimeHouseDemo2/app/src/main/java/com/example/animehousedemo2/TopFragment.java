package com.example.animehousedemo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TopFragment extends Fragment {

    EditText editTop;
    String InputDataAnime[] = {"upcoming", "airing", "tv", "movie", "ova", "special"};
    String InputDataManga[] = {"novels", "oneshots"};
    String InputDataBoth[] = {"bypopularity", "favorite"};
    Button searchBtnTop;
    //the parameter.
    String type = "";
    String parameter = ""; //specify the period for the anime / manga.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_top, container, false);

        Button searchBtnTop = (Button) v.findViewById(R.id.searchBtnTop);
        EditText editTop = (EditText) v.findViewById(R.id.tabTop);
                searchBtnTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();

                    }
                });
        setHasOptionsMenu(true);
        return v;
    }

    public boolean check_Input_Data(String test_word) {
        boolean check = false;
        if (search_Array(InputDataAnime, test_word)) {
            type = "anime";
            parameter = test_word;
            return true;
        } else if (search_Array(InputDataManga, test_word)) {
            type = "manga";
            parameter = test_word;
            return true;
        } else if (search_Array(InputDataBoth, test_word)) {
            type = "anime";
            parameter = test_word;
            return true;
        }
        return false;
    }

    public boolean search_Array(String[] array, String inputData) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].contentEquals(inputData)) {
                return true;
            }
        }
        return false;
    }
}
