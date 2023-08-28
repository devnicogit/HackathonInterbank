package com.hackathon.interbank.security.enums.controller;

import com.hackathon.interbank.security.entity.Rol;
import com.hackathon.interbank.security.entity.dto.JwtDto;
import com.hackathon.interbank.security.entity.dto.LoginUsuario;
import com.hackathon.interbank.security.entity.dto.NuevoUsuario;
import com.hackathon.interbank.security.enums.RolNombre;
import com.hackathon.interbank.security.repository.RolRepository;
import com.hackathon.interbank.security.service.UsuarioService;
import com.hackathon.interbank.security.service.RolService;
import com.hackathon.interbank.dto.Mensaje;
import com.hackathon.interbank.security.entity.Usuario;
import com.hackathon.interbank.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    /*@Autowired
    UsuarioService usuarioService;*/

    @Autowired
    RolRepository rolRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);


        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        // asignar roles
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        for (Rol rol : nuevoUsuario.getRoles()) {
            if (rol.getRolNombre().equals(RolNombre.ROLE_ADMIN)) {
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            }
        }

        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> listarRoles() {
        List<Rol> roles = rolService.findAll();
        return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }

    @GetMapping("/usuarios/{nombreUsuario}")
    public ResponseEntity<Usuario> getUsuarioByEmaiil(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.getByEmail(email);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
