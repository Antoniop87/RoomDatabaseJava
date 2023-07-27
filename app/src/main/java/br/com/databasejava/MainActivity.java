package br.com.databasejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.databasejava.DataBase.Student;
import br.com.databasejava.ViewModel.StudentViewModel;
import br.com.databasejava.ui.StudentListAdapter;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addStudent;
    private RecyclerView recyclerView;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AdicionarStudent.class);
                startActivity(it);
            }
        });

        studentViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication(
        )).create(StudentViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentViewModel.getAllStudentsFromVm().observe(this,
                students -> {
                    if (students != null && !students.isEmpty()){
                        StudentListAdapter adapter = new StudentListAdapter((ArrayList<Student>) students);
                        recyclerView.setAdapter(adapter);
                    }
        });

    }

    private void findViews() {
        addStudent = findViewById(R.id.add_student);
        recyclerView = findViewById(R.id.recyclerView);
    }
}