package date;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateStudent implements IDate<Student>{

    private int currentId = 1;
    private List<Student> studenti = new ArrayList<>();

    public List<Student> findAll(){
        return this.studenti;
    }

    public Student save(Student studentNou){
        this.studenti.add(studentNou);
        studentNou.setId(this.currentId++);
        return studentNou;
    }

    public Student findById(int id){
        Student studentFound = null;
        for(Student s : studenti){
            if(s.getId().equals(id)){
                studentFound = s;
                break;
            }
        }
        return studentFound;
    }

    public void deleteById(int id){
        this.studenti = this.studenti.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
    }

    public void update(Student student){
        Student studentVechi = this.findById(student.getId());
        studentVechi.setEmail(student.getEmail());
        studentVechi.setNume(student.getNume());
        studentVechi.setPrenume(student.getPrenume());
    }

}
