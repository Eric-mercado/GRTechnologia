package com.erik.test.swaggerdemo;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import com.erik.test.swaggerdemo.dao.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SwaggerDemoApplication implements CommandLineRunner {

	@Autowired
	ProductRepo productRepo;

	public static void main(String[] args) {

		SpringApplication.run(SwaggerDemoApplication.class, args);

		//DBObject doc = createDBProduct(swaggerDemoApplication.createProductoBO());

	}


	public ProductoBO createProductoBO (String id){
		return  new ProductoBuilder()
				.setiD("producto" + id)
				.setDescripcion("producto" + id)
				.setImageLocation("www.myPage.com")
				.setNombre("producto1")
				.setPrecio(300)
				.setPrecioPuntos(3000)
				.setPuntosNuevos(3)
				.setTags( new HashSet<String>(Arrays.asList("limpio", "nuevo")))
				.build();
	}

	@Override
	public void run(String... strings) throws Exception {
		productRepo.deleteAll();

		// save a couple of customers
		productRepo.save(createProductoBO("1"));
		productRepo.save(createProductoBO("2"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (ProductoBO producto : productRepo.findAll()) {
			System.out.println(producto);
		}
		System.out.println();
	}
}
