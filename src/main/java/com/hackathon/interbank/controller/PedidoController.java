package com.hackathon.interbank.controller;

import com.hackathon.interbank.dto.PedidoDto;
import com.hackathon.interbank.security.entity.Usuario;
import com.hackathon.interbank.security.service.UsuarioService;
import com.hackathon.interbank.service.ClientesService;
import com.hackathon.interbank.service.CuponService;
import com.hackathon.interbank.service.EstadoPedidoService;
import com.hackathon.interbank.service.PedidoService;
import com.hackathon.interbank.swagger.entity.Clientes;
import com.hackathon.interbank.swagger.entity.Cupon;
import com.hackathon.interbank.swagger.entity.EstadoPedido;
import com.hackathon.interbank.swagger.entity.Pedido;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClientesService clienteService;

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @Autowired
    private CuponService cuponService;

    @ApiOperation("Muestra una lista de Pedidos")
    @GetMapping("/lista")
    public ResponseEntity<List<Pedido>> list(){
        List<Pedido> list = pedidoService.findAll();
        return new ResponseEntity<List<Pedido>>(list, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok(pedido);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoDto> guardarPedido(
            @RequestBody PedidoDto pedidoDto
    ) {

        Date fecha = pedidoDto.getFecha();
        BigDecimal subtotal = pedidoDto.getSubtotal();
        BigDecimal igv = pedidoDto.getIgv();
        BigDecimal total = pedidoDto.getTotal();
        Long cliente = pedidoDto.getCliente();
        Long estado = pedidoDto.getEstadoPedido();
        Long cupon = pedidoDto.getCupon();


        Optional<Clientes> clienteOptional  = clienteService.findByIds(cliente);
        if (!clienteOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }

        Optional<EstadoPedido> estadoPedidoOptional = estadoPedidoService.findByIds(estado);
        if (!estadoPedidoOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }

        Optional<Cupon> cuponOptional = cuponService.findByIds(cupon);
        if (!cuponOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = new Pedido();
        pedido.setFecha(fecha);
        pedido.setSubtotal(subtotal);
        pedido.setIgv(igv);
        pedido.setTotal(total);
        pedido.setCliente(clienteOptional.get());
        pedido.setEstado(estadoPedidoOptional.get());
        pedido.setCupon(cuponOptional.get());


        Pedido nuevoPedido = pedidoService.save(pedido);


        //System.out.println("Valor de detallesCliente: " + clienteOptional.get().getNombreUsuario());


        PedidoDto nuevoPedidoDto = new PedidoDto();
        nuevoPedidoDto.setFecha(nuevoPedido.getFecha());
        nuevoPedidoDto.setSubtotal(nuevoPedido.getSubtotal());
        nuevoPedidoDto.setIgv(nuevoPedido.getIgv());
        nuevoPedidoDto.setTotal(nuevoPedido.getTotal());
        nuevoPedidoDto.setCliente(nuevoPedido.getCliente().getClienteID());
        nuevoPedidoDto.setEstadoPedido(nuevoPedido.getEstado().getId());
        nuevoPedidoDto.setCupon(nuevoPedido.getCupon().getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedidoDto);
    }




}
