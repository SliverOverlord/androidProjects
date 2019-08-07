package com.example.turtle.deniofinalproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingListFragment extends Fragment {
    private List<ShoppingListItem> itemList = new ArrayList<>();


    public ShoppingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        preparedItemData();
        return view;

    }

    private void preparedItemData(){
        for (int i = 0; i < itemList.size(); i++){
            //ShoppingListItem newItem = new ShoppingListItem()
        }
    }

}
