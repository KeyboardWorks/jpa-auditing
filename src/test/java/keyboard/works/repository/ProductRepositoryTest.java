package keyboard.works.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import keyboard.works.entity.Product;

@SpringBootTest
@Sql(scripts = "/sql/user.sql")
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void createProductTest() {
		Product product = new Product();
		product.setCode("Product Code");
		product.setName("Product Name");
		product.setPrice(new BigDecimal(100));
		
		productRepository.save(product);
		
		System.out.println("Created By : " + product.getCreatedBy());
		System.out.println("Created Date : " + product.getCreatedDateTime());
		System.out.println("Updated By : " + product.getLastModifiedBy());
		System.out.println("Updated Date : " + product.getLastModifiedDateTime());
	}
	
}
