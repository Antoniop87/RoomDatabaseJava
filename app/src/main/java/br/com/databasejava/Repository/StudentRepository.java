package br.com.databasejava.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.databasejava.DataBase.DataBase;
import br.com.databasejava.DataBase.Student;
import br.com.databasejava.DataBase.StudentDAO;

public class StudentRepository {

    DataBase dataBase;
    StudentDAO studentDAO;
    private LiveData<List<Student>> listStudents;

    public StudentRepository(Application application){
        dataBase = DataBase.getDataBase(application);
        studentDAO = dataBase.studentDAO();
        listStudents = studentDAO.getStudent();
    }

    public void insertStudent(Student student){
        DataBase.databaseWriteExecutor.execute(() ->
                studentDAO.inserir(student));
    }

    public LiveData<List<Student>> getAllsStudents(){
        return listStudents;
    }

}
