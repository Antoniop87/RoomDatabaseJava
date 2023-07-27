package br.com.databasejava.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    public abstract StudentDAO studentDAO();

    private static volatile DataBase dataBase;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static DataBase getDataBase(final Context context){
        if (dataBase == null){
            synchronized (DataBase.class){
                if (dataBase == null){
                    dataBase = Room.databaseBuilder(context.getApplicationContext(),DataBase.class,"database").build();
                }
            }
        }
        return dataBase;
    }
}
