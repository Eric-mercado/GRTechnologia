package com.erik.test.swaggerdemo.resource;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/rest/Producto")
@Api(value = "Producto Resource",  description = "CRUD Operation for  productos")
public class ProductController {

    @ApiOperation(value = "A given product")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 100, message = "100 us the message"),
                    @ApiResponse(code = 200 , message ="successful responce")
            }
    )
    @GetMapping(value= "/predefinido")
    public ProductoBO getProducto(){

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