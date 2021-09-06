package com.ahaguru.teacherahaguru.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.utils.TeacherRequestListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.MyViewHolder> {
    private List<Teachers> teachers = new ArrayList<>();
    TeacherRequestListener teacherRequestListener;

    public RequestsAdapter(TeacherRequestListener teacherRequestListener) {
        this.teacherRequestListener = teacherRequestListener;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.requests_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Teachers currentTeacher = teachers.get(position);
        holder.name.setText(currentTeacher.getName());
        holder.mail.setText(currentTeacher.getEmail());
  //      holder.name.setText(currentTeachers.getName());

        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                teacherRequestListener.onApprove(currentTeacher);

            }
        });

        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                teacherRequestListener.onReject(currentTeacher);

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

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, mail, subject;
        private Button approve, reject;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvTeacherName);
            mail = itemView.findViewById(R.id.tvTeacherMail);
            subject = itemView.findViewById(R.id.tvTeacherSubject);
            cardView = itemView.findViewById(R.id.cardView);
            approve = itemView.findViewById(R.id.btnApprove);
            reject = itemView.findViewById(R.id.btnReject);

        }

        public void bind(String text) {
            name.setText(text);
        }

    }
}
