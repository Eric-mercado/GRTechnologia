package com.erik.test.swaggerdemo;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import com.erik.test.swaggerdemo.dao.MongoDao;
import com.mongodb.DB;
import com.mongodb.DBObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SwaggerDemoApplication {

	public static void main(String[] args) {

		SwaggerDemoApplication swaggerDemoApplication = new SwaggerDemoApplication();
		SpringApplication.run(SwaggerDemoApplication.class, args);

		DBObject doc = createDBProduct(swaggerDemoApplication.createProductoBO());

		DB mongoDB =
	}

	private static DBObject createDBProduct(ProductoBO producto){


	}

	public ProductoBO createProductoBO (){
		return  new ProductoBuilder()
				.setDescripcion("producto1")
				.setImageLocation("www.myPage.com")
				.setNombre("producto1")
				.setPrecio(300)
				.setPrecioPuntos(3000)
				.setPuntosNuevos(3)
				.setTags( new HashSet<String>(Arrays.asList("limpio", "nuevo")))
				.build();
	}
}
