package pc.appemp.isilenrollment.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pc.appemp.isilenrollment.model.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class JdbcSupplierRepository implements SupplierRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Supplier supplier) {
        final String sql = "insert into Supplier(ruc,name,contactEmail,contactMobilePhone) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, supplier.getRuc(),supplier.getName(),supplier.getContactEmail(),supplier.getContactMobilePhone());
    }

    @Override
    public void update(Supplier supplier) {
        final String sql = "update Supplier set name = ?,contactEmail = ?, contactMobilePhone where ruc = ?";
        jdbcTemplate.update(sql,supplier.getName(),supplier.getContactEmail(),supplier.getContactMobilePhone(),supplier.getRuc());
    }

    @Override
    public void delete(Integer ruc) {
        final String sql = "delete Supplier where ruc = ?";
        jdbcTemplate.update(sql, ruc);
    }

    @Override
    public List<Supplier> findAll() {
        final String sql = "select * from Supplier";
        return jdbcTemplate.query(sql,
                JdbcSupplierRepository::SupplierRowMapper);
    }

    @Override
    public Supplier findByRuc(Integer ruc) {

        final String sql = "select * from Supplier where ruc = ? ";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{ruc},
                JdbcSupplierRepository::SupplierRowMapper);
    }


    private static Supplier SupplierRowMapper(ResultSet resultSet, int i) throws SQLException {
        Integer rsRuc = resultSet.getInt("ruc");
        String rsName = resultSet.getString("name");
        String rsContactEmail = resultSet.getString("contactEmail");
        String rsContactMobilePhone = resultSet.getString("contactMobilePhone");
        return new Supplier(rsRuc,rsName,rsContactEmail,rsContactMobilePhone);
    }




}
