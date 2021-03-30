package date;

import model.Examen;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateExamen implements IDate<Examen> {

    private List<Examen> examene = new ArrayList<>();
    private int currentId = 1;
    @Override
    public List<Examen> findAll() {
        return this.examene;
    }


    @Override
    public Examen findById(int id) {
        Examen examenFound = null;
        for(Examen e : examene){
            if(e.getId().equals(id)){
                examenFound = e;
                break;
            }
        }
        return examenFound;
    }

    @Override
    public void deleteById(int id) {
        this.examene = this.examene.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void update(Examen examen) {
     Examen examenVechi = this.findById(examen.getId());
     examenVechi.setDataExament(examen.getDataExament());
     examenVechi.setMaterie(examen.getMaterie());
     examenVechi.setNota(examen.getNota());
     examenVechi.setStudent(examen.getStudent());
    }

    @Override
    public Examen save(Examen elementNou) {
        this.examene.add(elementNou);
        elementNou.setId(this.currentId++);
        return elementNou;
    }
}
