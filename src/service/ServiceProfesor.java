package service;


import date.DateProfesor;
import model.Profesor;
import model.Student;

import java.util.List;

public class ServiceProfesor {

    private static ServiceProfesor instance = null;
    private DateProfesor dateProfesor = new DateProfesor();

    public static ServiceProfesor getInstance(){
        if(instance == null){
            instance = new ServiceProfesor();
        }
        return instance;
    }

    private ServiceProfesor(){

    }

    public List<Profesor> findAll(){
        return this.dateProfesor.findAll();
    }

    public Profesor save(Profesor profesorNou){
        return this.dateProfesor.save(profesorNou);
    }

    public Profesor findById(int id){
        return this.dateProfesor.findById(id);
    }

    public void deleteById(int id){
        this.dateProfesor.deleteById(id);
    }

    public void update(Profesor profesor){
        this.dateProfesor.update(profesor);
    }



}
