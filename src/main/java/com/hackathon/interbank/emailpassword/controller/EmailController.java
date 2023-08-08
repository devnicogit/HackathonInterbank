package com.hackathon.interbank.emailpassword.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.interbank.emailpassword.dto.ChangePasswordDTO;
import com.hackathon.interbank.emailpassword.service.EmailService;
import com.hackathon.interbank.dto.Mensaje;
import com.hackathon.interbank.emailpassword.dto.EmailValuesDTO;
import com.hackathon.interbank.security.entity.Cliente;
import com.hackathon.interbank.security.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    ClienteService clienteService;

    /*@Autowired
    UsuarioService usuarioService;*/

    @Autowired
    ClienteService asesorService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    private static final String subject = "Cambio de Contraseña";
    private static final String subject2 = "Migración de Plan";

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        Optional<Cliente> clienteOpt = clienteService.getByNombreUsuarioOrEmail(dto.getMailTo());
        if(!clienteOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún Cliente con esas credenciales"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(cliente.getEmail());
        dto.setSubject(subject);
        dto.setUserName(cliente.getNombreUsuario());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        cliente.setTokenPassword(tokenPassword);
        clienteService.save(cliente);
        emailService.sendEmail(dto);
        return new ResponseEntity(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
    }

    /*@PostMapping("/send-email-pdf")
    public ResponseEntity<?> sendEmailTemplate2(@RequestPart("pdfFile") MultipartFile pdfFile,
                                                @RequestPart("emailValuesDto") String emailValuesDtoJson) throws JsonProcessingException {

        // Parsear el objeto EmailValuesDTO desde el JSON
        EmailValuesDTO dto = new ObjectMapper().readValue(emailValuesDtoJson, EmailValuesDTO.class);
        Optional<Cliente> clienteOpt = clienteService.getByEmail(dto.getMailTo());
        if(!clienteOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún Cliente con ese email"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(cliente.getEmail()); // Reemplaza el email del asesor por el email del cliente
        dto.setSubject(subject2);
        dto.setUserName(cliente.getNombre());
        try {
            System.out.println("Email enviado a: " + dto.getMailTo());
            System.out.println(Arrays.toString(dto.getPdfBytes()));
            dto.setPdfBytes(pdfFile.getBytes()); // Agregar los bytes del archivo PDF al objeto EmailValuesDTO
            emailService.sendEmailPDF(dto);
            return new ResponseEntity(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Mensaje("Ha ocurrido un error al enviar el correo electrónico"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            return new ResponseEntity(new Mensaje("Las contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
        Optional<Cliente> asesorOpt = asesorService.getByTokenPassword(dto.getTokenPassword());
        if(!asesorOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún asesor con esas credenciales"), HttpStatus.NOT_FOUND);
        Cliente asesor = asesorOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        asesor.setPassword(newPassword);
        asesor.setTokenPassword(null);
        asesorService.save(asesor);
        return new ResponseEntity(new Mensaje("Contraseña actualizada"), HttpStatus.OK);
    }


}
