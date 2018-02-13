package com.erik.test.swaggerdemo.dao;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo  extends MongoRepository<ProductoBO, String> {


}
