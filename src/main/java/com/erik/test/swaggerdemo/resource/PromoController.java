package com.erik.test.swaggerdemo.resource;


import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.Bussines.PromoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import com.erik.test.swaggerdemo.builder.PromoBuilder;
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
@RequestMapping("/rest/Promo")
@Api(value = "Promo Resource",  description = "CRUD Operation for  promos")
public class PromoController {

    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 100, message = "100 us the message"),
                    @ApiResponse(code = 200 , message ="successful Hello World  ")
            }
    )
    @GetMapping(value= "/predefinido")
    public PromoBO getPromo(){

        ProductoBO producto1 = new ProductoBuilder()
                .setDescripcion("producto1")
                .setImageLocation("www.myPage.com")
                .setNombre("producto1")
                .setPrecio(300)
                .setPrecioPuntos(3000)
                .setPuntosNuevos(3)
                .setTags( new HashSet<String>(Arrays.asList("limpio", "nuevo")))
                .build();

        ProductoBO producto2 = new ProductoBuilder()
                .setDescripcion("producto2")
                .setImageLocation("www.myPage.com")
                .setNombre("producto2")
                .setPrecio(300)
                .setPrecioPuntos(3000)
                .setPuntosNuevos(3)
                .setTags( new HashSet<String>(Arrays.asList("limpio", "nuevo")))
                .build();


        return new PromoBuilder()
                .setDescripcion("claro que si ")
                .setPrecio(300)
                .setPrecioPuntos(300000)
                .setProductos(new HashSet<>(Arrays.asList(producto1,producto2 )))
                .setPromoName("Packetaxo")
                .setTags(new HashSet<>(Arrays.asList("all you need",  "is love")))
                .build();
    }
}