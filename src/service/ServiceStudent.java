package service;


import date.DateStudent;
import model.Student;

import java.util.List;

public class ServiceStudent {

    private static ServiceStudent instance = null;
    private DateStudent dateStudent = new DateStudent();

    public static ServiceStudent getInstance(){
        if(instance == null){
            instance = new ServiceStudent();
        }
        return instance;
    }

    private ServiceStudent(){

    }

    public List<Student> findAll(){
        return this.dateStudent.findAll();
    }

    public Student save(Student studentNou){
        return this.dateStudent.save(studentNou);
    }

    public Student findById(int id){
        return this.dateStudent.findById(id);
    }

    public void deleteById(int id){
        this.dateStudent.deleteById(id);
    }

    public void update(Student student){
        this.dateStudent.update(student);
    }



}
