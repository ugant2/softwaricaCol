package com.yograj.esoft.ui.addstudent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yograj.esoft.R;
import com.yograj.esoft.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentFragment extends Fragment implements  View.OnClickListener  {

    String Gender, Age, Address, Username;
     static List<Student> studentList = new ArrayList<>();
    EditText etAge,etName,etAddress;
    RadioButton rMale,rFemale,rOthers;
    RadioGroup rg;
        Button btnSave;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_addstudent, container, false);
        etAge = view.findViewById(R.id.age);
         etName = view.findViewById(R.id.username);
         etAddress = view.findViewById(R.id.address);
         rMale= view.findViewById(R.id.rbMale);
         rFemale= view.findViewById(R.id.rbFemale);
         rOthers= view.findViewById(R.id.rbOthers);
         rg=view.findViewById(R.id.rg);
         btnSave=view.findViewById(R.id.save);
        btnSave.setOnClickListener(this);
        return view;



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                Username = etName.getText().toString().trim();
                Address = etAddress.getText().toString().trim();
                Age = etAge.getText().toString().trim();

                //Toast.makeText(getActivity(), ""+Username+Age+Address, Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(Username)) {
                    etName.setError("Enter Username");
                    return;
                }
                if (TextUtils.isEmpty(Age)) {
                    etAge.setError("Enter Age");
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    etAddress.setError("Enter Address");
                    return;
                }

                if (rMale.isChecked()) {
                    Gender = "Male";
                }
                if (rFemale.isChecked()) {
                    Gender = "Female";
                }
                if (rOthers.isChecked()) {
                    Gender = "Others";
                }

                Student student = new Student(Username, Address, Gender, Integer.parseInt(Age));
                studentList=student.getStudentList();
                studentList.add(student);
                student.setStudentList(studentList);

                Toast.makeText(getActivity(), "Student Addition Successfull: " + Username, Toast.LENGTH_SHORT).show();

                etName.setText("");
                etAge.setText("");
                etAddress.setText("");
                etAge.setText("");
                rFemale.setChecked(false);
                rOthers.setChecked(false);
                rMale.setChecked(false);


        break;
    }

    }
}










