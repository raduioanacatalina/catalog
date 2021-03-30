package date;

import model.Materie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateMaterie implements IDate<Materie>{

    private List<Materie> materii = new ArrayList<>();

    private int currentId = 1;

    @Override
    public List<Materie> findAll() {
        return this.materii;
    }
    public Materie save(Materie materieNoua){
        this.materii.add(materieNoua);
        materieNoua.setId(currentId++);
        return materieNoua;
    }

    @Override
    public Materie findById(int id) {
        Materie materieFound = null;
        for(Materie m : materii){
            if(m.getId().equals(id)){
                materieFound = m;
                break;
            }
        }
        return materieFound;
    }

    @Override
    public void deleteById(int id) {
        this.materii = this.materii.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void update(Materie materie) {
        Materie materieVeche = this.findById(materie.getId());
        materieVeche.setDenumire(materie.getDenumire());
        materieVeche.setProfesor(materie.getProfesor());
    }


}
