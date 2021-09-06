package com.ahaguru.teacherahaguru.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.utils.TeacherRequestListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TeachersAdapter extends RecyclerView.Adapter<TeachersAdapter.MyViewHolder> implements PopupMenu.OnMenuItemClickListener {

    private TeacherRoomDatabase teacherRoomDatabase;
    private TeacherViewModel teacherViewModel;
    private List<Teachers> teachers = new ArrayList<>();
    private Context context;


    PopupMenu popupMenu;

    @NotNull
    @Override
    public TeachersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teachers_recycler, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeachersAdapter.MyViewHolder holder, int position) {
        Teachers teacher = teachers.get(position);
        holder.teacherNameList.setText(teacher.getName());

        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupMenu = new PopupMenu(v.getContext(), v);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
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
                    }
                });
                popupMenu.show();
            }
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


    class MyViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MyViewHolder";
        private TextView teacherNameList;
        private ImageView menu;
        private MenuItem suspend, delete, unsuspend;

        public MyViewHolder(View itemView) {
            super(itemView);

            teacherNameList = itemView.findViewById(R.id.teacherNameList);
            menu = itemView.findViewById(R.id.menu);
            suspend = itemView.findViewById(R.id.menu_suspend);
            delete = itemView.findViewById(R.id.menu_delete);

//            menu.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            showPopupMenu(v);
//        }

//        private void showPopupMenu(View view) {
//            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
//            popupMenu.inflate(R.menu.popup_menu);
//            popupMenu.setOnMenuItemClickListener(this);
//            popupMenu.show();
//        }
//
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//            switch (item.getItemId()) {
//
//                case R.id.menu_suspend:
//                    Log.d(TAG, "onMenuItemClick: menu_suspend");
//                    return true;
//
//                case R.id.menu_delete:
//                    teachers.remove(position);
//                                notifyItemChanged(position);
//                                notifyItemRangeChanged(position, teachers.size());
//
//                default:
//                    return false;
//
//            }
//        }
    }
}
