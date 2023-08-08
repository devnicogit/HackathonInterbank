package com.hackathon.interbank.controller;



import com.hackathon.interbank.service.CategoriaService;
import com.hackathon.interbank.swagger.entity.Categoria;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation("Muestra una lista de categorías")
    @GetMapping("/lista")
    public ResponseEntity<List<Categoria>> list(){
        List<Categoria> list = categoriaService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/create")
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria createdCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        Categoria updatedCategoria = categoriaService.update(id,categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
