package com.ahaguru.teacherahaguru.ui.Manage.Requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.databinding.RequestsCardBinding;
import com.ahaguru.teacherahaguru.utils.TeacherRequestListener;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.MyViewHolder> {
    private List<Teachers> teachers = new ArrayList<>();
    TeacherRequestListener teacherRequestListener;
    RequestsCardBinding binding;

    public RequestsAdapter(TeacherRequestListener teacherRequestListener) {
        this.teacherRequestListener = teacherRequestListener;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RequestsCardBinding binding = RequestsCardBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Teachers currentTeacher = teachers.get(position);
        holder.name.setText(currentTeacher.getName());
        holder.mail.setText(currentTeacher.getEmail());
//        holder.subject.setText(currentTeacher.getTeacher_registration_subject());

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

        TextView name, mail, subject;
        Button approve, reject;
        RequestsCardBinding binding;

        public MyViewHolder(@NonNull RequestsCardBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

            name = binding.tvTeacherName;
            mail = binding.tvTeacherMail;
            subject = binding.tvTeacherSubject;
            approve = binding.btnApprove;
            reject = binding.btnReject;

        }

        public void bind(String text) {
            binding.tvTeacherName.setText(text);
        }

    }
}