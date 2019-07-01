package pc.appemp.isilenrollment.repository;
import pc.appemp.isilenrollment.model.Product;
public interface ProductRepository extends BaseRepository<Product , Integer>{
    Product findBySku(Integer y);
}
