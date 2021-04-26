package service;

import model.Materie;
import model.Profesor;
import model.Student;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoService {

    private static DaoService instance;
    private ServiceProfesor serviceProfesor = ServiceProfesor.getInstance();
    private ServiceCatalog serviceCatalog = ServiceCatalog.getInstance();
    private ServiceStudent serviceStudent = ServiceStudent.getInstance();

    private  URL urlStudents = getClass().getClassLoader().getResource("studenti.csv");
    private  URL urlTeachers = getClass().getClassLoader().getResource("profesori.csv");
    private  URL urlMaterii = getClass().getClassLoader().getResource("materii.csv");
    private Path PATH_STUDENTS = null;
    private Path PATH_PROFESORI= null;
    private Path PATH_MATERIE = null;

    public static DaoService getInstance(){
        if(instance == null){
            instance = new DaoService();
            try {
                instance.PATH_STUDENTS = Paths.get(instance.urlStudents.toURI());
                instance.PATH_PROFESORI = Paths.get(instance.urlTeachers.toURI());
                instance.PATH_MATERIE = Paths.get(instance.urlMaterii.toURI());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }
    private DaoService(){

    }

    public void loadProfesori() throws IOException{
        AuditService.getInstance().logMessage("Load profesori", new Date().toString());

        List<Profesor> profesori = new ArrayList<>();
        List<String> lines = Files.readAllLines(PATH_PROFESORI);
        for(String line : lines){
            // 1,Georgescu,George,george@gmail.com
            Profesor prof = new Profesor();
            String elements[] = line.split(",");
            prof.setNume(elements[1]);
            prof.setPrenume(elements[2]);
            prof.setEmail(elements[3]);
            prof.setId(Integer.valueOf(elements[0]));
            profesori.add(prof);
        }
        for(Profesor p : profesori){
            serviceProfesor.save(p);
        }
    }

    public void loadStudenti() throws IOException {
        AuditService.getInstance().logMessage( "Load studenti", new Date().toString());

        List<Student> studenti = new ArrayList<>();
        List<String> lines = Files.readAllLines(PATH_STUDENTS);
        for(String line : lines){
            // 1,Georgescu,George,george@gmail.com
            Student s = new Student();
            String elements[] = line.split(",");
            s.setNume(elements[1]);
            s.setPrenume(elements[2]);
            s.setEmail(elements[3]);
            s.setId(Integer.valueOf(elements[0]));
            studenti.add(s);
        }
        for(Student s : studenti){
            serviceStudent.save(s);
        }
    }

    public void loadMaterii() throws IOException{
        AuditService.getInstance().logMessage("Load materii", new Date().toString());

        List<Materie> materii = new ArrayList<>();
        List<String> lines = Files.readAllLines(PATH_MATERIE);
        for(String line : lines){
            // 1,OOP,3
            Materie materie = new Materie();
            String elements[] = line.split(",");

            materie.setId(Integer.valueOf(elements[0]));
            materie.setDenumire(elements[1]);
            int idProfesor = Integer.valueOf(elements[2]);
            Profesor profesorAsociat = null;
            profesorAsociat = serviceProfesor.findById(idProfesor);
            materie.setProfesor(profesorAsociat);


            materii.add(materie);
        }
        for(Materie materie : materii){
            serviceCatalog.save(materie);
        }
    }



}
