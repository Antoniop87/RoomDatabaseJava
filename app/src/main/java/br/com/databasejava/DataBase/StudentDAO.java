package br.com.databasejava.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void inserir(Student student);

    @Update
    void atualizar(Student student);

    @Query("SELECT * FROM student_table ORDER By name Asc")
    LiveData<List<Student>> getStudent();

    @Query("DELETE FROM student_table")
    void deleteAll();
}
