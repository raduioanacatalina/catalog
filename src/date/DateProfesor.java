package date;

import model.Profesor;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateProfesor implements IDate<Profesor>{
    private List<Profesor> profesori = new ArrayList<>();

    private int currentId = 1;

    @Override
    public List<Profesor> findAll() {
       return this.profesori;
    }

    @Override
    public Profesor findById(int id) {
        Profesor profesorFound = null;
        for(Profesor profesor : this.profesori){
            if(profesor.getId().equals(id)){
                profesorFound = profesor;
                break;
            }
        }
        return profesorFound;
    }

    @Override
    public void deleteById(int id) {
        this.profesori = this.profesori.stream().filter(x -> x.getId() != id).collect(Collectors.toList());

    }

    @Override
    public void update(Profesor elementNou) {
        Profesor profesorVechi = this.findById(elementNou.getId());
        profesorVechi.setEmail(elementNou.getEmail());
        profesorVechi.setNume(elementNou.getNume());
        profesorVechi.setPrenume(elementNou.getPrenume());
    }

    @Override
    public Profesor save(Profesor elementNou) {
        this.profesori.add(elementNou);
        elementNou.setId(this.currentId++);
        return elementNou;
    }
}
