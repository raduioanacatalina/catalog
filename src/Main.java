import date.DateProfesor;
import date.DateStudent;
import model.Student;
import service.ServiceStudent;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        ServiceStudent serviceStudent = ServiceStudent.getInstance();
        Student student = new Student();
        student.setPrenume("George");
        student.setNume("Georgescu");
        student.setId(151);
        student.setEmail("george@gmail.com");

        Student student2 = new Student(232, "Mihailescu", "Mihai", "mihai@gmail.com");


        serviceStudent.save(student);
        serviceStudent.save(student2);

        Student studentModificat = new Student(232, "Mihail", "Mihail", "mihail@yahoo.com");
        serviceStudent.update(studentModificat);

        List<Student> studenti = serviceStudent.findAll();
        System.out.println(studenti);
    }
}
