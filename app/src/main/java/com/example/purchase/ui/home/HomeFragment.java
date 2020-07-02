package com.example.purchase.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.purchase.R;
import com.example.purchase.Utils.RecycleViewMargin;
import com.example.purchase.adapter.DepartmentsAdapter;
import com.example.purchase.adapter.SectionRecyclerViewAdapter;
import com.example.purchase.models.SectionModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView departmentRecyclerView, recyclerView;
    private DepartmentsAdapter departmentsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        departmentRecyclerView = view.findViewById(R.id.departmentRecyclerView);

        recyclerView = view.findViewById(R.id.sectioned_recycler_view);
        //departmentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        departmentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecycleViewMargin decoration = new RecycleViewMargin(10, 1);

        departmentRecyclerView.addItemDecoration(decoration);

        departmentsAdapter = new DepartmentsAdapter(getContext());
        departmentRecyclerView.setAdapter(departmentsAdapter);
        populateRecyclerView();
    }

    //populate recycler view
    private void populateRecyclerView() {
        ArrayList<SectionModel> sectionModelArrayList = new ArrayList<>();
        //for loop for sections
        for (int i = 1; i <= 5; i++) {
            ArrayList<String> itemArrayList = new ArrayList<>();
            //for loop for items
            for (int j = 1; j <= 10; j++) {
                itemArrayList.add("Item " + j);
            }

            //add the section and items to array list
            sectionModelArrayList.add(new SectionModel("DEPARTMENT NAME - " + i, itemArrayList));
        }

        SectionRecyclerViewAdapter adapter = new SectionRecyclerViewAdapter(getActivity(), sectionModelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    }



