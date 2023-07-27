package br.com.databasejava.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "student_table")
public class Student {

    @PrimaryKey
    @NonNull
    String name;
    String lastName;
    String address;
    String marks;

    public Student(@NonNull String name, String lastName, String address, String marks) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.marks = marks;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
