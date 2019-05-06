package com.vadimfedchuk1994gmail.bottomnavigationviewpager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vadimfedchuk1994gmail.bottomnavigationviewpager.R;

public class Fragment_One extends Fragment {

    private String titlePage;

    private static final String ARGUMENT_PAGE_TITLE = "argument_page_title";
    TextView title_text_view;

    public static Fragment_One newInstance(String param) {
        Fragment_One fragment = new Fragment_One();
        Bundle args = new Bundle();
        args.putString(ARGUMENT_PAGE_TITLE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titlePage = getArguments().getString(ARGUMENT_PAGE_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        title_text_view = view.findViewById(R.id.title_converter);
        title_text_view.setText(titlePage);
        return view;
    }
}
