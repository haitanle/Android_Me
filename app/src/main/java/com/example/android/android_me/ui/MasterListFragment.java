package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    /**
     * Mandatory empty constructor
     */
    public MasterListFragment() {
    }

    /**
     * onCreateView to inflate the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MasterListAdapter masterAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        //Inflate the Android

        // inflate and tie the fragment to the container
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        // get the fragment for setting data
        GridView masterGridView = (GridView) rootView.findViewById(R.id.master_list_grid_view);

        // set the data (adapter) to the gridView
        masterGridView.setAdapter(masterAdapter);

        return rootView;
    }
}
