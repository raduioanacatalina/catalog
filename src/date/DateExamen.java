package date;

import model.Examen;

import java.util.ArrayList;
import java.util.List;

public class DateExamen implements IDate<Examen> {

    private List<Examen> examene = new ArrayList<>();
    private int currentId = 1;
    @Override
    public List<Examen> findAll() {
        return null;
    }

    @Override
    public Examen findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Examen elementNou) {

    }

    @Override
    public Examen save(Examen elementNou) {
        this.examene.add(elementNou);
        elementNou.setId(this.currentId++);
        return elementNou;
    }
}
