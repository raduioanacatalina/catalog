package service;


import date.DateExamen;
import date.DateMaterie;
import model.Examen;
import model.Materie;
import model.Student;

import java.util.*;

public class ServiceCatalog {

    private static ServiceCatalog instance = null;
    private DateExamen dateExamen = new DateExamen();
    private DateMaterie dateMaterie = new DateMaterie();


    public static ServiceCatalog getInstance(){
        if(instance == null){
            instance = new ServiceCatalog();
        }
        return instance;
    }

    private ServiceCatalog(){

    }

    public List<Examen> findAllExamene(){
        return this.dateExamen.findAll();
    }

    public Examen save(Examen examenNou){
        return this.dateExamen.save(examenNou);

    }

    public Examen findExamenById(int id){
        return this.dateExamen.findById(id);
    }

    public void deleteExamenById(int id){
        this.dateExamen.deleteById(id);
    }

    public void update(Examen examen){
        this.dateExamen.update(examen);
    }


    public List<Examen> findAllMaterii(){
        return this.dateExamen.findAll();
    }

    public Materie save(Materie materieNoua){
        return this.dateMaterie.save(materieNoua);

    }

    public Examen findMaterieById(int id){
        return this.dateExamen.findById(id);
    }

    public void deleteMaterieById(int id){
        this.dateExamen.deleteById(id);
    }

    public void update(Materie materie){
        this.dateMaterie.update(materie);
    }

    public Set<Examen> findExameneByStudent(Student student){
        Set<Examen> examene = new HashSet<>();
        List<Examen> allExamene = this.findAllExamene();
        for(Examen ex : allExamene){
            if(ex.getStudent() != null && ex.getStudent().equals(student)){
                examene.add(ex);
            }
        }
        return examene;
    }


    public Map<Student, Set<Examen>> findAllExameneByStudents(){
        Map<Student, Set<Examen>> result = new HashMap<>();
        ServiceStudent serviceStudent = ServiceStudent.getInstance();
        List<Student> studenti = serviceStudent.findAll();
        for(Student student : studenti){
            result.put(student, findExameneByStudent(student));
        }
        return result;
    }

}
