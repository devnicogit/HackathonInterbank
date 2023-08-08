package com.hackathon.interbank.controller;


import com.hackathon.interbank.service.CuponService;
import com.hackathon.interbank.swagger.entity.Categoria;
import com.hackathon.interbank.swagger.entity.Cupon;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cupon")
@CrossOrigin(origins = "*")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @ApiOperation("Muestra una lista de cupones")
    @GetMapping("/lista")
    public ResponseEntity<List<Cupon>> list(){
        List<Cupon> list = cuponService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cupon> getCuponById(@PathVariable Long id) {
        Cupon cupon = cuponService.findById(id);
        return ResponseEntity.ok(cupon);
    }

    @PostMapping("/create")
    public ResponseEntity<Cupon> createCupon(@Valid @RequestBody Cupon cupon) {
        Cupon createdCupon = cuponService.save(cupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCupon);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cupon> updateCupon(@PathVariable Long id, @Valid @RequestBody Cupon cupon) {
        Cupon updatedCupon = cuponService.update(id,cupon);
        return ResponseEntity.ok(updatedCupon);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCupon(@PathVariable Long id) {
        cuponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
