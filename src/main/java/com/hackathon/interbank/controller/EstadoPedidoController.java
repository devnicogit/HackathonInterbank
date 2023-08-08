package com.hackathon.interbank.controller;




import com.hackathon.interbank.service.EstadoPedidoService;
import com.hackathon.interbank.swagger.entity.EstadoPedido;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estadopedido")
@CrossOrigin(origins = "*")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @ApiOperation("Muestra una lista de estados")
    @GetMapping("/lista")
    public ResponseEntity<List<EstadoPedido>> list(){
        List<EstadoPedido> list = estadoPedidoService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedido> getEstadoPedidoById(@PathVariable Long id) {
        EstadoPedido estadoPedido = estadoPedidoService.findById(id);
        return ResponseEntity.ok(estadoPedido);
    }

    @PostMapping("/create")
    public ResponseEntity<EstadoPedido> createEstadoPedido(@Valid @RequestBody EstadoPedido estadoPedido) {
        EstadoPedido createdEstadoPedido = estadoPedidoService.save(estadoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoPedido);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EstadoPedido> updateEstadoPedido(@PathVariable Long id, @Valid @RequestBody EstadoPedido estadoPedido) {
        EstadoPedido updatedEstadoPedido = estadoPedidoService.update(id,estadoPedido);
        return ResponseEntity.ok(updatedEstadoPedido);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEstadoPedido(@PathVariable Long id) {
        estadoPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
