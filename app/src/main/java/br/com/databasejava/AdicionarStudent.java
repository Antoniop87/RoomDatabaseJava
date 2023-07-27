package br.com.databasejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.databasejava.DataBase.Student;
import br.com.databasejava.ViewModel.StudentViewModel;

public class AdicionarStudent extends AppCompatActivity {

    private EditText editStudentName;
    private EditText editStudentLastName;
    private EditText editStudentAddress;
    private EditText editStudentMarks;
    private Button buttonSave;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_student);

        findViewsAddStudent();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(editStudentName.getText().toString(),
                        editStudentLastName.getText().toString(),
                        editStudentAddress.getText().toString().toString(),
                        editStudentMarks.getText().toString());
                studentViewModel.insertStudent(student);
            }
        });
        studentViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication(
        )).create(StudentViewModel.class);
    }

    private void findViewsAddStudent() {

        editStudentName = findViewById(R.id.editStudentName);
        editStudentLastName = findViewById(R.id.editStudentLastName);
        editStudentAddress = findViewById(R.id.editStudentAddress);
        editStudentMarks = findViewById(R.id.editStudentMarks);
        buttonSave = findViewById(R.id.buttonSave);

    }
}