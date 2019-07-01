package pc.appemp.isilenrollment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pc.appemp.isilenrollment.model.Product;
import pc.appemp.isilenrollment.model.Supplier;
import pc.appemp.isilenrollment.repository.JdbcProductRepository;
import pc.appemp.isilenrollment.repository.JdbcSupplierRepository;
import java.util.List;

@Slf4j
@SpringBootApplication
public class IsilEnrollmentApplication implements CommandLineRunner {
	@Autowired
	private JdbcSupplierRepository jdbcSupplierRepository;
	@Autowired
	private JdbcProductRepository jdbcProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(IsilEnrollmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		jdbcProductRepository
				.create(new Product(12345,"jamon",25,25.00));
		jdbcSupplierRepository
				.create(new Supplier(111111,"provjamon","provjamon@jamon.com","987567354"));


		Product product2 = jdbcProductRepository.findBySku(12345);
		log.info("Product={}",product2);
		product2.setName("jamoncito");
		jdbcProductRepository.update(product2);
		List<Product> productList = jdbcProductRepository.findAll();
		List<Supplier> supplierList = jdbcSupplierRepository.findAll();

		log.info("productList =>{}",productList);
		log.info("supplierList =>{}",supplierList);
		log.info("Terminate!");

	}

}
