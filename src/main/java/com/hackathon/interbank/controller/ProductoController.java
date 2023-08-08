package com.hackathon.interbank.controller;


import com.hackathon.interbank.dto.DetallePedidoDto;
import com.hackathon.interbank.dto.ProductoDto;
import com.hackathon.interbank.service.CategoriaService;
import com.hackathon.interbank.service.ProductoService;
import com.hackathon.interbank.swagger.entity.Categoria;
import com.hackathon.interbank.swagger.entity.DetallePedido;
import com.hackathon.interbank.swagger.entity.Pedido;
import com.hackathon.interbank.swagger.entity.Producto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation("Muestra una lista de Productos")
    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){
        List<Producto> list = productoService.findAll();
        return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        return ResponseEntity.ok(producto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoDto> guardarProducto(
            @RequestBody ProductoDto productoDto
    ) {
        String nombre = productoDto.getNombre();
        String descripcion = productoDto.getDescripcion();
        Long categoria = productoDto.getCategoria();
        Boolean igv = productoDto.getIgv();
        String imagen = productoDto.getImagen();
        BigDecimal precio = productoDto.getPrecio();
        BigDecimal descuento = productoDto.getDescuento();


        Optional<Categoria> categoriaOptional  = categoriaService.findByIds(categoria);
        if (!categoriaOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoriaOptional.get());
        producto.setIgv(igv);
        producto.setImagen(imagen);
        producto.setPrecio(precio);
        producto.setDescuento(descuento);


        Producto nuevoProducto = productoService.save(producto);


        ProductoDto nuevoProductoDto = new ProductoDto();
        nuevoProductoDto.setNombre(nuevoProducto.getNombre());
        nuevoProductoDto.setDescripcion(nuevoProducto.getDescripcion());
        nuevoProductoDto.setCategoria(nuevoProducto.getCategoria().getId());
        nuevoProductoDto.setIgv(nuevoProducto.getIgv());
        nuevoProductoDto.setImagen(nuevoProducto.getImagen());
        nuevoProductoDto.setPrecio(nuevoProducto.getPrecio());
        nuevoProductoDto.setDescuento(nuevoProducto.getDescuento());


        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductoDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @Valid @RequestBody Producto producto) {


        Categoria categoria = categoriaService.findById(producto.getCategoria().getId());


        // Verificar si los objetos son nulos antes de acceder a sus propiedades
        if (categoria == null) {
            // Manejar el caso en que categoria sea nulo
            return ResponseEntity.badRequest().build();
        }


        producto.setCategoria(categoria);



        Producto updatedProducto = productoService.update(id, producto);
        return ResponseEntity.ok(updatedProducto);
    }


}
