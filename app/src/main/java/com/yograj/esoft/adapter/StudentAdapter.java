package com.yograj.esoft.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yograj.esoft.R;
import com.yograj.esoft.model.Student;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    Context context;
    List<Student> studentList;
    int imageid;
    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content,parent,false);
        return new StudentViewHolder(view);

    }
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, final int position) {

        final Student student = studentList.get(position);


            String gender=student.getGender();
            if(gender.equals("Female")){
                 imageid=R.drawable.noimageg;
            }
            else if(gender.equals("Male"))
            {
                 imageid=R.drawable.noimage;
            }


        int age = student.getAge();

        holder.imgProfile.setImageResource(imageid);
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(String.valueOf(age));
        holder.tvAddress.setText(student.getAddress());
        holder.tvGender.setText(student.getGender());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                studentList.remove(position);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgProfile;
        TextView tvName,tvGender,tvAge,tvAddress;
        Button btnDelete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            btnDelete=itemView.findViewById(R.id.btnDelete);



        }
    }
}
