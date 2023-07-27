package br.com.databasejava.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.databasejava.DataBase.Student;
import br.com.databasejava.Repository.StudentRepository;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private final LiveData<List<Student>> listLiveData;

    public StudentViewModel(Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        listLiveData = studentRepository.getAllsStudents();
    }

    public LiveData<List<Student>> getAllStudentsFromVm() {
        return listLiveData;
    }

    public void insertStudent(Student student) {
        studentRepository.insertStudent(student);
    }
}
