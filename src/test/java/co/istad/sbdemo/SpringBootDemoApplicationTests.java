package co.istad.sbdemo;

import co.istad.sbdemo.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Test
	void testLombook() {
		Item item = new Item();
		item.setId(1);
		item.setName("Sumsung Galaxy Note 10+");
		item.setPrice(2500);
		item.setQty(10);
		System.out.println("Product Name: " + item.getName());
		System.out.println("Price: " + item.getPrice());
		System.out.println("Quantity: " + item.getQty());
	}

}
