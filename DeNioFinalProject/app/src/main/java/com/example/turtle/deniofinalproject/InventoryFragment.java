package com.example.turtle.deniofinalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class InventoryFragment extends Fragment {
    private List<InventoryItem> inventoryList = new ArrayList<>();

    public InventoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        preparedInventoryData();

        return view;
    }

    private void preparedInventoryData(){
        InventoryItem newItem = new InventoryItem("eggs",12);
        inventoryList.add(newItem);
        newItem = new InventoryItem("bread",12);
        inventoryList.add(newItem);
        newItem = new InventoryItem("milk",18);
        inventoryList.add(newItem);
    }
}
