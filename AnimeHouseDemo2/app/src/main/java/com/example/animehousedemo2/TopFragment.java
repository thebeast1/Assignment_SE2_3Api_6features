package com.example.animehousedemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TopFragment extends Fragment {

    EditText editTop;
    String InputDataAnime[] = {"upcoming", "airing", "tv", "movie", "ova", "special"};
    String InputDataManga[] = {"novels", "oneshots"};
    String InputDataBoth[] = {"bypopularity", "favorite"};
    Button searchBtnTop;
    TextView errorText;
    //the parameter.
    String type = "";
    String parameter = ""; //specify the period for the anime / manga.
    String input = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_top, container, false);

        searchBtnTop = (Button) v.findViewById(R.id.searchBtnTop);
        editTop = (EditText) v.findViewById(R.id.editTop);
        errorText = v.findViewById(R.id.errorText);
        errorText.setText("");
        searchBtnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorText.setText("");
                input = "" + editTop.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(getContext(), "Enter something to search...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "checking the input data ...", Toast.LENGTH_SHORT).show();
                    if (check_Input_Data(input)) {
                        Toast.makeText(getContext(), "The input data correct", Toast.LENGTH_SHORT).show();
                        //intent to the list.
                        Intent intent = new Intent(getActivity().getBaseContext(),top_results.class);
                        intent.putExtra("key",input);

                        //START ACTIVITY
                        getActivity().startActivity(intent);


                    } else {
                        errorText.setText(R.string.error_message);
                    }
                }
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
            Toast.makeText(getContext(), "anime type", Toast.LENGTH_SHORT).show();
            return true;
        } else if (search_Array(InputDataManga, test_word)) {
            type = "manga";
            parameter = test_word;
            Toast.makeText(getContext(), "manga type", Toast.LENGTH_SHORT).show();
            return true;
        } else if (search_Array(InputDataBoth, test_word)) {
            type = "anime";
            parameter = test_word;
            Toast.makeText(getContext(), "both type", Toast.LENGTH_SHORT).show();
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
