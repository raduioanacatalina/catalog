package date;

import java.util.List;

public interface IDate<T> {

    public List<T> findAll();
    public T findById(int id);
    public void deleteById(int id);
    public void update(T elementNou);
    public T save(T elementNou);

}
