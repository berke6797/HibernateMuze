package Repository;

import java.util.List;

public interface ICrud <T> {
    void save(T t);
     List<T> getAll();
    void update(T t);
    void delete (int id);
}
