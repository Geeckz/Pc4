package pc.appemp.isilenrollment.repository;
import pc.appemp.isilenrollment.model.Supplier;
public interface SupplierRepository extends BaseRepository<Supplier , Integer> {

    Supplier findByRuc(Integer y);

}
