package com.hackathon.interbank.controller;


import com.hackathon.interbank.dto.DetallePedidoDto;
import com.hackathon.interbank.service.DetallePedidoService;
import com.hackathon.interbank.service.PedidoService;
import com.hackathon.interbank.service.CursoService;
import com.hackathon.interbank.swagger.entity.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/detallepedido", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CursoService cursoService;

    @ApiOperation("Muestra una lista de Detalle de Pedidos")
    @GetMapping("/lista")
    public ResponseEntity<List<DetallePedido>> list(){
        List<DetallePedido> list = detallePedidoService.findAll();
        return new ResponseEntity<List<DetallePedido>>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Long id) {
        DetallePedido detallePedido = detallePedidoService.findById(id);
        return ResponseEntity.ok(detallePedido);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetallePedidoDto> guardarDetallePedido(
            @RequestBody DetallePedidoDto detallePedidoDto
    ) {

        Long pedido = detallePedidoDto.getPedido();
        Long curso = detallePedidoDto.getCurso();
        int cantidad = detallePedidoDto.getCantidad();
        BigDecimal subtotal = detallePedidoDto.getSubtotal();


        Optional<Pedido> pedidoOptional  = pedidoService.findByIds(pedido);
        if (!pedidoOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }

        Optional<Curso> cursoOptional = cursoService.findByIds(curso);
        if (!cursoOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }


        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setPedido(pedidoOptional.get());
        detallePedido.setCurso(cursoOptional.get());
        detallePedido.setCantidad(cantidad);
        detallePedido.setSubtotal(subtotal);


        DetallePedido nuevoDetallePedido = detallePedidoService.save(detallePedido);


        DetallePedidoDto nuevoDetallePedidoDto = new DetallePedidoDto();
        nuevoDetallePedidoDto.setPedido(nuevoDetallePedido.getPedido().getId());
        nuevoDetallePedidoDto.setCurso(nuevoDetallePedido.getCurso().getId());
        nuevoDetallePedidoDto.setCantidad(nuevoDetallePedido.getCantidad());
        nuevoDetallePedidoDto.setSubtotal(nuevoDetallePedido.getSubtotal());


        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetallePedidoDto);
    }
}
