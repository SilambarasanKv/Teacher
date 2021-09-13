package com.ahaguru.teacherahaguru.ui.Manage.Teachers;


import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;

import com.ahaguru.teacherahaguru.databinding.TeachersRecyclerBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TeachersAdapter extends RecyclerView.Adapter<TeachersAdapter.MyViewHolder> implements PopupMenu.OnMenuItemClickListener {

    private List<Teachers> teachers = new ArrayList<>();


    PopupMenu popupMenu;

    @NotNull
    @Override
    public TeachersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TeachersRecyclerBinding binding = TeachersRecyclerBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeachersAdapter.MyViewHolder holder, int position) {
        Teachers teacher = teachers.get(position);
        holder.teacherNameList.setText(teacher.getName());

        holder.menu.setOnClickListener(v -> {

            popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {

                    case R.id.menu_suspend:
                        return true;

                    case R.id.menu_delete:
                        teachers.remove(position);
                        notifyItemChanged(position);
                        notifyItemRangeChanged(position, teachers.size());

                        return true;

                    default:
                        return false;

                }
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {

        return teachers.size();
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
        notifyDataSetChanged();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        TeachersRecyclerBinding binding;

        TextView teacherNameList;
        ImageView menu;

        public MyViewHolder(@NonNull TeachersRecyclerBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

//            teacherNameList = itemView.findViewById(R.id.teacherNameList);
//            menu = itemView.findViewById(R.id.menu);

            teacherNameList = binding.teacherNameList;
            menu = binding.menu;

        }
    }
}
