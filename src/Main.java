import date.DateProfesor;
import date.DateStudent;
import model.Student;
import service.DaoService;
import service.ServiceStudent;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        DaoService daoService = DaoService.getInstance();
        daoService.loadStudenti();
        daoService.loadProfesori();
        daoService.loadMaterii();

        ServiceStudent serviceStudent = ServiceStudent.getInstance();

        for(Student s : serviceStudent.findAll()){
            System.out.println("Student: " + s);
        }

    }


    public static void mainOld(String[] args) {

        ServiceStudent serviceStudent = ServiceStudent.getInstance();
        Student student = new Student();
        student.setPrenume("George");
        student.setNume("Georgescu");
        student.setId(151);
        student.setEmail("george@gmail.com");

        Student student2 = new Student(232, "Mihailescu", "Mihai", "mihai@gmail.com");


        serviceStudent.save(student);
        serviceStudent.save(student2);



        Student studentModificat = new Student(2, "Mihail", "Mihail", "mihail@yahoo.com");
        serviceStudent.update(studentModificat);

        List<Student> studenti = serviceStudent.findAll();
        System.out.println(studenti);
    }
}
