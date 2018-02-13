package com.erik.test.swaggerdemo.resource;

import com.erik.test.swaggerdemo.Bussines.ProductoBO;
import com.erik.test.swaggerdemo.builder.ProductoBuilder;
import com.erik.test.swaggerdemo.dao.ProductRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @PutMapping(path = "Put/{id}", consumes ="application/json",  produces = "application/json")
    public ProductoBO updateWithPut(@PathVariable(value = "id") String Id, @RequestBody @Validated ProductoBO producto){

        ProductoBO nuevoProducto =validateProduct(Id);
            nuevoProducto.setDescripcion(producto.getDescripcion());
            nuevoProducto.setImageLocation(producto.getImageLocation());
            nuevoProducto.setNombre(producto.getNombre());
            nuevoProducto.setPrecio(producto.getPrecio());
            nuevoProducto.setPrecioPuntos(producto.getPrecioPuntos());
            nuevoProducto.setPuntosNuevos(producto.getPuntosNuevos());
            nuevoProducto.setTags(producto.getTags());

        return productRepo.save(nuevoProducto);
    }

    @ApiResponses(
            value= {
                    @ApiResponse(code = 400, message = "Error de validacion"),
                    @ApiResponse(code = 200 , message ="Transaccion exitosa")
            }
    )
    @PatchMapping(path = "patch/{id}", consumes ="application/json",  produces = "application/json")
    public ProductoBO updateWithPatch(@PathVariable(value = "id")String id,  @RequestBody ProductoBO producto){
        ProductoBO nuevoProducto =validateProduct(id);
        nuevoProducto.setNombre(producto.getNombre()!=null?producto.getNombre():nuevoProducto.getNombre());
        nuevoProducto.setDescripcion(producto.getDescripcion()!=null?producto.getDescripcion():nuevoProducto.getDescripcion());
        nuevoProducto.setImageLocation(producto.getImageLocation()!=null?producto.getImageLocation():nuevoProducto.getImageLocation());
        nuevoProducto.setPrecio(producto.getPrecio()>1?producto.getPrecio():nuevoProducto.getPrecio());
        nuevoProducto.setPrecioPuntos(producto.getPrecioPuntos()>1?producto.getPrecioPuntos():nuevoProducto.getPrecioPuntos());
        nuevoProducto.setPuntosNuevos(producto.getPuntosNuevos()>1?producto.getPuntosNuevos():nuevoProducto.getPuntosNuevos());
        nuevoProducto.setTags(producto.getTags()!=null?producto.getTags():nuevoProducto.getTags());
        return productRepo.save(nuevoProducto);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteProduct(@PathVariable(value="id") String id){
        ProductoBO nuevoProducto =validateProduct(id);
        productRepo.delete(id);

    }

    public ProductoBO validateProduct(String Id){
       if(productRepo.exists(Id)){
           return productRepo.findOne(Id);
            } else{
                throw  new RuntimeException("el producto que estas tratando de actualizar no existe, por favor revisa su ID");
             }
       }


    @GetMapping("/todos")
    public Iterable<ProductoBO> buscaProducto() {
        return productRepo.findAll();
    }

    @GetMapping("/cuenta")
    public long total(){
        return productRepo.count();
    }
}