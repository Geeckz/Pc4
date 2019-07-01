package pc.appemp.isilenrollment.repository;
import java.util.List;
public interface BaseRepository<X,Y> {
    void create(X x);
    void update(X x);
    void delete(Y y);
    List<X> findAll();
}


