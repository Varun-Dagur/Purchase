package com.example.purchase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.purchase.R;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.DepartmentHolder> {

    Context context;

    public DepartmentsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DepartmentsAdapter.DepartmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.department_status_row, parent, false);
        return new DepartmentsAdapter.DepartmentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 5;
    }


    public class DepartmentHolder extends RecyclerView.ViewHolder{

        public DepartmentHolder(@NonNull View itemView) {
            super(itemView);



        }
    }
}
