package pc.appemp.isilenrollment.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pc.appemp.isilenrollment.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository



public class JdbcProductRepository implements  ProductRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product product) {
        final String sql = "insert into Product(sku,name,stock,price) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getSku(), product.getName(),product.getStock(),product.getPrice());
    }

    @Override
    public void update(Product product) {
        final String sql = "update Product set name = ?,stock = ? ,price=? where sku = ?";
        jdbcTemplate.update(sql,product.getName(),product.getStock(),product.getPrice(),product.getSku());
    }

    @Override
    public void delete(Integer sku) {
        final String sql = "delete Product where sku = ?";
        jdbcTemplate.update(sql, sku);
    }

    @Override
    public List<Product> findAll() {
        final String sql = "select * from Product";
        return jdbcTemplate.query(sql,
                JdbcProductRepository::ProductRowMapper);
    }

    @Override
    public Product findBySku(Integer sku) {

        final String sql = "select * from Product where sku = ? ";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{sku},
                JdbcProductRepository::ProductRowMapper);
    }


    private static Product ProductRowMapper(ResultSet resultSet, int i) throws SQLException {
        Integer rsSku = resultSet.getInt("sku");
        String rsName = resultSet.getString("name");
        Integer rsStock = resultSet.getInt("stock");
        Double rsPrice = resultSet.getDouble("price");
        return new Product(rsSku,rsName,rsStock,rsPrice);
    }

}
