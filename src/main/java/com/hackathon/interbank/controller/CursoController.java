package com.hackathon.interbank.controller;


import com.hackathon.interbank.dto.CursoDto;
import com.hackathon.interbank.service.CategoriaService;
import com.hackathon.interbank.service.CursoService;
import com.hackathon.interbank.swagger.entity.Categoria;
import com.hackathon.interbank.swagger.entity.Curso;
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
@RequestMapping(value = "/curso", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation("Muestra una lista de Productos")
    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> list(){
        List<Curso> list = cursoService.findAll();
        return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        return ResponseEntity.ok(curso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CursoDto> guardarCurso(
            @RequestBody CursoDto cursoDto
    ) {
        String nombre = cursoDto.getNombre();
        String descripcion = cursoDto.getDescripcion();
        Long categoria = cursoDto.getCategoria();
        String imagen = cursoDto.getImagen();
        BigDecimal precio = cursoDto.getPrecio();


        Optional<Categoria> categoriaOptional  = categoriaService.findByIds(categoria);
        if (!categoriaOptional.isPresent()) {

            return ResponseEntity.notFound().build();

        }

        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setCategoria(categoriaOptional.get());
        curso.setImagen(imagen);
        curso.setPrecio(precio);


        Curso nuevoCurso = cursoService.save(curso);


        CursoDto nuevoCursoDto = new CursoDto();
        nuevoCursoDto.setNombre(nuevoCurso.getNombre());
        nuevoCursoDto.setDescripcion(nuevoCurso.getDescripcion());
        nuevoCursoDto.setCategoria(nuevoCurso.getCategoria().getId());
        nuevoCursoDto.setImagen(nuevoCurso.getImagen());
        nuevoCursoDto.setPrecio(nuevoCurso.getPrecio());


        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCursoDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @Valid @RequestBody Curso curso) {


        Categoria categoria = categoriaService.findById(curso.getCategoria().getId());


        // Verificar si los objetos son nulos antes de acceder a sus propiedades
        if (categoria == null) {
            // Manejar el caso en que categoria sea nulo
            return ResponseEntity.badRequest().build();
        }


        curso.setCategoria(categoria);



        Curso updatedCurso = cursoService.update(id, curso);
        return ResponseEntity.ok(updatedCurso);
    }


}
