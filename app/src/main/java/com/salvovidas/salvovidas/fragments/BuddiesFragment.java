package com.salvovidas.salvovidas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salvovidas.salvovidas.R;
import com.salvovidas.salvovidas.adapters.BuddyAdapter;
import com.salvovidas.salvovidas.models.Buddy;

public class BuddiesFragment extends Fragment {

    BuddyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_buddies, container, false);

        setUpRecyclerView(rootView);
        return rootView;
    }

    private void setUpRecyclerView(ViewGroup view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new BuddyAdapter(getActivity(), Buddy.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getActivity());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        // default
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}

