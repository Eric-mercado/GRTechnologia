package com.erik.test.swaggerdemo.resource;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import com.erik.test.swaggerdemo.dao.ProductRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/rest/Producto")
@Api(value = "Producto Resource",  description = "CRUD Operation for  productos")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @ApiOperation(value = "Returns a specific product")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 100, message = "100 us the message"),
                    @ApiResponse(code = 200 , message ="successful responce")
            }
    )
    @GetMapping("/{id}")
    public ProductoBO getProducto(@PathVariable final String id){

       ProductoBO producto =  productRepo.findOne(id);

       return producto;
    }

    @ApiOperation(value = "Creates a new Object on demand")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 100, message = "100 us the message"),
                    @ApiResponse(code = 201 , message ="Producto Creado"),
                    @ApiResponse(code = 500 , message ="Error Interno"),
            }
    )
    @PostMapping(path = "create", consumes ="application/json",  produces = "application/json")
    public void postProducto(@RequestBody ProductoBO producto){

        if(!productRepo.exists(producto.getId())) {
            productRepo.save(producto);
        } else{
            System.out.println("Product" + producto.getId() + "Ya existia en base de datos");
                throw  new RuntimeException("Id  Duplicado Considere uno nuevo");
        }
        System.out.println("Producto : "+ producto.getNombre() + " Guardado");

    }

    public Iterable<ProductoBO> buscaProducto() {
        return productRepo.findAll();
    }

    public long total(){
        return productRepo.count();
    }
}